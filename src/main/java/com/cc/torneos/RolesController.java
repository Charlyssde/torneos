/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.cc.torneos;

import com.cc.torneos.custom.RolCell;
import com.cc.torneos.db.controller.EquiposController;
import com.cc.torneos.db.controller.PartidosController;
import com.cc.torneos.modelos.Equipo;
import com.cc.torneos.modelos.Partido;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author Carlos Carrillo
 */
public class RolesController implements Initializable {

    private Long torneo_id;
    private List<Partido> partidos;
    private List<Equipo> equipos;
    
    @FXML
    private ListView list_partidos;
    @FXML
    private Button btn_nuevo;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        btn_nuevo.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {

                try {
                    handleNewRole();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }
        });
        
        try {
            partidos =  PartidosController.getAllPartidos(true, torneo_id);
            ObservableList<Partido> list = FXCollections.observableArrayList();
            list.addAll(partidos);
            list_partidos.setItems(list);
            list_partidos.setCellFactory(new Callback<ListView<String>, ListCell<Partido>>() {
                @Override
                public ListCell<Partido> call(ListView<String> param) {
                    return new RolCell();
                }
            });
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void handleNewRole() throws SQLException {
        
        equipos = EquiposController.getAllEquipos(torneo_id);
        List<Partido> nuevos = new ArrayList<>();
        
        for(Equipo local : equipos){
            for(Equipo visita : equipos){
                System.out.println("Visita-> " + visita.getNombre().getValue());
                System.out.println("Local-> " + local.getNombre().getValue());
                if(!visita.getId().getValue().equals(local.getId().getValue())){
                    System.out.println("Es diferente");
                    if(!partidoExists(visita, local) && !partidoRol(nuevos, visita, local)){
                        System.out.println("No existen");
                        nuevos.add(new Partido(local, visita));
                    }
                    
                }
            }
        }
        list_partidos.setItems(FXCollections.observableArrayList(nuevos));
        list_partidos.setCellFactory(new Callback<ListView<String>, ListCell<Partido>>() {
                @Override
                public ListCell<Partido> call(ListView<String> param) {
                    return new RolCell();
                }
            });
        
    }

    public void setLabel(String text) {
    }

    public void setId(Long id) {
        this.torneo_id = id;
    }

    private boolean partidoExists(Equipo visita, Equipo local) {
        Long v = visita.getId().getValue();
        Long l = local.getId().getValue();
        return  partidos.stream().filter
            (p -> 
                (p.getLocal().getValue().getId().getValue().equals(v) ||
                   p.getVisitante().getValue().getId().getValue().equals(v)) &&
                (p.getLocal().getValue().getId().getValue().equals(l)||
                    p.getVisitante().getValue().getId().getValue().equals(l))
            ).count() != 0L;
        
    }

    private boolean partidoRol(List<Partido> nuevos,Equipo visita, Equipo local) {
        
        Long v = visita.getId().getValue();
        Long l = local.getId().getValue();
        return  nuevos.stream().filter
            (p -> 
                p.getLocal().getValue().getId().getValue().equals(v) ||
                   p.getVisitante().getValue().getId().getValue().equals(v) ||
                p.getLocal().getValue().getId().getValue().equals(l) ||
                    p.getVisitante().getValue().getId().getValue().equals(l)
            ).count() != 0L;
        
    }
}
