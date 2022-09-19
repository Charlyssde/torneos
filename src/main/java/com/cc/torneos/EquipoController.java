/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.cc.torneos;

import com.cc.torneos.modelos.Equipo;
import com.cc.torneos.modelos.Jugador;
import com.cc.torneos.modelos.Torneo;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author Carlos Carrillo
 */
public class EquipoController implements Initializable {

    @FXML
    TableView<Jugador> tbl_jugadores;
    @FXML
    TableColumn<Jugador, String> col_nombre;
    @FXML
    TableColumn<Jugador, String> col_acciones;

        private ObservableList<Jugador> data = FXCollections.observableArrayList();

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        col_nombre.setCellValueFactory(cellData -> cellData.getValue().getNombre());

        Callback<TableColumn<Jugador, String>, TableCell<Jugador, String>> cellFactory
                = new Callback<TableColumn<Jugador, String>, TableCell<Jugador, String>>() {
            @Override
            public TableCell call(final TableColumn<Jugador, String> param) {
                final TableCell<Jugador, String> cell = new TableCell<Jugador, String>() {
                    final Button btn2 = new Button("Ir");

                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                            setText(null);
                        } else {
                            btn2.setOnAction(event -> {

                                TableRow row = this.getTableRow();
                                handleGoJugador((Jugador) row.getItem(), event);
                            });
                            HBox managebtn = new HBox(btn2);
                            managebtn.setStyle("-fx-alignment:center");
                            HBox.setMargin(btn2, new Insets(2, 3, 0, 2));

                            setGraphic(managebtn);
                            setText(null);
                        }
                    }

                };
                return cell;
            }
        };

        col_acciones.setCellFactory(cellFactory);

        populateTable();
    }

    void setLabel(String value) {
    }

    private void populateTable() {
        
        data.add(new Jugador("Jugador 1"));
        data.add(new Jugador("Jugador 2"));
        data.add(new Jugador("Jugador 3"));
        data.add(new Jugador("Jugador 4"));
        data.add(new Jugador("Jugador 5"));
        data.add(new Jugador("Jugador 6"));
        
        tbl_jugadores.setItems(data);
        
    }

    private void handleGoJugador(Jugador jugador, ActionEvent event) {
    }
}
