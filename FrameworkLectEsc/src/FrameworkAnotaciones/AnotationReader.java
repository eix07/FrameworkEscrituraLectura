/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrameworkAnotaciones;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 *
 * @author Labing
 */
public class AnotationReader {

    private Field[] campos;
    private Annotation[] anotaciones;
    private String clase;

    public AnotationReader(Class<?> clasesita) {

        this.campos = clasesita.getDeclaredFields();
        this.clase = clasesita.getCanonicalName();
        
        
    }

    public void EscribirConAnotaciones(Object obj) throws IOException, ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException {
        String rutaFinal = "src/frameworkAnotaciones/" + this.clase;
        Class cls = Class.forName(this.clase);

        FileWriter fw = new FileWriter(rutaFinal, true);
        BufferedWriter bw = new BufferedWriter(fw);
        String valor = "";
        String valorEscribir="";
        
        for (Field campo : campos) {
            System.out.println("campo " + campo.getName());
            anotaciones = campo.getAnnotations();
            Arrays.sort(anotaciones);
            System.out.println(anotaciones.toString());
            for (Annotation anotacion : anotaciones) {
                System.out.println(anotacion);
                if (anotacion instanceof FixedWidthField) {
                    int pos = (((FixedWidthField) anotacion).position());
                    int width = (((FixedWidthField) anotacion).width());
                    Method get = cls.getMethod("get" + capitalize(campo.getName()));
                    valor = get.invoke(obj) + "";
                    int resta = width - valor.length();
                    for (int i = 0; i < resta; i++) {
                        valor = valor + " ";
                    }
                    valorEscribir=valorEscribir+valor;
                }
            }
        }
        bw.write(valorEscribir+"\n");
        bw.close();
        /*
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
        bw.close();*/
    }

    private static String capitalize(final String line) {
        return Character.toUpperCase(line.charAt(0)) + line.substring(1);
    }

   

}
