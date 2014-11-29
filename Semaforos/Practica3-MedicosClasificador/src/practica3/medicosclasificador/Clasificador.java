/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package practica3.medicosclasificador;

import java.util.concurrent.Semaphore;

/**
 *
 * @author joseangel
 */
public class Clasificador extends Thread{
     Semaphore boxes;
     Semaphore clasifica;
    
    public Clasificador(Semaphore boxes, Semaphore clasifica)
    {
        this.boxes = boxes;
        this.clasifica = clasifica;
    }
    
    public void run()
    {
        while(true){
            try {
                boxes.acquire();
                clasifica.release();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
    
}
