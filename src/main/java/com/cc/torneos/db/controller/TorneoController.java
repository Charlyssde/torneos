/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cc.torneos.db.controller;

import com.cc.torneos.db.ConnectionService;
import com.cc.torneos.modelos.Equipo;
import com.cc.torneos.modelos.Torneo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cjcarrillo
 */
public class TorneoController {
    
    private static ConnectionService connectionService;
    
    public static List<Torneo> getAllTorneos() throws SQLException{
        List<Torneo> result = new ArrayList<>();
        connectionService = ConnectionService.getInstance();
        Connection conn = connectionService.getConnection();
        
        PreparedStatement pst = conn.prepareStatement("SELECT * FROM torneo");
        ResultSet rs = pst.executeQuery();
        
        while (rs.next()) {            
            result.add(new Torneo(rs.getString("nombre"), rs.getLong("id")));
                    
        }
        return result;
    }
    
    public static Torneo getTorneo(Long id) throws SQLException{
        
        connectionService = ConnectionService.getInstance();
        Connection conn = connectionService.getConnection();

        PreparedStatement pst = conn.prepareStatement("SELECT * FROM torneo WHERE id = ? ");
        pst.setLong(1, id);
        
        ResultSet rs = pst.executeQuery();
        Torneo nuevo = null;
        while (rs.next()){
            nuevo = new Torneo(rs.getString("nombre"), rs.getLong("id"));
        }
        return nuevo;
    }
    
    public static void save(String name) throws SQLException{
        connectionService = ConnectionService.getInstance();
        Connection conn = connectionService.getConnection();
        
        PreparedStatement pst = conn.prepareStatement("INSERT INTO torneo (nombre) values (?)");
        pst.setString(1, name);
        
        pst.execute();
        
    }
    
}
