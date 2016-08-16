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
    public static void main(String[] args) throws IOException {
        
        
        //EscribirPart(String direccion de archivo)
        //.addSpace(String Añade una columna con una cantidad de caracteres fijos)
        //.addContentSpace(Posicion de la columna, contenido de la columna)
        //.writeSpaces(Escribe las partes fijas en el disco)
        
        Persona p=new Persona("Miguel","22","23423432");
        
        EscribirPart s=new EscribirPart(Persona.class, "src/frameworkfijo/bla.txt");
        
        try {
            s.writeSpaces(p);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(FrameworkFijo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(FrameworkFijo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(FrameworkFijo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(FrameworkFijo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(FrameworkFijo.class.getName()).log(Level.SEVERE, null, ex);
        }
 
        
    }
    
}
