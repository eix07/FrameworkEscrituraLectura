package FrameworkAnotaciones;

/**
 *
 * @author Nosotros
 */
@FixedName(className="Tomate")
public class Tomate {
    
    @FixedWidthField(position=2,width=20) String color;
    @FixedWidthField(position=1,width=3) int  peso;
    
    public Tomate(String c,int p){
        this.color=c;
        this.peso=p;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
    
    
    
}