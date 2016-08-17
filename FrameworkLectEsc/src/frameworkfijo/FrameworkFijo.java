/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frameworkfijo;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author river
 */
public class FrameworkFijo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        
        
        //EscribirPart(String direccion de archivo)
        //.addSpace(String Añade una columna con una cantidad de caracteres fijos)
        //.addContentSpace(Posicion de la columna, contenido de la columna)
        //.writeSpaces(Escribe las partes fijas en el disco)
        
        Persona miguel= new Persona();
        miguel.setNombre("Miguel Rivera");
        miguel.setID("1");
        miguel.setEdad(22);
        
        Persona santiago=new Persona();
        santiago.setNombre("Santiago Sanchez");
        santiago.setEdad(21);
        santiago.setID("10323232");
        
        Escritor.escribir(miguel, "src/frameworkfijo/descriptorPersona.txt");
      Escritor.escribir(santiago, "src/frameworkfijo/descriptorPersona.txt");
        
    }
    
}
