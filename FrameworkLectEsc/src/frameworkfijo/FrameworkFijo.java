/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frameworkfijo;

import java.io.IOException;

/**
 *
 * @author river
 */
public class FrameworkFijo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        
        //EscribirPart(String direccion de archivo)
        //.addSpace(String Añade una columna con una cantidad de caracteres fijos)
        //.addContentSpace(Posicion de la columna, contenido de la columna)
        //.writeSpaces(Escribe las partes fijas en el disco)
        
        EscribirPart pats=new EscribirPart("src/frameworkfijo/bla.txt");
        pats.addSpace("56");
        pats.addSpace("67");
        pats.addSpace("45");
        pats.addContentSpace("0", "LaConcha");
        pats.addContentSpace("1", "sdfsdfsd");
        pats.writeSpaces();
        
    }
    
}
