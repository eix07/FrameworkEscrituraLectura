/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frameworkfijo;

/**
 *
 * @author river
 */
public class Space {
    
    String fixedSpace;
    String content;

    public Space(String fixedSpace) {
        this.fixedSpace = fixedSpace;
        this.content="";
    }

    public String getFixedSpace() {
        return fixedSpace;
    }

    public void setFixedSpace(String fixedSpace) {
        this.fixedSpace = fixedSpace;
    }
    
    public void addContent(String contn){
        this.content=this.content+contn;
        String blank=" ";
        if(this.content.length()<=(Integer.parseInt(this.fixedSpace))){
            for (int i = 0; i < (Integer.parseInt(this.fixedSpace)-this.content.length()); i++) {
                this.content=this.content+blank;
            }
        }else{
            this.content=this.content.substring(0,(this.content.length()-Integer.parseInt(this.fixedSpace)));
        }
    }
    public String getContent() {
        return content;
    }

}
