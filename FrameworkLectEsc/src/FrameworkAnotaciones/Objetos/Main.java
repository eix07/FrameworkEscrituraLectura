/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrameworkAnotaciones.Objetos;

import FrameworkAnotaciones.AnotationReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Labing
 */
public class Main {

    public static AnotationReader tomateReader;

    public static void main(String[] args) {
            
            tomateReader = new AnotationReader("src/FrameworkAnotaciones/Descriptores/TomateDescriptor.txt");
            tomateReader.leerConAnotaciones();
            tomateReader.leerTomate();
            tomateReader.EscribirAleatorio();
    }
}
