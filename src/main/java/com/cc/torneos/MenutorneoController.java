/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.cc.torneos;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
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
    @FXML
    private Label link_torneos;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        btn_equipos.setOnAction((ActionEvent t) -> {
            try {

                FXMLLoader loader = new FXMLLoader(getClass().getResource("secondary.fxml"));
                root = loader.load();
                SecondaryController controller = loader.getController();
                controller.setLabel(lbl_torneo.getText());
                stage = (Stage) ((Node) t.getSource()).getScene().getWindow();
                scene = new Scene(root, 800, 500);
                stage.setScene(scene);
                stage.show();

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        btn_roles.setOnAction((ActionEvent t) -> {
            try {

                FXMLLoader loader = new FXMLLoader(getClass().getResource("roles.fxml"));
                root = loader.load();
                RolesController controller = loader.getController();
                controller.setLabel(lbl_torneo.getText());
                stage = (Stage) ((Node) t.getSource()).getScene().getWindow();
                scene = new Scene(root, 800, 500);
                stage.setScene(scene);
                stage.show();
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

    }

    private void handleMenuSelect(String selected, ActionEvent event) throws IOException {

    }

    public void setLabel(String text) {
        this.lbl_torneo.setText(text);
    }
}
