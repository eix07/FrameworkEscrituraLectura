/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrameworkAnotaciones;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 *
 * @author Labing
 */
public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException {
        Tomate tomaco = new Tomate("ROJO", 4);

        AnotationReader r = new AnotationReader(tomaco.getClass());
        r.EscribirConAnotaciones(tomaco);
    }

}
