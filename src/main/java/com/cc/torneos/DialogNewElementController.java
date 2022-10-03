/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.cc.torneos;

import com.cc.torneos.db.controller.EquiposController;
import com.cc.torneos.db.controller.TorneoController;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private Long equipo;
    private Long torneo;
    
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
    
    public void setTorneo(Long torneo){
        this.torneo = torneo;
    }
    
    public void setEquipo(Long equipo){
        this.equipo = equipo;
    }
    
    private void click(String from){
        String name = txt_nombre.getText();
        switch (from) {
            case "torneo":
            {
                try {
                    TorneoController.save(name);
                } catch (SQLException ex) {
                    Logger.getLogger(DialogNewElementController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                break;

            case "equipo":
            {
                try {
                    EquiposController.save(name, torneo);
                } catch (SQLException ex) {
                    Logger.getLogger(DialogNewElementController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                break;

            case "jugador":
                
                break;
            default:
                throw new AssertionError();
        }
        
        
    }
    
}
