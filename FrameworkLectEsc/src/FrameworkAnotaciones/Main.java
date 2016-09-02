/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrameworkAnotaciones;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Labing
 */
public class Main {

    public static void main(String[] args) {
        try {
            Tomate tomaco = new Tomate();
            tomaco.setColor("Verde");
            tomaco.setPeso(22);

            AnotationReader r = new AnotationReader(tomaco.getClass());
            //r.EscribirConAnotaciones(tomaco);
            LinkedList<Object> lista=  r.leerConAnotaciones("src/FrameworkAnotaciones/FrameworkAnotaciones.Tomate");
            for (Object lista1 : lista) {
                Tomate a= (Tomate) lista1;
                System.out.println(a.getColor()+" "+a.getPeso());
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }

}
