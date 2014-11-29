/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package practica3.medicos;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joseangel
 */
public class Paciente extends Thread{
    
      int ID;
     Semaphore sillas;
     Semaphore boxes;
     Semaphore medico; 
     Semaphore enfermo;
     Semaphore pantalla;
     Semaphore mutex = new Semaphore(1, true);
  
    
    public Paciente(int ID,  Semaphore sillas, Semaphore boxes, Semaphore medico, Semaphore enfermo, Semaphore pantalla)
    {
        this. ID = ID;
        this.sillas = sillas;
        this.boxes = boxes;
        this.medico = medico;
        this.enfermo = enfermo;
        this.pantalla = pantalla; 
        
    }
    
     public void run()
     {
         try {
             mutex.acquire();
         } catch (InterruptedException ex) {
             Logger.getLogger(Paciente.class.getName()).log(Level.SEVERE, null, ex);
         }
        
       if(sillas.tryAcquire())
       {
            try {
                escribe("["+ID+ "]: Me siento y quedan "+ sillas.availablePermits() + " sillas libres." );
                mutex.release();
                boxes.acquire();//entra al box
                
                //protejo que se levante de la silla
                mutex.acquire();
                sillas.release();
                escribe("["+ID+"] Entro en box y dejo "+sillas.availablePermits()+" sillas libres.");
                mutex.release();
                
                enfermo.release();//libero el enforma para que lo pueda cojer el medico
                medico.acquire();//adquiere un medico
                boxes.release();//libero el box, xk el paciente pasa al medico
                escribe("["+ID+"] El médico me ha curado. Me voy!");
               
            } catch (InterruptedException ex) {
               ex.printStackTrace();
            }
           
           
       }
       else
       {
           escribe("Soy ["+ID+"]: Me voy porque no quedan sillas libres." );
           mutex.release();
       }
       
    }
    
      protected void escribe(String mensaje){
        try {
            pantalla.acquire();
        } catch (InterruptedException ex) {
           ex.printStackTrace();
        }
        System.out.println(mensaje);
        pantalla.release();
    }
}
