/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrameworkAnotaciones;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 * @author Labing
 */
public class AnotationReader {

    private Field[] campos;
    private Annotation[] anotaciones;
    private Class cls;

    public AnotationReader(Class<?> clasesita) throws ClassNotFoundException {

        this.campos = clasesita.getDeclaredFields();
        this.anotaciones = clasesita.getAnnotations();
        FixedName name = (FixedName) anotaciones[0];
        cls = Class.forName(name.className());

    }

    public void EscribirConAnotaciones(Object obj) throws IOException, ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException {
        String rutaFinal = "src/frameworkAnotaciones/FrameworkAnotaciones.Tomate";
        System.out.println(anotaciones.length);
        FixedName name = (FixedName) anotaciones[0];
        Class cls = Class.forName(name.className());

        FileWriter fw = new FileWriter(rutaFinal, true);
        BufferedWriter bw = new BufferedWriter(fw);
        String valor = "";
        String valorEscribir = "";
        for (Field campo : campos) {

            System.out.println("campo " + campo.getName());
            anotaciones = campo.getAnnotations();

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
                    valorEscribir = valorEscribir + valor;
                }
            }
        }
        bw.write(valorEscribir + "\n");
        bw.close();

    }

    private static String capitalize(final String line) {
        return Character.toUpperCase(line.charAt(0)) + line.substring(1);
    }

    public LinkedList<Object> leerConAnotaciones(String ruta) throws FileNotFoundException, ClassNotFoundException, IOException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
        List<String> datos = leerArchivo(ruta);
        LinkedList<Object> retorna = new LinkedList<>();
        
        for (String dato : datos) {
            Object obj = cls.newInstance();
            int posicion = 0;
            for (Field campo : campos) {
                anotaciones = campo.getAnnotations();
                if (anotaciones[0] instanceof FixedWidthField) {
                    int width = (((FixedWidthField) anotaciones[0]).width()) - 1;
                    String data = dato.substring(posicion, posicion + width);
                    posicion = width + 1;
                    Method get = cls.getMethod("set" + capitalize(campo.getName()), campo.getType());
                    get.invoke(obj, casteoObjeto(campo.getType(), data));
                }
            }
            retorna.add(obj);         
        }
        return retorna;
    }

    private List<String> leerArchivo(String ruta) throws FileNotFoundException, IOException {

        BufferedReader bf = new BufferedReader(new FileReader(ruta));

        String linea = "";
        List<String> ls = new LinkedList<String>();

        while ((linea = bf.readLine()) != null) {
            ls.add(linea);
        }

        return ls;
    }

    private Object casteoObjeto(Class<?> type, String data) {
        Object temporal = null;
        ///System.out.println("data " + data);
        if (type.getCanonicalName().equalsIgnoreCase("int")) {
            temporal = Integer.parseInt(data.trim());
        } else if (type.getCanonicalName().equalsIgnoreCase("double")) {
            temporal = Double.parseDouble(data.trim());
        } else if (type.getCanonicalName().equalsIgnoreCase("boolean")) {
            temporal = Boolean.parseBoolean(data.trim());
        } else if (type.getCanonicalName().equalsIgnoreCase("java.lang.String")) {
            temporal = data;
        } else if (type.getCanonicalName().equalsIgnoreCase("java.util.Date")) {
            SimpleDateFormat fechaFormato = new SimpleDateFormat("yyyy/MM/dd");
            temporal = fechaFormato.format(data.trim());
        }
        return temporal;

    }

}
