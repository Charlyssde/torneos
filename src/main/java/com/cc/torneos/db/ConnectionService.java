/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cc.torneos.db;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cjcarrillo
 */
public class ConnectionService {
    
    private static final String URL = "jdbc:postgresql://localhost:5432/torneos";
    private static final String USER = "postgres";
    private static final String PASSWORD = "12345";
    
    private Connection conn = null;
    private static ConnectionService _this;
    
    private ConnectionService(){
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static ConnectionService getInstance(){
        if(_this == null){
            _this = new ConnectionService();
        }
        return _this;
    }
    
    public Connection getConnection(){
        return conn;
    }
    
}
