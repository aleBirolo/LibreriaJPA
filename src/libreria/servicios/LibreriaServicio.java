/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.servicios;

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
    
    
    
    
}
