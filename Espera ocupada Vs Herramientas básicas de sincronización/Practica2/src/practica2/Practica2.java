/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package practica2;
//paquetes ejerccio
import Ejercicio1c.*;

/**
 *
 * @author joseangel
 */
public class Practica2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Cola q = new Cola();
        boolean barrera=true;
        
       //Ejercicio 3:
        Thread hiloPro,hiloCons,hiloCons2;
        hiloPro = new Thread(new Productor(q));
        hiloCons = new Thread(new Consumidor(q,1));
        hiloCons2 = new Thread(new Consumidor(q,2));
        
        hiloPro.start();
        hiloCons.start();
        hiloCons2.start();;
        
        
        
    }
    /*
    synchronized. si varios hilos estan sincronizados, solo se puede estar ejecuntando un unico hio,
    sirve prara realizar una exclusion mutua en java
    */
}
