package com.cc.torneos;

import com.cc.torneos.EquipoController;
import com.cc.torneos.db.controller.EquiposController;
import com.cc.torneos.modelos.Equipo;
import com.cc.torneos.modelos.Torneo;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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

public class SecondaryController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    private ObservableList<Equipo> data = FXCollections.observableArrayList();

    @FXML
    TableView<Equipo> tbl_equipos;
    @FXML
    TableColumn<Equipo, String> col_nombre;
    @FXML
    TableColumn<Equipo, String> col_acciones;
    @FXML
    private Button btn_nuevo;
    @FXML
    private Label link_torneos;
    @FXML
    private Label lbl_torneo;

    private Long torneo_id;
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        btn_nuevo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                DialogNewElementController dialog = new DialogNewElementController(stage, "equipo");
                dialog.setTorneo(torneo_id);
                dialog.showAndWait();
                populateTable();
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

        col_nombre.setCellValueFactory(cellData -> cellData.getValue().getNombre());

        Callback<TableColumn<Equipo, String>, TableCell<Equipo, String>> cellFactory
                = new Callback<TableColumn<Equipo, String>, TableCell<Equipo, String>>() {
            @Override
            public TableCell call(final TableColumn<Equipo, String> param) {
                final TableCell<Torneo, String> cell = new TableCell<Torneo, String>() {
                    final Button btn2 = new Button("Ir");

                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                            setText(null);
                        } else {
                            btn2.setOnAction(event -> {

                                try {
                                    TableRow row = this.getTableRow();
                                    handleGoEquipo((Equipo) row.getItem(), event);
                                } catch (IOException ex) {
                                    ex.printStackTrace();
                                }
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

    private void handleGoEquipo(Equipo equipo, ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("equipo.fxml"));
        root = loader.load();
        EquipoController controller = loader.getController();//TODO:Change this
        controller.setLabel(lbl_torneo.getText(), equipo.getNombre().getValue());
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 800, 500);
        stage.setScene(scene);
        stage.show();

    }

    private void populateTable() {
        try {
            data.addAll(EquiposController.getAllEquipos(this.torneo_id));
            tbl_equipos.setItems(data);
        } catch (SQLException ex) {
            Logger.getLogger(SecondaryController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void setLabel(String text) {
        this.lbl_torneo.setText(text);
    }

    public void setTorneo_id(Long torneo_id) {
        this.torneo_id = torneo_id;
    }
    
}
