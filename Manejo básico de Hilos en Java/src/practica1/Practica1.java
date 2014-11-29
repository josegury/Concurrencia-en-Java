/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package practica1;

import Ejercicio1.*;
import Ejercicio2.*;
import Ejercicio3.Hilo2;

/**
 *
 * @author joseangel
 */
public class Practica1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException  {
        // TODO code application logic here
        

//Ejercicio 1:
      //   Thread ej1;
      //  ej1=new Thread(new captura());
      //  ej1.start();
        
//Ejercicio 2:
       // Numero ej2 =new Numero();
        //ej2.main();
        
//Ejercicio 3:
        Hilo2 h=new Hilo2();
        int con=0;
        System.out.println("Estas ya?"); 
        h.start();
        Thread.sleep(1000); 
        while(con!=5 && h.isAlive())
        {
            System.out.println("Te queda mucho? ");            
            Thread.sleep(1000);            
            con++;
        }
        if(con==5)
        {
            System.out.println("Yo me voy");
            h.interrupt();            
            h.join();            
        }
       else
       {
            System.out.println("Por fin!");
       }
       System.out.println("Venga vámonos");
    }
    
}
