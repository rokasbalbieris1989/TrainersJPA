/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Trainer;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.TrainerService;

/**
 *
 * @author me
 */
public class UpdateTrainer extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdateTrainer</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateTrainer at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("update"));
        //setAttribute id, rd.forward -> jsp: in useBean call student dao -> get.Everything
        TrainerService ts = new TrainerService();
        Trainer tr= ts.getTrainerByID(id);
        RequestDispatcher rd = request.getRequestDispatcher("updatetrainer.jsp");
        request.setAttribute("title", "Update Trainer");
        request.setAttribute("trainer", tr);
        rd.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Trainer tr ;
        response.setContentType("text/html;charset=UTF-8");
        TrainerService ts = new TrainerService();
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdateTrainer</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateTrainer at " + request.getContextPath() + "</h1>");
            int id = Integer.parseInt(request.getParameter("update"));
            tr = new Trainer(request.getParameter("name"),
                            request.getParameter("surname"),
                            request.getParameter("subject"));
            if(ts.updateTrainer(id,tr) ) out.println("<h2>Student updated!</h2>");
            else out.println("<h2>Student not updated 1!</h2>");
            out.println("<a href=TrainerServlet >Go back to Trainers</a>");
            out.println();
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
