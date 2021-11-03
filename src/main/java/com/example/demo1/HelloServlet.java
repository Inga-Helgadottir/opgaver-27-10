package com.example.demo1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String navn = request.getParameter("name");
        String password1 = request.getParameter("pass1");
        String password2 = request.getParameter("pass2");
        response.setContentType("text/html");
        // Hello
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        ServletContext context = request.getServletContext();

        if(password1.equals(password2)){
            List<Bruger> brugerList = (List<Bruger>) context.getAttribute("brugerListe");
            if(brugerList == null){
                brugerList = new ArrayList<>();
            }

            Bruger bruger = new Bruger(navn, password1);
            brugerList.add(bruger);
            context.setAttribute("brugerList", brugerList);
            session.setAttribute("bruger", bruger);

            String sessionId = session.getId();
            request.setAttribute("navn", navn);
            request.setAttribute("sessionId", sessionId);
            session.setAttribute("navn", navn);
            request.getRequestDispatcher("WEB-INF/Bruger.jsp").forward(request, response);
        }else{
            String msg = "Dine passord er ikke ens, prøv igen";
            request.setAttribute("msg", msg);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    public void destroy() {
    }
}