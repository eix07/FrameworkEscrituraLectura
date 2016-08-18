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
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author Labing
 */
public class Lector {

    public static ArrayList<Object> lector(String descriptor, String ruta) throws FileNotFoundException, ClassNotFoundException, IOException, InstantiationException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
        BufferedReader lector = new BufferedReader(new FileReader(descriptor));
        BufferedReader lector2 = new BufferedReader(new FileReader(ruta));
        ArrayList<Object> list = new ArrayList<>();
        Class<?> cls = Class.forName(lector.readLine());
        
        // invoke is for ob
        String linea;
        String fin = "";
        String[] parameter= new String[3];
        String[] campos= new String[3];
        int[] tamanos = new int[3];
        int i=0;
        while ((linea = lector.readLine()) != null) {
            String[] arr = linea.split(" ");
            if (arr[0].equalsIgnoreCase("String")) {
                parameter[i]="java.lang.String";
            }else if(arr[0].equalsIgnoreCase("int")){
                 parameter[i]="java.lang.Integer";
            }
            
            campos[i]=arr[1];
            tamanos[i]=Integer.parseInt(arr[2]);
            i++;
        }
        
        lector.close();
        
        int j=0, pos=0;i=0;
        while ((linea=lector2.readLine())!=null) {
            
            Object ob = cls.newInstance();
            for (int tamano : tamanos) {
                j=(tamano-1)+i;
                String param= linea.substring(i, j);
                
               
                Method get = cls.getMethod("set"+capitalize(campos[pos]),Class.forName(parameter[pos]));
                if (parameter[pos].equalsIgnoreCase("java.lang.String")) {
                    get.invoke(ob, param);
                }else if(parameter[pos].equalsIgnoreCase("java.lang.Integer")){
                    get.invoke(ob, Integer.parseInt(param.split(" ")[0]));
                }
                
                i=j+1;
                pos++;
            }
            j=0;i=0;
            pos=0;
            list.add(ob);
            
        }
        
        lector2.close();
        return list;
    }

    private static String capitalize(final String line) {
        return Character.toUpperCase(line.charAt(0)) + line.substring(1);

    }
}