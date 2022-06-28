/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.servicios;

import libreria.entidades.Autor;
import libreria.entidades.Editorial;
import libreria.entidades.Libro;

/**
 *
 * @author Alejandro Birolo
 */
public class LibreriaServicio {
    
    private final AutorServicio autorServ;
    private final EditorialServicio editorialServ;
    private final LibroServicio libroServ;

    public LibreriaServicio() {
        this.autorServ = new AutorServicio();
        this.editorialServ = new EditorialServicio();
        this.libroServ = new LibroServicio();
    }
    
    public void iniciar() throws Exception{
        
        try {
            /*
            System.out.println("\nAutor:");
            Autor autor = autorServ.crearAutor();
            System.out.println("Autor ingresado: " + autor);
            
            System.out.println("\nEditorial:");
            Editorial editorial = editorialServ.crearEditorial();
            System.out.println("Editorial ingresado: " + editorial);
            */
            System.out.println("\nLibro:");
            Libro libro = libroServ.crearLibro();
            System.out.println("Libro ingresado: " + libro);
            
            
        } catch (Exception e) {
            throw e;
        }
        
    }
    
    
}
