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
public class Productor extends Persona implements Runnable{
    
    public Productor(Cola q)
    {
        super(q);
    }
    
    public void run()
    {
        while(true)
        {
            q.put();
        }
    }
}
