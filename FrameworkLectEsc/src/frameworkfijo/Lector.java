/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package frameworkfijo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Labing
 */
public class Lector {
    
    public static void lector(String descriptor, String ruta) throws FileNotFoundException, ClassNotFoundException, IOException, InstantiationException, IllegalAccessException{
        BufferedReader lector= new BufferedReader(new FileReader(descriptor));
        BufferedReader lector2= new BufferedReader(new FileReader(ruta));
        Class<?> cls= Class.forName(lector.readLine());
        Object ob= cls.newInstance();
        // invoke is for ob
        
        
    
    
    }
        
        
        
        
    
    
}
