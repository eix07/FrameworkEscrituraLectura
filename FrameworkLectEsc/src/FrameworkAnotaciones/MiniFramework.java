/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniframework;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author Santiago
 */
public class MiniFramework {

    private int[] limites;
    private Field campos[];
    private Class name;

    MiniFramework(int[] limites, Class name) {
        this.limites = limites;
        this.campos = name.getFields();
        this.name = name;
    }

    private int getLimite(int i) {
        return limites[i];
    }

    /*private Class getA() {
        return name;
    }*/
    public void escribir(Object ob, String ruta) throws IOException {

        PrintWriter pr = null;
        try {
            pr = new PrintWriter(new FileWriter(ruta, true));

            StringTokenizer tokens = new StringTokenizer(ob.toString());

            int restante = 0;
            int i = 0;
            String result = "";
            while (tokens.hasMoreTokens()) {
                String token = tokens.nextToken();
                restante = (this.limites[i]) - (token.length());
                for (int j = 0; j < restante; j++) {
                    token = token + " ";
                }
                i++;
                result = result + token;
            }
            pr.println(result);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if (pr != null) {
                pr.close();
            }

        }

    }

    public ArrayList<Object> leer(String ruta) {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        ArrayList<Object> list = new ArrayList<>();
        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File(ruta);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            Object obj;
            Class _class;
            // Lectura del fichero
            String linea;
            Field field;
            int i = 0;
            while ((linea = br.readLine()) != null) {

                _class = Class.forName(this.name.getName());
                obj = _class.newInstance();
                StringTokenizer tokens = new StringTokenizer(linea);
                while (tokens.hasMoreTokens()) {
                    String valor = tokens.nextToken();
                    field = this.campos[i];
                    String nameType = field.getType().getName();
                    if (nameType.equals("int")) {

                        field.set(obj, Integer.parseInt(valor));

                    } else if (nameType.equals("java.lang.String")) {
                        field.set(obj, valor);
                    } else if (nameType.equals("float")) {
                        field.set(obj, Float.parseFloat(valor));
                    } else if (nameType.equals("double")) {
                        field.set(obj, Double.parseDouble(valor));
                    } else if (nameType.equals("boolean")) {
                        field.set(obj, valor);
                    } else if (nameType.equals("char")) {
                        field.set(obj, valor.charAt(0));
                    } else {
                        System.out.println("Este programa no soporta la asignacion de " + nameType);
                    }
                    i++;
                }
                i=0;
                list.add(obj);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }br.close();
            } catch (Exception e2) {    
                e2.printStackTrace();
            }
        }
        return list;
    }

}
