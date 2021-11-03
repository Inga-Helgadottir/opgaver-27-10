package com.example.demo1;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Login", value = "/Login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        ServletContext context = request.getServletContext();

        String navn = request.getParameter("name");
        String password = request.getParameter("password");

        List<Bruger> brugerList = (List<Bruger>) context.getAttribute("brugerListe");

        if(brugerList == null){
            brugerList = new ArrayList<>();
        }

        for (Bruger bruger : brugerList){
            if(bruger.getNavn().equals(navn) && bruger.getPassword().equals(password)){
                session.setAttribute("bruger", bruger);
                session.setAttribute("emneListe", bruger.getBrugerHuskeListe());
                String sessionId = session.getId();
                request.setAttribute("navn", navn);
                request.setAttribute("sessionId", sessionId);
                request.getRequestDispatcher("WEB-INF/Bruger.jsp").forward(request, response);
            }
        }
    }
}
