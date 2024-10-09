package com.dam.jonathan.exavaluat4;

import java.io.Serializable;
import java.util.Date;

public class Pizza implements Serializable {
    private Date IniciComanda;
    private boolean setas = false;

    public String getTamaño() {
        return tamaño;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    public boolean isPiña() {
        return piña;
    }

    public boolean isSetas() {
        return setas;
    }

    public void setSetas(boolean setas) {
        this.setas = setas;
    }

    public void setPiña(boolean piña) {
        this.piña = piña;
    }

    private boolean piña = false;
    private String nombre = "";

    public String getTipoMasa() {
        return tipoMasa;
    }

    public void setTipoMasa(String tipoMasa) {
        this.tipoMasa = tipoMasa;
    }

    private String tamaño = "Pequeño";
    private String tipoMasa = "Normal";

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    private int base = 1;
    private double precio = 5;

    public Pizza() {
        IniciComanda = new Date();

    }
    private boolean esVegetariana;

    private boolean esVegana;

    public boolean isEsVegana() {
        return esVegana;
    }

    public void setEsVegana(boolean esVegana) {
        this.esVegana = esVegana;
    }

    public boolean isEsVegetariana() {
        return esVegetariana;
    }

    public void setEsVegetariana(boolean esVegetariana) {
        this.esVegetariana = esVegetariana;
    }

    private boolean esPicante;
    private int cantidad;
    private boolean quezoExtra;
    private boolean masaRellena;
    public void canviarBase() {
        if (base == 1){
            base = 2;
        }else {
            base = 1;
        }
    }
}