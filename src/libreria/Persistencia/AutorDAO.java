/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.Persistencia;

import java.util.Collection;
import libreria.entidades.Autor;

/**
 *
 * @author Alejandro Birolo
 */
public final class AutorDAO extends DAO {
    
    public void guardarAutor(Autor autor) throws Exception{
        
        try {
            
            if(autor == null)
                throw new Exception("Debe indicar un autor");
            
            if ( autor.getId()!=null && em.find(Autor.class, autor.getId()) != null )
                throw new Exception("El autor ya existe");
            
            super.guardar(autor);
            
        } catch (Exception e) {
            throw e;
        }
        
    }
    
    public void modificarAutor(Autor autor) throws Exception{
        
        try {
            
            if(autor == null)
                throw new Exception("Debe indicar un autor");
            
            super.editar(autor);
            
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void eliminarAutor(Autor autor) throws Exception{
        try {
            
            if(autor == null)
                throw new Exception("Debe indicar un autor");
            
            super.eliminar(autor);
            
        } catch (Exception e) {
            throw e;
        }
    }
    
    public Autor buscarAutorPorCodigo(Integer id) throws Exception{
        
        try {
            super.conectar();
            //Autor autor = (Autor) em.createQuery("SELECT a FROM Autor a WHERE ID = :ID").setParameter("ID", id).getSingleResult();
            Autor autor =  em.find(Autor.class, id);
             
            if(autor == null)
                throw new Exception("No se encontro el autor");
            
            super.desconectar();
            return autor;
            
        } catch (Exception e) {
            throw e;
        }finally{
            super.desconectar();
        }
        
    }
    
    public Autor buscarAutorPorNombre(String nombre)throws Exception{
        
        try {
            super.conectar();
            //Autor autor = (Autor) em.createQuery("SELECT a FROM Autor a where nombre like :nombre").setParameter("nombre", nombre).getSingleResult();
            Autor autor =  em.find(Autor.class, nombre);
            
            if(autor == null)
                throw new Exception("No se encontro el autor");
            
            super.desconectar();
            return autor;
            
        } catch (Exception e) {
            throw e;
        }finally{
            super.desconectar();
        }
    }
    
    public Collection<Autor> listarAutores() throws Exception{
         
        try {
            
            super.conectar();
            Collection<Autor> autores = em.createQuery("SELECT a FROM Autor a ").getResultList();
            
            if(autores.isEmpty())
                throw new Exception("No se encontraron autores");
            
            super.desconectar();
            return autores;
            
        } catch (Exception e) {
            throw e;
        }finally{
            super.desconectar();
        }
        
    }
    
}
