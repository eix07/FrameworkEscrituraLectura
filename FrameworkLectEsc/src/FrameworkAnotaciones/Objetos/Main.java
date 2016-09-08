/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrameworkAnotaciones.Objetos;

import FrameworkAnotaciones.AnotationReader;
import FrameworkAnotaciones.Objetos.Persona;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Labing
 */
public class Main {

    public static AnotationReader personaReader;
    public static AnotationReader tomateReader;
    public static AnotationReader casaReader;
    public static AnotationReader animalReader;
    public static AnotationReader lenguajeReader;

    public static void main(String[] args) {
        try {
            personaReader = new AnotationReader("src/FrameworkAnotaciones/Descriptores/PersonaDescriptor.txt");
            tomateReader = new AnotationReader("src/FrameworkAnotaciones/Descriptores/TomateDescriptor.txt");
            casaReader = new AnotationReader("src/FrameworkAnotaciones/Descriptores/CasaDescriptor.txt");
            animalReader = new AnotationReader("src/FrameworkAnotaciones/Descriptores/AnimalDescriptor.txt");
            lenguajeReader = new AnotationReader("src/FrameworkAnotaciones/Descriptores/LenguajeDescriptor.txt");
            BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
            int opcion = 0;
            while (opcion < 3) {
                System.out.println("Digite la opcion que desea realizar\n1) Escribir Objeto\n2) Leer Objeto\n3)Salir");
                try {
                    opcion = Integer.parseInt(entrada.readLine());
                    int subOption = 0;
                    switch (opcion) {
                        case 1:
                            System.out.println("Digite la opcion del objeto que desea crear"
                                    + "\n1) Persona\n2) Tomate\n3) Animal\n4) Casa\n5) Lenguaje\n6) Salir menu Principal");
                            subOption = Integer.parseInt(entrada.readLine());
                            
                                switch (subOption) {
                                    case 1:
                                        crearPersona();
                                        break;
                                    case 2:
                                        crearTomate();
                                        break;
                                    case 3:
                                        crearAnimal();
                                        break;
                                    case 4:
                                        crearCasa();
                                        break;
                                    case 5:
                                        crearLenguaje();
                                        break;

                                }
                                
                            
                            continue;
                        case 2:
                            System.out.println("Digite la opcion del objeto que desea Leer"
                                    + "\n1) Persona\n2) Tomate\n3) Animal\n4) Casa\n5) Lenguaje");
                            subOption = Integer.parseInt(entrada.readLine());
                            switch (subOption) {
                                case 1:
                                    leerPersona();
                                    break;
                                case 2:
                                    leerTomate();
                                    break;
                                case 3:
                                    leerAnimal();
                                    break;
                                case 4:
                                    leerCasa();
                                    break;
                                case 5:
                                    leerLenguaje();
                                    break;
                            }
                            continue;
                    }
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void crearPersona() {

        try {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
            Persona p = new Persona();
            System.out.println("Digite el nombre de la persona");
            p.setNombre(entrada.readLine());
            System.out.println("Digite el apellido de la persona");
            p.setApellido(entrada.readLine());
            System.out.println("Digite la altura de la persona");
            p.setAltura(Double.parseDouble(entrada.readLine()));
            System.out.println("Ingrese la fecha de nacimiento ejemplo:1990/12/31");
            SimpleDateFormat s = new SimpleDateFormat("yyyy/MM/dd");
            Date fecha = s.parse(entrada.readLine());
            p.setFechaNacimiento(fecha);
            personaReader.EscribirConAnotaciones(p);
            
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private static void crearTomate() {
        try {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
            Tomate t = new Tomate();
            System.out.println("Digite el color del tomate");
            t.setColor(entrada.readLine());
            System.out.println("Digite el peso del tomate");
            t.setPeso(Double.parseDouble(entrada.readLine()));
            tomateReader.EscribirConAnotaciones(t);
           
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void crearAnimal() {
        try {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
            Animal a = new Animal();
            System.out.println("Digite el nombre del animal");
            a.setNombre(entrada.readLine());
            System.out.println("Digite el peso del Animal");
            a.setPeso(Double.parseDouble(entrada.readLine()));
            System.out.println("Digite la caracteristica del animal");
            a.setCaracteristica(entrada.readLine());
            animalReader.EscribirConAnotaciones(a);
            
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void crearCasa() {
        try {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
            Casa c = new Casa();
            System.out.println("Digite la direccion  de la casa");
            c.setDireccion(entrada.readLine());
            System.out.println("Digite la cantidad de piso en numero de la casa");
            c.setPisos(Integer.parseInt(entrada.readLine()));
            System.out.println("Digite el area de la casa");
            c.setArea(Double.parseDouble(entrada.readLine()));
            c.setFechaCreado(new Date());
            casaReader.EscribirConAnotaciones(c);
           
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void crearLenguaje() {
        try {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
            Lenguaje l = new Lenguaje();
            System.out.println("Digite el nombre del lenguaje");
            l.setNombre(entrada.readLine());
            System.out.println("Ingrese el pais donde hablan esta lengua");
            l.setPaisDondeHablan(entrada.readLine());
            System.out.println("Ingrese cantidad de personas que hablan este lenguaje");
            l.setPersonasQueLoHablan(Integer.parseInt(entrada.readLine()));
            lenguajeReader.EscribirConAnotaciones(l);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void leerPersona() {
        LinkedList<Object> lista = null;
        try {
            lista = personaReader.leerConAnotaciones();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Object lista1 : lista) {
            Persona a = (Persona) lista1;
            System.out.println(a.toString());
        }
    }

    private static void leerTomate() {
        LinkedList<Object> lista = null;
        try {
            lista = tomateReader.leerConAnotaciones();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Object lista1 : lista) {
            Tomate a = (Tomate) lista1;
            System.out.println(a.toString());
        }
    }

    private static void leerAnimal() {
        LinkedList<Object> lista = null;
        try {
            lista = animalReader.leerConAnotaciones();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Object lista1 : lista) {
            Animal a = (Animal) lista1;
            System.out.println(a.toString());
        }
    }

    private static void leerCasa() {
        LinkedList<Object> lista = null;
        try {
            lista = casaReader.leerConAnotaciones();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Object lista1 : lista) {
            Casa a = (Casa) lista1;
            System.out.println(a.toString());
        }
    }

    private static void leerLenguaje() {
        LinkedList<Object> lista = null;
        try {
            lista = lenguajeReader.leerConAnotaciones();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Object lista1 : lista) {
            Lenguaje a = (Lenguaje) lista1;
            System.out.println(a.toString());
        }
    }

}
