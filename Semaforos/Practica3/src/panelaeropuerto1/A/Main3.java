package panelaeropuerto1.A;

/* sin exclusión mútua */

import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import panelaeropuerto.IPanel2;
import panelaeropuerto.PanelNivel2;

public class Main3 {

   static Semaphore semaforo= new Semaphore(1);
   private static void nap(int millisecs) {
        try {
            Thread.sleep(millisecs);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void operador1(PanelNivel2 d) throws InterruptedException {

    // Añade una secuencia de filas con ponLinea con pequeños naps aleatorios
        
       String[] vuelos= {"IB3451MADRID     17:30GATE-C56",
                         "IB3304LONDRES-HR 17:40GATE-A6",
                         "JAF756BRUSELAS   18:00GATE-A12",
                         "AEA101PARIS      17:40GATE-B1",
                         "SNB726GOTEBORG   17:45GATE C11",
                         "RAM026CASABLANCA 18:10GATE-A11",
                         "IB5423NEW YORK   18:15GATE-B7"};
        for (int i=0;i<20;i++)  
        {
           semaforo.acquire();
           d.ponLinea(vuelos[i]);
           semaforo.release();
           nap((int) (Math.random() * 4000) + 2000);// nap entre 2 y 4 seg.
        }
           
         
            

   }

    private static void operador2(PanelNivel2 d) throws InterruptedException {

    // Añade una secuencia de filas con ponLinea con pequeños naps aleatorios
        String[] vuelos={"IB2244LA HABANA 17:30 GATE-C12",
                         "EZY304NEWCASTLE 17:40 GATE-A2",
                         "IB7568PARIS-CDG 18:00 GATE-A34",
                         "IBE101AMSTERDAM 17:40 GATE-B12",
                         "KLM726LANZAROTE 17:45 GATE C05",
                         "JKK326MUNICH    18:30 GATE-A22",
                         "IB5421SEVILLA   18:15 GATE-D1"};
        for (int i=0;i<20;i++)
        {
            semaforo.acquire();
            d.ponLinea(vuelos[i]);
            semaforo.release();
            nap((int) (Math.random() * 4000) + 2000);// nap entre 2 y 4 seg.
        }
                
   }

    private static void quitaVuelos(PanelNivel2 d) throws InterruptedException {

	// Añade una secuencia de borrar la fila 0   naps aleatorios según enunciado
        
        for(int i = 0; i < 40; i++)
        {
            semaforo.acquire();
            d.borraLinea(0);
            semaforo.release();
            nap(4000);
        }
	
            
             
        }int i = 0;
    

    public static void main(String [] args) {
	final PanelNivel2 p = new IPanel2();

        new Thread () {
	    public void run() {
                try {
                    quitaVuelos(p);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Main3.class.getName()).log(Level.SEVERE, null, ex);
                }
	    }
	}.start();

	new Thread () {
	    public void run() {
                try {
                    operador1(p);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Main3.class.getName()).log(Level.SEVERE, null, ex);
                }
	    }
	}.start();

        new Thread () {
	    public void run() {
                try {
                    operador2(p);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Main3.class.getName()).log(Level.SEVERE, null, ex);
                }
	    }
	}.start();


	

    }
}