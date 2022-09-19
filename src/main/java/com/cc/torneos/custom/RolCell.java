package com.cc.torneos.custom;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;


public class RolCell extends ListCell<String> {

    HBox hbox = new HBox();
    Label label = new Label("(empty)");
    Pane pane = new Pane();
    Button button = new Button("");
    
    public RolCell(){
        super();
            hbox.getChildren().addAll(label, pane, button);
            HBox.setHgrow(pane, Priority.ALWAYS);
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                }
            });
    }
    
    @Override
        protected void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);
            setText(null);  // No text in label of super class
            if (empty) {
                setGraphic(null);
            } else {
                label.setText(item!=null ? item : "<null>");
                setGraphic(hbox);
            }
        }
    
}
