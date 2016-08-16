/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frameworkfijo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import jdk.nashorn.internal.objects.annotations.Constructor;

/**
 *
 * @author river
 */
public class EscribirPart extends FileWriter{
    
    //String 20, int 15 
    private Class<?>y;
    private ArrayList parts=new ArrayList<Space>();
    private BufferedWriter bw;
    
    public EscribirPart(Class<?> x, String fileName) throws IOException {
        super(fileName);
        this.y=x;
        bw=new BufferedWriter(this);
        this.addSpace();
    }
    
    public void addSpace(){
        Method[]metodos=y.getMethods();
        for (Method metodo : metodos) {
            String a;
            a=metodo.getReturnType()+"";
            if(a.contains("String")){
                Space s= new Space("22");
                parts.add(s);
            }else if(a.contains("int")){
                Space s=new Space("16");
                parts.add(s);
            }else if(a.contains("double")){
                Space s=new Space("32");
                parts.add(s);
            }else if(a.contains("Object")){
                Space s=new Space("43");
                parts.add(s);
            }
        }
    }
    
  
    public void writeSpaces(Object a) throws IOException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
        java.lang.reflect.Constructor<?>[]b=y.getDeclaredConstructors();
        Parameter[]temp = null;
        for (java.lang.reflect.Constructor<?> b1 : b) {
            temp=b1.getParameters();
        }
        for (Parameter temp1 : temp) {
            System.out.println(temp1.getName());
            System.out.println(temp1.getType());
        }
        y.getDeclaredConstructor(temp.getClass()).newInstance();
        y.cast(a);
    }

    public ArrayList getParts() {
        return parts;
    }
    
    
}
