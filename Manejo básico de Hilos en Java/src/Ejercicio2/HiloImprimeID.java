/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Ejercicio2;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joseangel
 */
public class HiloImprimeID implements Runnable{
    int id;
   // Thread t;
    public HiloImprimeID(int id)
    {
        this.id=id;
       // t=new Thread(this);
    }
    
    public void run()
    {        
        Random r=new Random();
        
        for(int i=0;i<5;i++)
        {
            System.out.println("ID HILO: " + id);
            
            try {
                Thread.sleep(r.nextInt(1000));
               
            } catch (InterruptedException ex) {
                Logger.getLogger(HiloImprimeID.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    

}
