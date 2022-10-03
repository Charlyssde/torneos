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
public class Jugador {
    
    private StringProperty nombre;
    private LongProperty equipo_id;
    private LongProperty id;
    private LongProperty goles;
    
    
    public Jugador (String nombre, Long equipo_id, Long id, Long goles){
        this.nombre = new SimpleStringProperty(nombre);
        this.equipo_id = new SimpleLongProperty(equipo_id);
        this.id = new SimpleLongProperty(id);
        this.goles = new SimpleLongProperty(goles);
    }

    public StringProperty getNombre() {
        return nombre;
    }

    public void setNombre(StringProperty nombre) {
        this.nombre = nombre;
    }

    public LongProperty getEquipo_id() {
        return equipo_id;
    }

    public void setEquipo_id(Long equipo_id) {
        this.equipo_id.set(equipo_id);
    }

    public LongProperty getId() {
        return id;
    }

    public void setId(Long id) {
        this.id.set(id);
    }

    public LongProperty getGoles() {
        return goles;
    }

    public void setGoles(Long goles) {
        this.goles.set(goles);
    }
    
}
