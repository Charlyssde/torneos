/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cc.torneos.modelos;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Carlos Carrillo
 */
public class Equipo {
    
    private StringProperty nombre;
    private LongProperty id;
    private LongProperty torneo_id;
    
    
    public Equipo(String nombre, Long id, Long torneo_id){
        this.nombre = new SimpleStringProperty(nombre);
        this.id = new SimpleLongProperty(id);
        this.torneo_id = new SimpleLongProperty(torneo_id);
    }

    public StringProperty getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    public LongProperty getId() {
        return id;
    }

    public void setId(Long id) {
        this.id.set(id);
    }

    public LongProperty getTorneo_id() {
        return torneo_id;
    }

    public void setTorneo_id(Long torneo_id) {
        this.torneo_id.set(torneo_id);
    }
    
    
    
}
