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
public class Lenguaje {
    
    @FixedWidthField(width=15) String nombre;
    @FixedWidthField(width=10) String paisDondeHablan;
    @FixedWidthField(width=15) int personasQueLoHablan;
    @FixedWidthField(width=5) boolean esto;

    public boolean getEsto() {
        return esto;
    }

    public void setEsto(boolean esto) {
        this.esto = esto;
    }
    
    public Lenguaje(){
    
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaisDondeHablan() {
        return paisDondeHablan;
    }

    public void setPaisDondeHablan(String paisDondeHablan) {
        this.paisDondeHablan = paisDondeHablan;
    }

    public int getPersonasQueLoHablan() {
        return personasQueLoHablan;
    }

    public void setPersonasQueLoHablan(int personasQueLoHablan) {
        this.personasQueLoHablan = personasQueLoHablan;
    }

    @Override
    public String toString() {
        return "Lenguaje{" + "nombre=" + nombre + ", paisDondeHablan=" + paisDondeHablan + ", personasQueLoHablan=" + personasQueLoHablan + ", esto=" + esto + '}';
    }

   
    
    
    
}
