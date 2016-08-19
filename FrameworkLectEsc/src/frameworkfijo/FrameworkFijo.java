/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frameworkfijo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
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
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, FileNotFoundException, InstantiationException {
        
        
        //EscribirPart(String direccion de archivo)
        //.addSpace(String Añade una columna con una cantidad de caracteres fijos)
        //.addContentSpace(Posicion de la columna, contenido de la columna)
        //.writeSpaces(Escribe las partes fijas en el disco)
        
       Persona profe= new Persona();
        profe.setNombre("Danilo");
        profe.setID("3");
        profe.setEdad(22);
        
       /*  Persona santiago=new Persona();
        santiago.setNombre("Santiago Sanchez");
        santiago.setEdad(21);
        santiago.setID("10323232");
        
        Escritor.escribir(miguel, "src/frameworkfijo/descriptorPersona.txt");
      Escritor.escribir(santiago, "src/frameworkfijo/descriptorPersona.txt");*/
      Escritor.escribir(profe, "src/frameworkfijo/descriptorPersona.txt");
        
       
        ArrayList<Object> lisOb= Lector.lector("src/frameworkfijo/descriptorPersona.txt", "src/frameworkfijo/bestia.txt");
        ArrayList<Persona> lisPe= new ArrayList<>();
        for (Object ob : lisOb) {
            lisPe.add((Persona)ob);
        }
        for (Persona persona : lisPe) {
            System.out.println("Nombre "+persona.getNombre()+"\n"+"ID "+persona.getID()+"\n"+"Edad "+persona.getEdad());
        }
        
    }
    
}
