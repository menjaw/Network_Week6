/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Menja
 */
@WebServlet(name = "HeaderInfo", urlPatterns = {"/HeaderInfo"})
public class HeaderInfo extends HttpServlet {

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
            out.println("<title>Servlet HeaderInfo</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HeaderInfo at: " + request.getContextPath() + "</h1>");
            out.print("<table>");
            out.print("<thead>");
            out.print("<tr>");
            out.print("<th>" + "Header" + "</th>");
            out.print("<th>" + "Value" + "</th>");
            out.print("</tr>");
            out.print("</thead>");
            out.print("<tbody>");
            out.print("<tr>" + "<td>" + "User-Agent: " + "</td>" + "<td>" + request.getHeader("User-Agent") + "</td>" + "</tr>");
            out.print("<tr>" + "<td>" + "Host:" + "</td>" + "<td>" + request.getHeader("Host") + "</td></tr>");
            out.print("<tr><td>" + "Connection: " + "</td>" + "<td>" + request.getHeader("Connection") + "</td></tr>");
            out.print("<tr><td>" + "Accept: " + "</td>" + "<td>" + request.getHeader("Accept") + "</td></tr>");
            out.print("<tr><td>" + "Accept encoding: " + "</td>" + "<td>" + request.getHeader("Accept-Encoding") + "</td></tr>");
            out.print("<tr><td>" + "Accept language: " + "</td>" + "<td>" + request.getHeader("Accept-Language") + "</td></tr>");
            response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");//HTTP 1.1
            response.setHeader("Pragma", "no-cache");//HTTP 1.0
            response.setDateHeader("Expires", 0);//proxies
            out.print("<tr><td>" + "" + "</td></tr>");
            out.print("</tbody>");
            out.print("</table>");
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
        processRequest(request, response);
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
