package com.example.demo1;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "TilføjEmne", value = "/TilføjEmne")
public class TilføjEmne extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String emne = request.getParameter("emne");
        log("emnet er " + emne);

        HttpSession session = request.getSession();

        List<String> emneListe = (List<String>) session.getAttribute("emneListe");

        if(emneListe == null){
            emneListe = new ArrayList<>();
        }

        ServletContext servletContext = request.getServletContext();

        List<String> alleBrugeresEmner = (List<String>) servletContext.getAttribute("alleBrugeresEmner");

        if(alleBrugeresEmner == null){
            alleBrugeresEmner = new ArrayList<>();
        }

        if(!alleBrugeresEmner.contains(emne)){

            alleBrugeresEmner.add(emne);

            servletContext.setAttribute("alleBrugeresEmner", alleBrugeresEmner);

        }

        if(emneListe.contains(emne)){

            emneListe.add(emne);

            session.setAttribute("emneListe", emneListe);
        }

        request.getRequestDispatcher("WEB-INF/Bruger.jsp").forward(request, response);
    }
}
