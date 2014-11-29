/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Ejercicio1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joseangel
 */
public class captura extends Thread {
    
    public void run()
    {
        Thread h = Thread.currentThread();
        for(int i=1;i<50;i=i+2)
        {
            h.setName("main_"+i);
            System.out.println(h.getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(captura.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
