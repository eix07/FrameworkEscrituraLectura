/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package frameworkfijo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.StringTokenizer;

/**
 *
 * @author Labing
 */
public class Escritor {
    
    public static void escribir(Object a, String rutaDescriptor) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
        BufferedReader lector= new BufferedReader(new FileReader(rutaDescriptor));
        String linea;
        Class<?> cls= Class.forName(lector.readLine());
        String rutaFinal="src/frameworkfijo/bestia.txt";
        FileWriter fw=new FileWriter(rutaFinal,true);
        BufferedWriter bw=new BufferedWriter(fw);
        
        
        String fin="";
        while ((linea=lector.readLine())!=null) {
            String con="";
            String[] parametrosParaLaClase= linea.split(" ");
            Method get= cls.getMethod("get"+capitalize(parametrosParaLaClase[1])); 
            con=  get.invoke(a).toString();
            int resta=(Integer.parseInt(parametrosParaLaClase[2]))-con.length();
            for (int i = 0; i < resta; i++) {
                con=con+" ";
            }
            
            fin=fin+con;
        }
        bw.write(fin+"\n");
        bw.close();
        
    }
    private static String capitalize(final String line) {
   return Character.toUpperCase(line.charAt(0)) + line.substring(1);
}
    
    
}
