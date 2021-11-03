package com.example.demo1;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.*;

@WebServlet(name = "TilføjEmne", value = "/TilføjEmne")
public class TilføjEmne extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/OversigtOverAlleEmner.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String emne = request.getParameter("emne");

        HttpSession session = request.getSession();
        ServletContext context = request.getServletContext();

//        HashMap<String, String> emneListeMedBruger = (HashMap<String, String>) session.getAttribute("emneListe");

        Set<String> emneListeContext = (Set<String>) context.getAttribute("emneListeContext");

        if(emneListeContext == null){
            emneListeContext = new HashSet<>();
        }

        emneListeContext.add(emne);
        int contextSize = emneListeContext.size();

        Set<String> emneListe = (Set<String>) session.getAttribute("emneListe");

        if(emneListe == null){
            emneListe = new HashSet<>();
        }

        emneListe.add(emne);

        Bruger bruger = (Bruger) session.getAttribute("bruger");
        bruger.setBrugerHuskeListe(emneListe);

        int emneListeSize = emneListe.size();

        context.setAttribute("emneListeContext", emneListeContext);
        context.setAttribute("contextSize", contextSize);

        session.setAttribute("emneListe", emneListe);
        session.setAttribute("emneListeSize", emneListeSize);

        request.getRequestDispatcher("WEB-INF/Bruger.jsp").forward(request, response);
/*
        ServletContext servletContext = request.getServletContext();
        String name = (String) servletContext.getAttribute("navn");
        List<String> alleBrugeresEmner = (List<String>) servletContext.getAttribute("alleBrugeresEmner");

        if(alleBrugeresEmner == null){
            alleBrugeresEmner = new ArrayList<>();
        }

        if(!alleBrugeresEmner.contains(emne)){

            alleBrugeresEmner.add(emne);

            servletContext.setAttribute("alleBrugeresEmner", alleBrugeresEmner);

            emneListeMedBruger.put(name, emne);

        }

        if(emneListe.contains(emne)){

            emneListe.add(emne);

            session.setAttribute("emneListe", emneListe);

            emneListeMedBruger.put(name, emne);

        }

        request.getRequestDispatcher("WEB-INF/Bruger.jsp").forward(request, response);*/
    }
}
