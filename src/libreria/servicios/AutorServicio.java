/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.servicios;

import java.util.Scanner;
import libreria.Persistencia.AutorDAO;
import libreria.entidades.Autor;

/**
 *
 * @author Alejandro Birolo
 */
public class AutorServicio {
    
    private Scanner teclado;
    
    private final AutorDAO autorDao;

    public AutorServicio() {
        this.autorDao = new AutorDAO();
    }

    
    public Autor crearAutor() throws Exception{
        
        Autor autor= new Autor();
        
        try {
            
            
            teclado = new Scanner(System.in).useDelimiter("\n");
            String nombre;
            char bAlta;
            Boolean alta;
            
            System.out.print("Ingrese nombre del autor: ");
            nombre = teclado.next();
            
            do
            {
                System.out.print("Alta(Y/N): ");
                bAlta = teclado.next().toUpperCase().charAt(0);
            }while( bAlta != 'Y' && bAlta!='N');
            
            if (bAlta=='Y')
                alta=true;
            else
                alta=false;
            
            autor.setNombre(nombre);
            autor.setAlta(alta);
            
            
            autorDao.guardarAutor(autor);
            
            return autor;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
    
    public Autor buscarAutorPorCodigo(Integer id) throws Exception{
        
        Autor autor = new Autor();
        try {
            
            autor = autorDao.buscarAutorPorCodigo(id);
            
            return autor;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public Autor buscarAutorPorNombre(String nombre) throws Exception{
        
        Autor autor = new Autor();
        
        try {
            autor = autorDao.buscarAutorPorNombre(nombre);
            return autor;
        } catch (Exception e) {
            throw e;
        }
    }
}
