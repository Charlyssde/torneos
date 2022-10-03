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
public class EquiposController {

    private static ConnectionService connectionService;

    public static List<Equipo> getAllEquipos(Long id) throws SQLException {
        List<Equipo> result = new ArrayList<>();
        connectionService = ConnectionService.getInstance();
        Connection conn = connectionService.getConnection();

        PreparedStatement pst = conn.prepareStatement("SELECT * FROM equipo WHERE torneo_id = ? ");
        pst.setLong(1, id);
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            result.add(new Equipo(rs.getString("nombre"), rs.getLong("id"), rs.getLong("torneo_id")));

        }
        return result;
    }

    public static void save(String name, Long torneo_id) throws SQLException {
        connectionService = ConnectionService.getInstance();
        Connection conn = connectionService.getConnection();

        PreparedStatement pst = conn.prepareStatement("INSERT INTO torneos (nombre, equipo_id) values (?, ?)");
        pst.setString(1, name);
        pst.setLong(2, torneo_id);

        pst.executeQuery();

    }

}
