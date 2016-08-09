/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frameworkfijo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author river
 */
public class EscribirPart extends FileWriter{
    
    private ArrayList parts=new ArrayList<Space>();
    private BufferedWriter bw;
    
    public EscribirPart(String fileName) throws IOException {
        super(fileName);
        bw=new BufferedWriter(this);
    }
    
    public void addSpace(String fixedSpace){
        Space space=new Space(fixedSpace);
        parts.add(space);
    }
    
    public void addContentSpace(String position,String content) throws IOException{
        int a=Integer.parseInt(position);
        if(a<=parts.size()&&a>=0){
            Space s=(Space)parts.get(a);
            s.addContent(content);
        }else{
            throw new IOException("Posicion invalida");
        }
    }
    
    public void writeSpaces() throws IOException{
        String concats="";
        for (Object part : parts) {
            Space s=(Space)part;
            concats=concats+s.getContent();
        }
        bw.flush();
        bw.write(concats);
        bw.close();
    }
}
