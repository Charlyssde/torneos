package com.cc.torneos;

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
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Callback;

public class PrimaryController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    private ObservableList<Torneo> data = FXCollections.observableArrayList();

    @FXML
    TableView<Torneo> tbl_torneos;
    @FXML
    TableColumn<Torneo, String> col_nombre;
    @FXML
    TableColumn<Torneo, String> col_acciones;
    @FXML 
    private Button btn_nuevo;


    @Override
    public void initialize(URL url, ResourceBundle rb) {

        btn_nuevo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                DialogNewElementController dialog = new DialogNewElementController(stage, "torneo");
                dialog.showAndWait();
            }
        });
        
        col_nombre.setCellValueFactory(cellData -> cellData.getValue().getNombre());

        Callback<TableColumn<Torneo, String>, TableCell<Torneo, String>> cellFactory
                = new Callback<TableColumn<Torneo, String>, TableCell<Torneo, String>>() {
            @Override
            public TableCell call(final TableColumn<Torneo, String> param) {
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
                                    handleGoTorneo((Torneo) row.getItem(), event);
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

    private void populateTable() {

        data.add(new Torneo("Torneo 1"));
        data.add(new Torneo("Torneo 2"));
        data.add(new Torneo("Torneo 3"));
        data.add(new Torneo("Torneo 4"));
        data.add(new Torneo("Torneo 5"));
        data.add(new Torneo("Torneo 6"));

        tbl_torneos.setItems(data);

    }

    private void handleGoTorneo(Torneo torneo, ActionEvent event) throws IOException {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("menutorneo.fxml"));
        root = loader.load();
        MenutorneoController controller = loader.getController();
        controller.setLabel(torneo.getNombre().getValue());
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 800, 500);
        stage.setScene(scene);
        stage.show();
        
    }

}
