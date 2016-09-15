/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frameworkfijoDescriptor;

import frameworkfijoDescriptor.Objetos.Persona;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.util.locale.StringTokenIterator;

/**
 *
 * @author river
 */
public class FrameworkFijo {

    private FileReader file;
    private Lector lectorArchivo;
    private List<Object> listaDatosDelArchivo = new LinkedList<>();
    private Class clase;
    private String rutaArchivoDatos;
    private ArrayList<Class> tipoDato = new ArrayList<>();
    private ArrayList<String> campos = new ArrayList<>();
    private ArrayList<Integer> tamanos = new ArrayList<Integer>();
    private List<String> datosArchivoDescriptor;

    public FrameworkFijo(String rutaArchivoDescriptor) throws FileNotFoundException, ClassNotFoundException {
        try {
            this.file = new FileReader(rutaArchivoDescriptor);
            this.lectorArchivo = new Lector(file);
            datosArchivoDescriptor = this.lectorArchivo.leerArchivo();

            this.clase = Class.forName(datosArchivoDescriptor.get(0));
            this.rutaArchivoDatos = datosArchivoDescriptor.get(1);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void lectorArchivo() {
        try {

            llenarArreglos();
            this.lectorArchivo.setRuta(rutaArchivoDatos);
            List<String> lineasArchivoTomate = this.lectorArchivo.leerArchivo();
            int inicioVentana = 0, finVentana = 0, posicionActual = 0;
            for (String lineaArchivo : lineasArchivoTomate) {
                Object objeto = clase.newInstance();
                for (Integer sizeCampo : tamanos) {
                    finVentana = (sizeCampo - 1) + inicioVentana;
                    String valor = lineaArchivo.substring(inicioVentana, finVentana);

                    Method metodoClase = clase.getDeclaredMethod("set" + capitalize(campos.get(posicionActual)), tipoDato.get(posicionActual));
                    Object valorCambiado = setValor(valor, posicionActual);
                    metodoClase.invoke(objeto, valorCambiado);

                    inicioVentana = finVentana + 1;
                    posicionActual++;
                }
                finVentana = 0;
                inicioVentana = 0;
                posicionActual = 0;
                listaDatosDelArchivo.add(objeto);
            }
            escribirDatosEnArchivo();
            mostrarListaDatos();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    private void llenarArreglos() {

        try {
            for (int i = 2; i < datosArchivoDescriptor.size(); i++) {

                String[] lineaDelDescriptor = datosArchivoDescriptor.get(i).split(" ");
                if (lineaDelDescriptor[0].equalsIgnoreCase("String")) {
                    tipoDato.add(String.class);
                } else if (lineaDelDescriptor[0].equalsIgnoreCase("int")) {
                    tipoDato.add(Integer.class);
                } else if (lineaDelDescriptor[0].equalsIgnoreCase("double")) {
                    tipoDato.add(Double.class);
                } else if (lineaDelDescriptor[0].equalsIgnoreCase("Date")) {
                    tipoDato.add(java.util.Date.class);
                } else if (lineaDelDescriptor[0].equalsIgnoreCase("boolean")) {
                    tipoDato.add(boolean.class);
                }

                campos.add(lineaDelDescriptor[1]);
                tamanos.add(Integer.parseInt(lineaDelDescriptor[2]));

            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    private void escribirDatosEnArchivo() {
        try {
            Collections.shuffle(listaDatosDelArchivo);
            for (Object objeto : listaDatosDelArchivo) {
                escribirObjeto(objeto);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    private void escribirObjeto(Object objeto) {
        try {
            FileWriter file = new FileWriter(rutaArchivoDatos.replaceAll(".txt", "copia.txt"),true);
            BufferedWriter buffer = new BufferedWriter(file);

            String lineaToWrite = "";
            int posicionActual = 0;
            int inicioVentana = 0;
            int restante = 0;
            for (String campo : campos) {
                
                String dato = invocacionMetodo(objeto, campo, tipoDato.get(posicionActual));
                restante = tamanos.get(posicionActual) - dato.length();
                for (int i = 0; i < restante; i++) {
                    dato = dato + " ";
                }
                lineaToWrite = lineaToWrite + dato;
                posicionActual++;
            }
            buffer.write(lineaToWrite + "\n");
            buffer.close();

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    private void mostrarListaDatos() {
        try {
            List<String> lineasToShow = recorrerListaDatosDelArchivo();
            Collections.shuffle(lineasToShow);
            for (String linea : lineasToShow) {
                System.out.println(linea);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    private static String capitalize(final String line) {
        return Character.toUpperCase(line.charAt(0)) + line.substring(1);
    }

    private Object setValor(String valor, int posicionActual) {
        Object retorno = null;
        try {

            if (tipoDato.get(posicionActual).equals(String.class)) {
                retorno = valor;
            } else if (tipoDato.get(posicionActual).equals(Integer.class)) {
                retorno = Integer.parseInt(valor.trim());
            } else if (tipoDato.get(posicionActual).equals(Double.class)) {
                retorno = Double.parseDouble(valor.trim());
            } else if (tipoDato.get(posicionActual).equals(java.util.Date.class)) {
                SimpleDateFormat dt1 = new SimpleDateFormat("yyyy/MM/dd");
                retorno = dt1.parse(valor.trim());
            } else if (tipoDato.get(posicionActual).equals(boolean.class)) {
                retorno = Boolean.parseBoolean(valor.trim());
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return retorno;
    }

    private String invocacionMetodo(Object valorInvoke, String campo, Class tipoDato) {
        String retorno = "";
        try {
            
            if (tipoDato.equals(boolean.class)) {
                Method method = clase.getMethod("is" + capitalize(campo));
                String m = method.invoke(valorInvoke).toString();
                boolean t = Boolean.valueOf(m);
                retorno = String.valueOf(t);
            } else if (tipoDato.equals(java.util.Date.class)) {
                SimpleDateFormat dt1 = new SimpleDateFormat("yyyy/MM/dd");
                Method method = clase.getMethod("get" + capitalize(campo));
                Date fecha = (Date) method.invoke(valorInvoke);
                retorno = dt1.format(fecha);
            } else {
                Method method = clase.getMethod("get" + capitalize(campo));
                retorno = String.valueOf(method.invoke(valorInvoke));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return retorno;
    }

    private List<String> recorrerListaDatosDelArchivo() {
        List<String> listaRetorno = new LinkedList<>();
        try {
            for (Object objetoDeLaLista : listaDatosDelArchivo) {
                String linea = "";

                for (int i = 0; i < campos.size(); i++) {

                    linea = linea + invocacionMetodo(objetoDeLaLista, campos.get(i), tipoDato.get(i)) + " ";

                }
                listaRetorno.add(linea);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return listaRetorno;
    }

}
