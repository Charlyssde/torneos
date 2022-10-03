/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cc.torneos.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Carlos Carrillo
 */
public class PersistenceHandler{
    
    private String url = "jdbc:mysql://localhost:3306/torneos?useSSL=false";
    private String username = "admin";
    private String password = "admin";
    
    public PersistenceHandler () {
        
        try {
            Connection connection = DriverManager
                    .getConnection(url, username, password);
            /*
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY)) {
            preparedStatement.setString(1, fullName);
            preparedStatement.setString(2, emailId);
            preparedStatement.setString(3, password);

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();*/
        } catch (SQLException ex) {
        }
        
    }
    
}
