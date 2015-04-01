/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.DAO;

import com.proyecto.DTO.Cuento;
import com.reporte.db.Conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.NamingException;
import leetexto.Leer;

/**
 *
 * @author thedarker
 */
public class TextoDAO {

    Context context;
    Connection cnn = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    private int id;
    Leer Leo = new Leer();

    public TextoDAO() {

    }

    public String Insertar(Cuento text) {

        String Salida;
        int resultado;

        try {
            cnn = Conectar.getInstace();
        } catch (NamingException ex) {
            Logger.getLogger(TextoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TextoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            pstm = cnn.prepareStatement("INSERT INTO `ProyectoAudio`.`Texto` (`idTexto`, `Titulo`, `Texto`) VALUES (NULL, ?, ?);");
            pstm.setString(1, text.getTitulo());
            pstm.setString(2, text.getContenido());
            resultado = pstm.executeUpdate();
            if (resultado > 0) {
                Leo.leerTexto(text.getTitulo());
                Leo.leerTexto(text.getContenido());
                Salida = "El registro ha sido satisfactorio";
            } else {
                Leo.leerTexto("Lo sentimos estamos trabajando para que muy pronto puedas seguir utilizando nuestro servicio. Gracias");
                Salida = "Tenmemos un error lo sentimos!! No es tu culpa es de nosotros trabajamos para solucionarlo";

            }
        } catch (SQLException ex) {
            Salida = ex.getMessage();
        }

        return Salida;

    }

    public ArrayList ListarTodo() throws ArrayIndexOutOfBoundsException, ArrayStoreException, SQLException, NamingException {

        try {
            cnn = Conectar.getInstace();
        } catch (SQLException ex) {
            Logger.getLogger(TextoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        ArrayList Texto = new ArrayList();

        try {

            pstm = cnn.prepareStatement("SELECT\n"
                    + "Texto.Titulo,\n"
                    + "Texto.Texto\n"
                    + "FROM\n"
                    + "Texto");
            rs = pstm.executeQuery();

            while (rs.next()) {
                Cuento TextoDto = new Cuento();
                TextoDto.setTitulo(rs.getString(1));
                TextoDto.setContenido(rs.getString(2));
                Texto.add(TextoDto);

            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pstm != null) {
                pstm.close();
            }
            if (cnn != null) {
                cnn.close();
            }
        }
        return Texto;

    }

    public Cuento MostrarUno(String temp) throws SQLException {

        try {
            cnn = Conectar.getInstace();
        } catch (NamingException ex) {
            Logger.getLogger(TextoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TextoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        Cuento TextoDto = new Cuento();

        try {
            pstm = cnn.prepareStatement("SELECT Usuarios.username, Texto.Titulo, Texto.Texto FROM TipoUsuario INNER JOIN Usuarios ON Usuarios.TipoUsuario_category_id = TipoUsuario.category_id , Texto WHERE  username = ?");
            pstm.setString(1, temp);
            rs = pstm.executeQuery();
            while (true) {
                TextoDto.setUsuario(rs.getString(1));
                TextoDto.setTitulo(rs.getString(2));
                TextoDto.setContenido(rs.getString(3));
            }

        } catch (SQLException ex) {
            throw ex;
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pstm != null) {
                pstm.close();
            }

            if (cnn != null) {
                cnn.close();
            }
        }

    }

    //prueba texto 
    public Cuento Sonidos(String temp) {

        //Leer Leo = new Leer();

        Leo.leerTexto(temp);

        return null;
    }

}
