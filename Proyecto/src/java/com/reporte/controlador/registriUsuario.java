/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reporte.controlador;

import com.proyecto.DAO.UsuarioDAO;
import com.proyecto.DTO.TipoUsuario;
import com.proyecto.DTO.Usuarios;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
public class registriUsuario extends HttpServlet {

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
            throws ServletException, IOException, SQLException, NamingException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        UsuarioDAO userdao = new UsuarioDAO();
        Usuarios users = new Usuarios();

        if (request.getParameter("Ingreso") != null && request.getParameter("Ingreso").equals("Ingresar")) {
            String user = request.getParameter("Usuario");
            String clave = request.getParameter("Password");
            String salida = "";
            TipoUsuario TipoU = null;

            try {
                TipoU = userdao.validarUsuario(user, clave);
                salida = (String) TipoU.getMensaje();
                if (salida.equalsIgnoreCase("QueryOk")) {
                    session.setAttribute("usuario", TipoU.getUsuario());
                    session.setAttribute("password", TipoU.getContraseña());
                    session.setAttribute("correo", TipoU.getCorreo());
                    session.setAttribute("id", TipoU.getIdU());

                    response.sendRedirect("Administrador.jsp");
                } else {
                    response.sendRedirect("Login.jsp?msg=" + salida);
                }
            } catch (SQLException ex) {
                //out.print(rtdo);
                response.sendRedirect("Login.jsp?msg=" + "Error:" + ex.getMessage());
            }

        } else if (request.getParameter("reg") != null && request.getParameter("reg").equals("Registrar")) {
            users.setUsuario(request.getParameter("usuario"));
            users.setCorreo(request.getParameter("correo"));
            users.setContraseña(request.getParameter("password"));

            try {
                String salida1 = userdao.Insertar(users);
                response.sendRedirect("Login.jsp?msg=" + salida1);
            } catch (SQLException ex) {
                response.sendRedirect("Registro.jsp" + ex.getMessage());
            }
        }

        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet registriUsuario</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet registriUsuario at " + request.getContextPath() + "</h1>");
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
        } catch (SQLException | NamingException ex) {
            Logger.getLogger(registriUsuario.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (SQLException | NamingException ex) {
            Logger.getLogger(registriUsuario.class.getName()).log(Level.SEVERE, null, ex);
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
