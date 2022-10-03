/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cc.torneos.modelos;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 *
 * @author cjcarrillo
 */
public class Partido {
    
    private LongProperty id;
    private ObjectProperty<Equipo> local;
    private ObjectProperty<Equipo> visitante;
    private LongProperty goles_local;
    private LongProperty goles_visitante;
    private LongProperty estatus;

    public Partido(Long id, Equipo local, Equipo visitante, Long goles_local, Long goles_visitante, Long estatus) {
        this.id = new SimpleLongProperty(id);
        this.local = new SimpleObjectProperty<>(local);
        this.visitante = new SimpleObjectProperty<>(visitante);
        this.goles_local = new SimpleLongProperty(goles_local);
        this.goles_visitante = new SimpleLongProperty(goles_visitante);
        this.estatus = new SimpleLongProperty(estatus);
    }

    public Partido(Equipo local, Equipo visita){
        this.local = new SimpleObjectProperty<>(local);
        this.visitante = new SimpleObjectProperty<>(visita);
        this.goles_local = new SimpleLongProperty(0L);
        this.goles_visitante = new SimpleLongProperty(0L);
        this.estatus = new SimpleLongProperty(0L);
    }
    
    public LongProperty getId() {
        return id;
    }

    public void setId(Long id) {
        this.id.set(id);
    }

    public ObjectProperty<Equipo> getLocal() {
        return local;
    }

    public void setLocal(Equipo local) {
        this.local.set(local);
    }

    public ObjectProperty<Equipo> getVisitante() {
        return visitante;
    }

    public void setVisitante(Equipo visitante) {
        this.visitante.set(visitante);
    }

    public LongProperty getGoles_local() {
        return goles_local;
    }

    public void setGoles_local(Long goles_local) {
        this.goles_local.set(goles_local);
    }

    public LongProperty getGoles_visitante() {
        return goles_visitante;
    }

    public void setGoles_visitante(Long goles_visitante) {
        this.goles_visitante.set(goles_visitante);
    }

    public LongProperty getEstatus() {
        return estatus;
    }

    public void setEstatus(Long estatus) {
        this.estatus.set(estatus);
    }
    
    
}
