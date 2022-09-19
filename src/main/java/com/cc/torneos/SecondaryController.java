package com.cc.torneos;

import com.cc.torneos.modelos.Equipo;
import com.cc.torneos.modelos.Torneo;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {

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
        controller.setLabel(equipo.getNombre().getValue());
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 800, 500);
        stage.setScene(scene);
        stage.show();
        
    }

    private void populateTable() {
        
        data.add(new Equipo("Equipo 1"));
        data.add(new Equipo("Equipo 2"));
        data.add(new Equipo("Equipo 3"));
        data.add(new Equipo("Equipo 4"));
        data.add(new Equipo("Equipo 5"));
        data.add(new Equipo("Equipo 6"));
        
        tbl_equipos.setItems(data);
        
    }

}
