/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Ejercicio1b;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joseangel
 */
public class Consumidor extends Persona implements Runnable{

    Consumidor(Cola q) {
        super(q);
    }
    
    
    public void run()
    {
        while(true)
        {
            q.get();
        }
    }
}
