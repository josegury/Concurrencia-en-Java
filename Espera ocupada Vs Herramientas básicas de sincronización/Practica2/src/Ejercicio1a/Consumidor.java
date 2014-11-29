/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Ejercicio1a;

import Ejercicio1a.*;

/**
 *
 * @author joseangel
 */
public class Consumidor extends Persona implements Runnable{

    public Consumidor(Cola q) {
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
