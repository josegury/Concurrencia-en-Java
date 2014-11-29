/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Ejercicio3;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joseangel
 */
public class Hilo2 extends Thread{
    String [] mensa=new  String [ 3 ];
    
    public Hilo2()
    {
        mensa[0]="Me estoy vistiendo..";
        mensa[1]="Me queda un segundo...";
        mensa[2]="Esto no me queda bien...";
        
    }
    
    public void run()
    {
        Random r = new Random();
        int fin, con=0;
        boolean interrumpido=false;
        fin=r.nextInt(6)+2;
        System.out.println(fin);
        try 
        {
            while(con!=fin && !interrumpido)
            {
                System.out.println(mensa[r.nextInt(3)]);
                    Thread.sleep(1000);
                con++;
            }  
         } 
        catch (InterruptedException ex) 
        {
                interrumpido=true;                
        }
        if(!interrumpido)
        {         
            System.out.println("ya estoy...");
        }
        else
        {
            System.out.println("Que cabrón/a!!!");
        }
    }
    
    
}
