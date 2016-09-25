/**
 * 
 */
package co.edu.usa.adf.vaadin.model;


import FrameworkAnotaciones.FixedWidthField;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Danilo
 *
 */
public class ToDo implements Serializable
{
   private static final long serialVersionUID = 104209167841304193L;
   @FixedWidthField(width=3) private int id;
   @FixedWidthField(width=49) private  String message;
   @FixedWidthField(width=10)  private Date deadline;
   @FixedWidthField(width=1)  private int priority;
   @FixedWidthField(width=3)  private int progress;
   @FixedWidthField(width=5)  private boolean finished;
   @FixedWidthField(width=5) private boolean persisted;
   
   public ToDo()
   {
      persisted = false;
   }
   
   public ToDo( int id, String message, Date deadline, int priority )
   {
      super();
      this.id = id;
      this.message = message;
      this.deadline = deadline;
      this.priority = priority;
      this.persisted = true;
   }

   public String getMessage()
   {
      return message;
   }
   
   public void setMessage( String message )
   {
      this.message = message;
   }
   
   public Date getDeadline()
   {
      return deadline;
   }
   
   public void setDeadline( Date deadline )
   {
      this.deadline = deadline;
   }
   
   public int getPriority()
   {
      return priority;
   }
   
   public void setPriority( int priority )
   {
      this.priority = priority;
   }
   
   public int getProgress()
   {
      return progress;
   }
   
   public void setProgress( int progress )
   {
      this.progress = progress;
   }
   
   public boolean isFinished()
   {
      return finished;
   }
   
   public void setFinished( boolean finished )
   {
      this.finished = finished;
   }

   public int getId()
   {
      return id;
   }

   public void setId( int id )
   {
      this.id = id;
   }

   public boolean isPersisted()
   {
      return persisted;
   }

   public void setPersisted( boolean isPersisted )
   {
      this.persisted = isPersisted;
   }

    @Override
    public String toString() {
        return "ToDo{" + "id=" + id + ", message=" + message + ", deadline=" + deadline + ", priority=" + priority + ", progress=" + progress + ", finished=" + finished + ", persisted=" + persisted + '}';
    }
   
   //Se agrego este metodo TOsTRING Para imprimir los datos por consola
   
   
}
