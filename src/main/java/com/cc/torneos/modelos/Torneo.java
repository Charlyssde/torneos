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
public class Torneo {
    
    private StringProperty nombre;
    private LongProperty id;
    
    public Torneo(String nombre, Long id){
        this.nombre = new SimpleStringProperty(nombre);
        this.id = new SimpleLongProperty(id);
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
    
    
}
