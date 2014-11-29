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
public class Consumidor extends Persona implements Runnable{

    int id;
    
    Consumidor(Cola q) {
        super(q);
    }    
    
    public Consumidor (Cola q, int id)
    {
        super(q);
        this.id=id;
    } 
    
    public void run()
    {
        while(true)
        {
            q.get(this.id);     
        }
    }
}
