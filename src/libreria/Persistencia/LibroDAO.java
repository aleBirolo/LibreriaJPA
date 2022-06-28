/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.Persistencia;

import java.util.Collection;
import libreria.entidades.Libro;

/**
 *
 * @author Alejandro Birolo
 */
public final class LibroDAO extends DAO{
    
    public void guardarLibro(Libro libro) throws Exception{
        
        try {
            
            if(libro == null)
                throw new Exception("Debe indicar un libro");
            
            if ( libro.getIsbn() != 0 && em.find(Libro.class, libro.getIsbn()) != null )
                throw new Exception("El libro ya existe");
            
            super.guardar(libro);
            
        } catch (Exception e) {
            throw e;
        }
        
    }
    
    public void modificarLibro(Libro libro) throws Exception{
        
        try {
            
            if(libro == null)
                throw new Exception("Debe indicar un libro");
            
            super.editar(libro);
            
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void eliminarLibro(Libro libro) throws Exception{
        try {
            
            if(libro == null)
                throw new Exception("Debe indicar un libro");
            
            super.eliminar(libro);
            
        } catch (Exception e) {
            throw e;
        }
    }
    
    public Libro buscarLibroPorCodigo(Long isbn) throws Exception{
        
        try {
            super.conectar();
            Libro libro = (Libro) em.createQuery("SELECT l FROM Libro l where isbn = :isbn").setParameter("isbn", isbn).getSingleResult();
            
            if(libro == null)
                throw new Exception("No se encontro el libro");
            
            super.desconectar();
            return libro;
            
        } catch (Exception e) {
            throw e;
        }finally{
            super.desconectar();
        }
        
    }
    
    public Libro buscarLibroPorTitulo(String titulo)throws Exception{
        
        try {
            super.conectar();
            Libro libro = (Libro) em.createQuery("SELECT l FROM Libro l where titulo like :titulo").setParameter("titulo", titulo).getSingleResult();
            
            if(libro == null)
                throw new Exception("No se encontro el libro");
            
            super.desconectar();
            return libro;
            
        } catch (Exception e) {
            throw e;
        }finally{
            super.desconectar();
        }
    }
    
    public Collection<Libro> listarLibros() throws Exception{
         
        try {
            
            super.conectar();
            Collection<Libro> libros = em.createQuery("SELECT l FROM Libro l").getResultList();
            
            if(libros.isEmpty())
                throw new Exception("No se encontraron libros");
            
            super.desconectar();
            return libros;
            
        } catch (Exception e) {
            throw e;
        }finally{
            super.desconectar();
        }
        
    }
    
}
