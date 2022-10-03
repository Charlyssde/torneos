package com.cc.torneos.custom;

import com.cc.torneos.db.controller.EquiposController;
import com.cc.torneos.modelos.Equipo;
import com.cc.torneos.modelos.Partido;
import java.util.ArrayList;
import java.util.List;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
    ChoiceBox<String> local = new ChoiceBox<>();
    ChoiceBox<String> visitante = new ChoiceBox<>();
    List<Equipo> data;
    
    public RolCell(List<Equipo> data){
        super();
            label.setMaxWidth(30);
            label.setMinWidth(40);
            label2.setMaxWidth(30);
            label2.setMinWidth(40);
            local.setMaxWidth(100);
            local.setMinWidth(100);
            visitante.setMaxWidth(100);
            visitante.setMinWidth(100);
            
            this.data = data;
            
            List<String> names = new ArrayList<>();
            for(Equipo d : data){
                names.add(d.getNombre().getValue());
            }
            
            ObservableList<String> list = FXCollections.observableArrayList(names);
            local.setItems(list);
            visitante.setItems(list);
            
            hbox.getChildren().addAll(label, local, pane, visitante, label2);
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
                local.setValue(item.getLocal().getValue().getNombre().getValue());
                local.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> ov, Number t, Number t1) {
                        item.setLocal(data.get((Integer)t1));
                    }
                });
                visitante.setValue(item.getVisitante().getValue().getNombre().getValue());
                visitante.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> ov, Number t, Number t1) {
                        item.setVisitante(data.get((Integer)t1));
                    }
                });
                setGraphic(hbox);
            }
        }
    
}
