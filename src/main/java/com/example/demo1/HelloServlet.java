package com.example.demo1;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String navn = request.getParameter("name");
        String password1 = request.getParameter("pass1");
        String password2 = request.getParameter("pass2");

        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();

        if(password1.equals(password2)){
//            out.println("<html><body>");
//            out.println("<h1>Dit navn er " + navn + "</h1>");
//            out.println("</body></html>");
            HttpSession session = request.getSession();
            request.setAttribute("navn", navn);
            request.setAttribute("session", session);

            session.setAttribute("navn", navn);

            request.getRequestDispatcher("WEB-INF/Bruger.jsp").forward(request, response);
        }else{
//            out.println("<html><body>");
//            out.println("<h1>Dine passord er ikke ens</h1>");
//            out.println("</body></html>");
            String msg = "Dine passord er ikke ens";
            request.setAttribute("msg", msg);
            request.getRequestDispatcher("index.jsp").forward(request, response);

        }
    }

    public void destroy() {
    }
}