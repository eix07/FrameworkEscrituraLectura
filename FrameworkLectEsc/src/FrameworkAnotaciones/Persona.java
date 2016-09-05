/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrameworkAnotaciones;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Santiago
 */
@FixedName(className="FrameworkAnotaciones.Persona")
public class Persona {
    
    @FixedWidthField(position=1,width=20) String nombre;
    @FixedWidthField(position=2,width=25) String apellido;
    @FixedWidthField(position=3,width=10) Date fechaNacimiento;
    @FixedWidthField(position=4,width=5) double altura;
    
    public Persona(){
    
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFechaNacimiento() {
        SimpleDateFormat dt1 = new SimpleDateFormat("yyyy/MM/dd");
        
        return (dt1.format(this.fechaNacimiento));
    }

    public void setFechaNacimiento(Date fechaNacimiento) throws ParseException {
        
        this.fechaNacimiento=fechaNacimiento;
        
        
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", apellido=" + apellido + ", fechaNacimiento=" + fechaNacimiento + ", altura=" + altura + '}';
    }
    
    
    
}
