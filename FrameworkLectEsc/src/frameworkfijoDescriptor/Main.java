/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frameworkfijoDescriptor;

/**
 *
 * @author santiago
 */ 
public class Main {
    
    public static void main(String[] args) {
        
        try {
             FrameworkFijo framework= new FrameworkFijo("src/frameworkfijoDescriptor/Descriptores/descriptorPersona.txt");
             framework.lectorArchivo();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
       
    }
    
}
