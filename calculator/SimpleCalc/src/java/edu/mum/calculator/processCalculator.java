/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.calculator;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kb
 */
public class processCalculator extends HttpServlet {

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
            out.println("<title>Servlet processCalculator</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet processCalculator at " + request.getContextPath() + "</h1>");
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
        //processRequest(request, response);

        String add = request.getParameter("add");
        String subtract = request.getParameter("subtract");
        double num1 = 0.0;
        double num2 = 0.0;
        boolean format=true;
        try {
            num1 = Double.parseDouble(request.getParameter("num1"));
            num2 = Double.parseDouble(request.getParameter("num2"));
        } catch (Exception ex) {
            format = false;
        }
        String sign = "+";
        boolean inRange = true;
        PrintWriter out;
        out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet processCalculator</title>");
        out.println("</head>");
        out.println("<body>");
      
        if ((!format) || (num1 < 0 || num1 > 100 || num2 < 0 || num2 > 100)) {
            out.println("<h3>Number one and Number two should be between 1 and 100 or the format is not right</h3>");
            inRange = false;
        }
        if (inRange) {
            double result = 0.0;
            if (add != null) {
                result = num1 + num2;
            } else if (subtract != null) {
                result = num1 - num2;
                sign = "-";
            }
            out.print("<h3>" + num1 + " " + sign + " " + num2 + " =  " + result + "</h3>");
        }
        out.print("<Form action = \"index.jsp\">");
        out.print("<INPUT type=\"submit\" value=\"Back\" />");
        out.print("</Form>");
        out.println("</body>");
        out.println("</html>");
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
        processRequest(request, response);
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
