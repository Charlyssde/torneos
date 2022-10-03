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
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author Carlos Carrillo
 */
public class EquipoController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;
    
    @FXML
    TableView<Jugador> tbl_jugadores;
    @FXML
    TableColumn<Jugador, String> col_nombre;
    @FXML
    TableColumn<Jugador, String> col_acciones;
    @FXML private Button btn_nuevo;
    
    @FXML private Label lbl_torneo;
    @FXML private Label lbl_equipo;
    @FXML private Label link_torneos;
    @FXML private Label link_equipos;

        private ObservableList<Jugador> data = FXCollections.observableArrayList();

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btn_nuevo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                DialogNewElementController dialog = new DialogNewElementController(stage, "torneo");
                dialog.showAndWait();
            }
        });
        
        link_torneos.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("primary.fxml"));
                    root = loader.load();
                    stage = (Stage) ((Node) t.getSource()).getScene().getWindow();
                    scene = new Scene(root, 800, 500);
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        
        link_equipos.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("secondary.fxml"));
                    root = loader.load();
                    stage = (Stage) ((Node) t.getSource()).getScene().getWindow();
                    scene = new Scene(root, 800, 500);
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        
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


    private void populateTable() {
        
        tbl_jugadores.setItems(data);
        
    }

    private void handleGoJugador(Jugador jugador, ActionEvent event) {
    }
    
    public void setLabel(String text, String equipo){
        this.lbl_torneo.setText(text);
        this.lbl_equipo.setText(equipo);
    }
    
}
