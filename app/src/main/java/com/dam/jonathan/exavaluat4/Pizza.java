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

    public double getPrecio() {
        double preu = 5;
        switch (getTamaño()) {
            case "pequeña":
                preu += 0.5;
                break;
            case "mediana":
                preu += 1;
                break;
            case "grande":
                preu += 1.5;
                break;
        }
        if(isEsPicante()) {
            preu += 0.5;
        }
        if(isMasaRellena()){
            preu += 0.5;
        }
        if (isQuezoExtra()){
            preu += 0.5;

        }
        if (isSetas()) {
            preu += 0.5;
        }
        if (isPiña()) {
            preu += 0.5;
        }
        precio = preu;
        return preu;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
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

    private String tamaño = "pequeña";
    private String tipoMasa = "Normal";

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    private int base = 1;
    private double precio = 5;

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setEsVegetariana(boolean esVegetariana) {
        this.esVegetariana = esVegetariana;
    }

    private boolean esPicante;
    private int cantidad = 1;
    private double precioTotal;


    public double getPrecioTotal() {
        return precio*cantidad;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public Date getIniciComanda() {
        return IniciComanda;
    }

    public void setIniciComanda(Date iniciComanda) {
        IniciComanda = iniciComanda;
    }

    public boolean isQuezoExtra() {
        return quezoExtra;
    }

    public boolean isEsPicante() {
        return esPicante;
    }

    public void setEsPicante() {
        if (esPicante){
            esPicante = false;
        }else {
            esPicante = true;

        }
    }

    public void setQuezoExtra() {
        if (quezoExtra){
            quezoExtra = false;
        }else {
            quezoExtra = true;

        }
    }

    private boolean quezoExtra;
    private boolean masaRellena;

    public boolean isMasaRellena() {
        return masaRellena;
    }

    public void setMasaRellena() {
        if (masaRellena){
            masaRellena = false;
        }else {
            masaRellena = true;

        }
    }

    public void canviarBase() {
        if (base == 1){
            base = 2;
        }else {
            base = 1;
        }
    }
}