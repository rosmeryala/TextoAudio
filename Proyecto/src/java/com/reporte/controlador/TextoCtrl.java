/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reporte.controlador;

import com.proyecto.DAO.TextoDAO;
import com.proyecto.DTO.Cuento;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author thedarker
 */
public class TextoCtrl extends HttpServlet {

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
            throws ServletException, IOException, ArrayIndexOutOfBoundsException, NamingException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        Cuento TextoDto = new Cuento();
        TextoDAO TextDao = new TextoDAO();

        if (request.getParameter("reg") != null && request.getParameter("reg").equals("Registrar")) {

            TextoDto.setTitulo(request.getParameter("Titulo"));
            TextoDto.setContenido(request.getParameter("Texto"));

            String salida1 = TextDao.Insertar(TextoDto);

            response.sendRedirect("RegTexto.jsp?msg=" + salida1);

        } else if ("Mostrar".equals(request.getParameter("accion"))) {

            try {

                ArrayList<Cuento> inc = TextDao.ListarTodo();
                request.getSession(false).setAttribute("Mostrar", inc);
                response.sendRedirect("Mostrar.jsp");

            } catch (SQLException ex) {
                Logger.getLogger(TextoCtrl.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if ("Reproducir".equals(request.getParameter("accion"))) {

            TextoDto = TextDao.Sonidos(request.getParameter("texto"));

            response.sendRedirect("Mostrar.jsp");

        }

        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TextoCtrl</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TextoCtrl at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
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
        try {
            processRequest(request, response);
        } catch (ArrayIndexOutOfBoundsException ex) {
            Logger.getLogger(TextoCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(TextoCtrl.class.getName()).log(Level.SEVERE, null, ex);
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
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ArrayIndexOutOfBoundsException ex) {
            Logger.getLogger(TextoCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(TextoCtrl.class.getName()).log(Level.SEVERE, null, ex);
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
