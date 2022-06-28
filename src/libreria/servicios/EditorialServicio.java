/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.servicios;

import java.util.Scanner;
import libreria.Persistencia.EditorialDAO;
import libreria.entidades.Editorial;

/**
 *
 * @author Alejandro Birolo
 */
public class EditorialServicio {
    
    private Scanner teclado;
    private final EditorialDAO editorialDAO;

    public EditorialServicio( ) {
        this.editorialDAO = new EditorialDAO();
    }
    
    public Editorial crearEditorial()throws Exception{
        
        try {
            
            teclado = new Scanner(System.in).useDelimiter("\n");
            String nombre;
            char bAlta;
            Boolean alta;
            
            System.out.print("Ingrese nombre de la editorial: ");
            nombre = teclado.next();
            
            do
            {
                System.out.print("Alta(Y/N): ");
                bAlta = teclado.next().toUpperCase().charAt(0);
            }while( bAlta != 'Y' || bAlta!='N');
            
            if (bAlta=='Y')
                alta=true;
            else
                alta=false;
            
            return new Editorial(nombre, alta);
            
        } catch (Exception e) {
            throw e;
        }
    }
    
    public Editorial buscarEditorialPorCodigo(Integer id) throws Exception{
        try {
            return null;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public Editorial buscarEditorialPorNombre(String nombre)throws Exception{
        try {
            return null;
        } catch (Exception e) {
            throw e;
        }
    }
    
    
}
