package com.cc.torneos.custom;

import com.cc.torneos.modelos.Equipo;
import com.cc.torneos.modelos.Partido;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;


public class RolCell extends ListCell<Partido> {

    HBox hbox = new HBox();
    TextField label = new TextField("");
    TextField label2 = new TextField("");
    Pane pane = new Pane();
    ChoiceBox<String> button = new ChoiceBox<>();
    ChoiceBox<String> button2 = new ChoiceBox<>();
    
    public RolCell(){
        super();
            label.setMaxWidth(30);
            label.setMinWidth(40);
            label2.setMaxWidth(30);
            label2.setMinWidth(40);
            button.setMaxWidth(100);
            button.setMinWidth(100);
            button2.setMaxWidth(100);
            button2.setMinWidth(100);
            
            ObservableList<String> list = FXCollections.observableArrayList(
                "Equipo 1", "Equipo 2", "Equipo 3", "Equipo 4");
            button.setItems(list);
            button2.setItems(list);
            button.setValue("Equipo 1");
            button2.setValue("Equipo 2");
            
            hbox.getChildren().addAll(label, button, pane, button2, label2);
            //hbox.getChildren().addAll(button, pane, button2);
            HBox.setHgrow(pane, Priority.ALWAYS);
    }
    
    @Override
        protected void updateItem(Partido item, boolean empty) {
            super.updateItem(item, empty);
            setText(null);  // No text in label of super class
            if (empty) {
                setGraphic(null);
            } else {
                label.setText(item.getLocal().getValue().getNombre().getValue());
                label2.setText(item.getVisitante().getValue().getNombre().getValue());
                setGraphic(hbox);
            }
        }
    
}
