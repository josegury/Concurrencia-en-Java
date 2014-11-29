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
public class Medico extends Thread{
    
    private int ID;
    private Semaphore medico;
    private Semaphore enfermo;
    private Semaphore pantalla;
    
    public Medico(int ID, Semaphore medico, Semaphore enfermo, Semaphore pantalla){
        this.ID = ID; 
        this.medico = medico;
        this.enfermo = enfermo;
        this.pantalla = pantalla;
    }
    
    public void run()
    {
        while (true)
        {
            escribe("[Medico " + ID +" ]: Esperando un paciente...");
            medico.release();            
            try 
            {
                enfermo.acquire();
                Thread.sleep((long)Math.random());
            } catch (InterruptedException ex) 
            {
                ex.printStackTrace();
            }
        }
    }
    
    protected void escribe(String mensaje){
        try 
        {
            pantalla.acquire();
        } catch (InterruptedException ex) {
           ex.printStackTrace();
        }
        System.out.println(mensaje);
        pantalla.release();
    }
    
}
