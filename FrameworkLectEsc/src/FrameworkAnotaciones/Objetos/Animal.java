/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrameworkAnotaciones.Objetos;

import FrameworkAnotaciones.FixedWidthField;

/**
 *
 * @author Santiago
 */
public class Animal {
    
    @FixedWidthField(width=15) String nombre;
    @FixedWidthField(width=10) double peso;
    @FixedWidthField(width=20) String caracteristica;
    
    public Animal(){
    
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(String caracteristica) {
        this.caracteristica = caracteristica;
    }

    @Override
    public String toString() {
        return "Animal{" + "nombre=" + nombre + ", peso=" + peso + ", caracteristica=" + caracteristica + '}';
    }
    
    
}
