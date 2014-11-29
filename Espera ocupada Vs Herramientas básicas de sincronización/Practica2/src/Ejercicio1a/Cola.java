/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Ejercicio1a;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joseangel
 */
public class Cola {
    
    private int n=0;
    volatile boolean consume=false;
    public int get()
    {
        while(!consume)
        {
            try {
                Thread.sleep((long)(Math.random()*500));
            } catch (InterruptedException ex) {
                Logger.getLogger(Cola.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Obtengo: " + n);
            consume=false;
        }
        return n;
    }
    public void  put()
    {
        if(!consume){
        System.out.print("Generando...");
        try {
            Thread.sleep((long)(Math.random()*500));
        } catch (InterruptedException ex) {
            Logger.getLogger(Cola.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Pongo: " + ++n);
        consume=true;
        }
    }
}
