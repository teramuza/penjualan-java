/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.dbconfig;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import javax.swing.*;
import java.sql.SQLException;
import main.pojo.ResponseSQL;

/**
 *
 * @author tera
 */
public class Database {
    private final String StringDriver = "com.mysql.jdbc.Driver";

    private final String host = "mysql://localhost:3306/";
    private final String dbName = "penjualan";
    
    private final Credential cfg = new Credential();
    
    private final String connectionStr = "jdbc:" + host + dbName + 
            "?user=" + cfg.getUsername() + "&password=" + cfg.getPassword();

    Connection cn = null;

    public void connect() {
        boolean JDBC_Err = false;

        try {
           Class.forName(StringDriver);
        } catch (ClassNotFoundException e) {
            JDBC_Err = true;
            JOptionPane.showMessageDialog(
                null,
                "JDBC Driver tidak ditemukan atau rusak\n"+e,
                "Kesalahan",JOptionPane.ERROR_MESSAGE
            );
        }
        
        if (!JDBC_Err) {
            try {
                cn = DriverManager.getConnection(connectionStr);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(
                    null,
                    "Koneksi ke database gagal\n"+e,
                    "Kesalahan",JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }
    
    public ResponseSQL executeQuery(String sqlQuery) {
        ResponseSQL response;
        try{
            Statement sta = cn.createStatement();
            ResultSet rset = sta.executeQuery(sqlQuery);
            response = new ResponseSQL(true, rset);
        } catch (SQLException e) {
            response = new ResponseSQL(false, e.getMessage());
            String message = "Gagal menjalankan Query\n" + e;
            JOptionPane.showMessageDialog(
                null,
                message,
                "Kesalahan",JOptionPane.ERROR_MESSAGE
            );
            System.out.println("Error: main.dbConfig.Database.executeQuery(" + sqlQuery + ')');
            System.out.println(e);
        }
        return response;
    }
    
    public ResponseSQL executeUpdate(String sqlQuery) {
        ResponseSQL response;
        try{
            Statement sta = cn.createStatement();
            int result = sta.executeUpdate(sqlQuery);
            if (result == 1) {
                response = new ResponseSQL(true, "Insert Data Success");
            } else {
                response = new ResponseSQL(false, "Insert Data Failure");
            }
        } catch (SQLException e) {
            response = new ResponseSQL(false, e.getMessage());
            String message = "Gagal menjalankan Query\n" + e;
            JOptionPane.showMessageDialog(
                null,
                message,
                "Kesalahan",JOptionPane.ERROR_MESSAGE
            );
            System.out.println("Error: main.dbConfig.Database.executeUpdate(" + sqlQuery + ')');
            System.out.println(e);
        }
        return response;
    }
}
