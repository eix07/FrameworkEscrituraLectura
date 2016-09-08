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
    
    @FixedWidthField(position=1,width=15) String nombre;
    @FixedWidthField(position=2,width=10) String paisDondeHablan;
    @FixedWidthField(position=1,width=15) int personasQueLoHablan;
    
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
        return "Lenguaje{" + "nombre=" + nombre + ", paisDondeHablan=" + paisDondeHablan + ", personasQueLoHablan=" + personasQueLoHablan + '}';
    }
    
    
    
}
