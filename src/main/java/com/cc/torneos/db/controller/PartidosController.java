/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cc.torneos.db.controller;

import com.cc.torneos.db.ConnectionService;
import com.cc.torneos.modelos.Partido;
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
public class PartidosController {

    private static ConnectionService connectionService;

    public static List<Partido> getAllPartidos(boolean estatus, Long id) throws SQLException {
        List<Partido> result = new ArrayList<>();

        connectionService = ConnectionService.getInstance();
        Connection conn = connectionService.getConnection();

        PreparedStatement pst = conn.prepareStatement("SELECT * FROM partido WHERE estatus = ? AND torneo_id = ?");
        pst.setLong(1, estatus ? 0L : 1L);
        pst.setLong(2, id);
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {

            result.add(new Partido(
                    rs.getLong("id"), 
                    EquiposController.getEquipo(rs.getLong("local")), 
                    EquiposController.getEquipo(rs.getLong("visitante")),
                    rs.getLong("goles_local"), 
                    rs.getLong("goles_visitante"), 
                    rs.getLong("estatus"),
                    TorneoController.getTorneo(rs.getLong("torneo_id")).getId().getValue()));

        }

        return result;
    }

    public static void saveAllPartidos(List<Partido> partidos) throws SQLException {
        connectionService = ConnectionService.getInstance();
        Connection conn = connectionService.getConnection();

        PreparedStatement pst = conn.prepareStatement(
                "INSERT INTO partido (local, visitante, goles_local, goles_visitante, estatus, torneo_id) "
                + " values (?,?,?,?,?, ?)");

        for (Partido p : partidos) {
            pst.setLong(1, p.getLocal().getValue().getId().getValue());
            pst.setLong(2, p.getVisitante().getValue().getId().getValue());
            pst.setLong(3, p.getGoles_local().getValue());
            pst.setLong(4, p.getGoles_visitante().getValue());
            pst.setLong(5, p.getEstatus().getValue());
            pst.setLong(6, p.getTorneo_id().getValue());

            pst.execute();
        }

    }

}
