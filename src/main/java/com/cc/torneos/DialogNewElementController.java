/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.cc.torneos;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.StageStyle;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author cjcarrillo
 */
public class DialogNewElementController extends Dialog<Object>{
   
    @FXML private TextField txt_nombre;
    @FXML private ButtonType btnAceptar;
    @FXML private ButtonType btnCancelar;
    
    public DialogNewElementController(Window owner, String from){
        
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("dialogNewElement.fxml"));
            loader.setController(this);

            DialogPane dialogPane = loader.load();
            dialogPane.lookupButton(btnAceptar).addEventFilter(ActionEvent.ANY, (ActionEvent t) -> {click(from);});
            dialogPane.lookupButton(btnCancelar).addEventFilter(ActionEvent.ANY, (ActionEvent t) -> {close();});
            initOwner(owner);
            initModality(Modality.APPLICATION_MODAL);
            setResizable(false);
            setTitle("Nuevo " + from);
            setDialogPane(dialogPane);
            initStyle(StageStyle.UNDECORATED);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        
    }
    
    private void click(String from){
        
        
        
    }
    
}
