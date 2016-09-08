package FrameworkAnotaciones.Objetos;

import FrameworkAnotaciones.FixedWidthField;

/**
 *
 * @author Nosotros
 */

public class Tomate {
    
    @FixedWidthField(position=1,width=20) String color;
    @FixedWidthField(position=2,width=3) double  peso;
    
    public Tomate(){
        
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Tomate{" + "color=" + color + ", peso=" + peso + '}';
    }
    
    
    
}
