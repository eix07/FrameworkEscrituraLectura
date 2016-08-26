/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frameworkfijoDescriptor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


/**
 *
 * @author Labing
 */
public class Lector2 {
    
    public static ArrayList<String> lector(String ruta) throws FileNotFoundException, IOException{
        ArrayList<String> lista= new ArrayList<>();
        BufferedReader buffer= new BufferedReader(new FileReader(ruta));
        String linea;
        while ((linea=buffer.readLine())!=null) {
            lista.add(linea);
        }
    
        return lista;
    }
    
    //@Retention(RUNTIME)
    //Target(TYPE)
    
}
