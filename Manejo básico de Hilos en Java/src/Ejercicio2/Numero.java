/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Ejercicio2;

/**
 *
 * @author joseangel
 */
public class Numero {
    public void main()
    {
        
        for(int i=1;i<=5;i++)
        {
            new Thread( new HiloImprimeID(i)).start();
        }
    }
    
    
    
}
