/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.DAO;

import com.proyecto.DTO.TipoUsuario;
import com.proyecto.DTO.Usuarios;
import com.reporte.db.Conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author thedarker
 */
public class UsuarioDAO {

    Context context;
    Connection cnn = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    private int id;

    public UsuarioDAO() {

    }

    public String Insertar(Usuarios user) throws SQLException, NumberFormatException {
        /*try {       
         InitialContext initContext= new InitialContext();
         context= (Context) initContext.lookup("java:comp/env");
         DataSource ds= (DataSource) context.lookup("pool");
         try {
         cnn=ds.getConnection();
         } catch (SQLException ex) {
         Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
         } catch (NamingException ex) {
         Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
         }*/

        String salida;
        //Usuarios usuer = new Usuarios();
        int resultado;
        try {
            cnn = Conectar.getInstace();
        } catch (NamingException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {

            pstm = cnn.prepareStatement("INSERT INTO `ProyectoAudio`.`Usuarios` (`username`, `email`, `password`, `create_time`, `TipoUsuario_category_id`) VALUES (?, ?, md5(?), CURRENT_TIMESTAMP, '2');");
            pstm.setString(1, user.getUsuario());
            pstm.setString(2, user.getCorreo());
            pstm.setString(3, user.getContraseña());
            resultado = pstm.executeUpdate();

            if (resultado > 0) {
                salida = "El registro fue creado Exitosamente";
            } else {
                salida = "Error en el registro verifique los datos o comuniquese con el administrador";
            }
        } catch (SQLException ex) {
            salida = ex.getMessage();
        } catch (NumberFormatException num) {
            salida = num.getMessage();
        }
        return salida;

    }

    public TipoUsuario validarUsuario(String u, String p) throws SQLException {
        /*  try {       
         InitialContext initContext= new InitialContext();
         context= (Context) initContext.lookup("java:comp/env");
         DataSource ds= (DataSource) context.lookup("mipool");
         try {
         cnn=ds.getConnection();
         } catch (SQLException ex) {
         Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
         } catch (NamingException ex) {
         Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
         }*/
        Usuarios usevali = new Usuarios();
        TipoUsuario TUser = new TipoUsuario();
        String salida;
        try {
            cnn = Conectar.getInstace();
            pstm = cnn.prepareStatement("select `username` , `password`, `email`, `TipoUsuario_category_id` from Usuarios where `username` = ? and `password`= md5(?)");

            pstm.setString(1, u);
            pstm.setString(2, p);
            rs = pstm.executeQuery();

            if (rs.next()) {
                TUser.setUsuario(rs.getString("username"));
                TUser.setContraseña(rs.getString("password"));
                TUser.setCorreo(rs.getString("email"));
                TUser.setIdU(Integer.parseInt(rs.getString("TipoUsuario_category_id")));

                salida = "QueryOk";
                TUser.setMensaje(salida);
            } else {
                salida = "Ohh!! Ha introducido un inicio de sesion no valido";
                TUser.setMensaje(salida);
            }

        } catch (SQLException ex) {
            salida = ex.getMessage();

        } catch (NamingException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (rs != null) {
                rs.close();
            }
        }
        return TUser;
    }
}
