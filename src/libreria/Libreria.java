/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria;

import libreria.servicios.LibreriaServicio;

/**
 *
 * @author Alejandro Birolo
 */
public class Libreria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            LibreriaServicio ls = new LibreriaServicio();
            ls.iniciar();
        } catch (Exception e) {
             e.printStackTrace();
             e.getMessage();
        }
        
        
        
        
    }
    
}
