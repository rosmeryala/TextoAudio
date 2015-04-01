/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reporte.db;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author thedarker
 */
public class Conectar {

    static Connection cnn;
    static Context contex;

    private Conectar() {
    }

    private static void conectar() throws NamingException, SQLException {
        InitialContext initContext = new InitialContext();
        contex = (Context) initContext.lookup("java:comp/env");
        DataSource ds = (DataSource) contex.lookup("mipool");
        cnn = ds.getConnection();
    }

    public static Connection getInstace() throws NamingException, SQLException {
        conectar();

        return cnn;

    }

    public static void desconectar() throws Exception {
        try {
            if (cnn != null) {
                cnn.close();
            }
        } catch (SQLException e) {
            throw e;
        }
    }
}
