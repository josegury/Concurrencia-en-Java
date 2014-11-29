/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Ejercicio1c;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joseangel
 */
public class Cola {
    
    private int n=0;
    volatile int turno=0;
   
    synchronized int get(int id)
    {        
             
       
        try {   
            while(turno!=id)
             {            
                wait();
             }         
            Thread.sleep((long) (Math.random()*500));
        } catch (InterruptedException ex) {
            Logger.getLogger(Cola.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("["+id+"] Obtengo: " + n + "para Consumidor " + Thread.currentThread().getName());
        
        turno--;
        notifyAll();
        return n;
    }
    synchronized void  put() 
    {       
        
        System.out.print("Generando...");        
        
        try {
            while(turno!=0)
            {
                wait(); 
            }
            Thread.sleep((long) (Math.random()*500));
        } catch (InterruptedException ex) {
            Logger.getLogger(Cola.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        System.out.println("Pongo: "+ ++n);
        turno+=2;   
        notifyAll();
    }
}
