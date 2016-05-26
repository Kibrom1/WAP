/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs545.student.servlet;

import edu.mum.cs45.student.Student;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kb
 */
@WebServlet(name = "StudentServlet", urlPatterns = {"/StudentServlet"})
public class StudentServlet extends HttpServlet {

    List<Student> listStudent = new ArrayList<>();

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
            out.println("<title>Servlet StudentServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet StudentServlet at " + request.getContextPath() + "</h1>");
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

        RequestDispatcher view;
        Student returnedStudent = null;
        try {
            if (request.getParameter("find") != null) {
                int id = Integer.parseInt(request.getParameter("id"));
                returnedStudent = findStudent(id);
                request.setAttribute("student", returnedStudent);
                request.getSession().setAttribute("studentDeleteId", returnedStudent.getId());

                view = request.getRequestDispatcher("detail.jsp");
                view.forward(request, response);
            } else if (request.getParameter("cancelFind") != null) {
                view = request.getRequestDispatcher("home.jsp");
                view.forward(request, response);
            } else if (request.getParameter("cancelDelete") != null) {
                view = request.getRequestDispatcher("home.jsp");
                view.forward(request, response);
            } else if (request.getParameter("deleteStudent") != null) {
               // int stdId = Integer.parseInt(request.getSession().getAttribute("studentDeleteId"));
                int stdId = Integer.parseInt(request.getSession().getAttribute("studentDeleteId").toString());
               Student stdDelete = findStudent(stdId);
                if (stdDelete != null) {
                    listStudent.remove(stdDelete);
                    request.getServletContext().setAttribute("listStudent", listStudent);
                    view = request.getRequestDispatcher("home.jsp");
                    view.forward(request, response);
                }
            } else {
                view = request.getRequestDispatcher("home.jsp");
                view.forward(request, response);
            }
        } catch (Exception e) {
            request.setAttribute("errorMessage", e.getMessage());
            view = request.getRequestDispatcher("error.jsp");
            view.forward(request, response);
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    Student findStudent(int id) {

        Student returnedStudent = null;
        for (Student std : listStudent) {
            if (std.getId() == id) {
                returnedStudent = std;
                break;
            }
        }
        return returnedStudent;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Student student;
        RequestDispatcher view;
        try {
            if (request.getParameter("add") != null) {
                int id = Integer.parseInt(request.getParameter("id"));
                String name = request.getParameter("name");
                double gpa = Double.parseDouble(request.getParameter("gpa"));
                String gender = request.getParameter("gender");
                student = new Student(id, name, gpa, gender);
                listStudent.add(student);
                request.getServletContext().setAttribute("listStudent", listStudent);
                view = request.getRequestDispatcher("home.jsp");
                view.forward(request, response);
            } else if (request.getParameter("cancelAdd") != null) {
                view = request.getRequestDispatcher("home.jsp");
                view.forward(request, response);
            }
        } catch (Exception e) {
            request.setAttribute("errorMessage", e.getMessage());
            view = request.getRequestDispatcher("error.jsp");
            view.forward(request, response);
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
