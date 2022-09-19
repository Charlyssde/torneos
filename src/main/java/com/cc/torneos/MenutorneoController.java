/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.cc.torneos;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Carlos Carrillo
 */
public class MenutorneoController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;
    
    @FXML
    private Button btn_equipos;
    @FXML
    private Button btn_roles;
    @FXML
    private Button btn_resultados;
    @FXML
    private Button btn_estadisticas;
    @FXML
    private Label lbl_torneo;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        btn_equipos.setOnAction((ActionEvent t) -> {
            try {
                handleMenuSelect("secondary", t);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        btn_roles.setOnAction((ActionEvent t) -> {
            try {
                handleMenuSelect("roles", t);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        btn_resultados.setOnAction((ActionEvent t) -> {
            try {
                handleMenuSelect("resultados", t);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        btn_estadisticas.setOnAction((ActionEvent t) -> {
            try {
                handleMenuSelect("estadisticas", t);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

    }

    private void handleMenuSelect(String selected, ActionEvent event) throws IOException {
        
        FXMLLoader loader = new FXMLLoader();
        root = loader.load(getClass().getResource(selected + ".fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 800, 500);
        stage.setScene(scene);
        stage.show();
        
    }

    
    public void setLabel(String text){
        this.lbl_torneo.setText(text);
    }
}
