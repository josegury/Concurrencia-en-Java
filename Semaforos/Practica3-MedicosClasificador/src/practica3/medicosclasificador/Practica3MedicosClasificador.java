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
public class Practica3MedicosClasificador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Semaphore sillas  = new Semaphore(5, true);
        Semaphore boxes = new Semaphore(3, true);
        Semaphore medico = new Semaphore(0, true);
        Semaphore enfermo = new Semaphore(0, true);
        Semaphore pantalla = new Semaphore(1, true);
        Semaphore clasificador=new Semaphore(0,true);
        
        for(int i=0; i<20; i++)
        {
            (new Paciente(i, sillas, boxes, medico, enfermo, pantalla,clasificador)).start();
        }
        
        for (int j=0; j<2; j++){
            (new Medico(j, medico, enfermo, pantalla)).start();
        }
        
        (new Clasificador(boxes, clasificador)).start();
    }
    
}
