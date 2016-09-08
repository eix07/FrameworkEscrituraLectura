/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrameworkAnotaciones.Objetos;

import FrameworkAnotaciones.FixedWidthField;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Santiago
 */
public class Casa {
    
    @FixedWidthField(position=1,width=26) String direccion;
    @FixedWidthField(position=2,width=2) int pisos;
    @FixedWidthField(position=3,width=10) double area;
    @FixedWidthField(position=4,width=10) Date fechaCreado;
    
    public Casa(){
    
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getPisos() {
        return pisos;
    }

    public void setPisos(int pisos) {
        this.pisos = pisos;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getFechaCreado() {
        SimpleDateFormat dt1 = new SimpleDateFormat("yyyy/MM/dd");
        
        return (dt1.format(this.fechaCreado));
    }

    public void setFechaCreado(Date fechaCreado) {
        this.fechaCreado = fechaCreado;
    }

    @Override
    public String toString() {
        return "Casa{" + "direccion=" + direccion + ", pisos=" + pisos + ", area=" + area + ", fechaCreado=" + fechaCreado + '}';
    }
    
    
    
}
