/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrameworkAnotaciones;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Labing
 */
public class Main {

    public static void main(String[] args) {
        try {
            /*Tomate tomaco = new Tomate();
            tomaco.setColor("Verde");
            tomaco.setPeso(22);*/
            
            Persona persona= new Persona();
            persona.setAltura(1.78);
            persona.setApellido("Sanchez");
            persona.setNombre("Santiago");
            persona.setFechaNacimiento(new Date());
            

            AnotationReader r = new AnotationReader(persona.getClass());
            r.EscribirConAnotaciones(persona);
            LinkedList<Object> lista=  r.leerConAnotaciones("src/FrameworkAnotaciones/FrameworkAnotacionesPersona.txt");
            for (Object lista1 : lista) {
                Persona a= (Persona) lista1;
                System.out.println(a.toString());
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }

}
