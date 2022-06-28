/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.Persistencia;

import java.util.Collection;
import libreria.entidades.Editorial;

/**
 *
 * @author Alejandro Birolo
 */
public final class EditorialDAO extends DAO{
    
    public void guardarEditorial(Editorial editorial) throws Exception{
        
        try {
            
            if(editorial == null)
                throw new Exception("Debe indicar la editorial");
            
            if (em.find(Editorial.class, editorial.getId()) != null )
                throw new Exception("La editorial ya existe");
            
            super.guardar(editorial);
            
        } catch (Exception e) {
            throw e;
        }
        
    }
    
    public void modificarEditorial(Editorial editorial) throws Exception{
        
        try {
            
            if(editorial == null)
                throw new Exception("Debe indicar la editorial");
            
            super.editar(editorial);
            
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void eliminarEditorial(Editorial editorial) throws Exception{
        try {
            
            if(editorial == null)
                throw new Exception("Debe indicar la editorial");
            
            super.eliminar(editorial);
            
        } catch (Exception e) {
            throw e;
        }
    }
    
    public Editorial buscarEditorialPorCodigo(Integer id) throws Exception{
        
        try {
            super.conectar();
            Editorial editorial = (Editorial) em.createQuery("SELECT e FROM Editorial e where id = :id").setParameter("id", id).getSingleResult();
            
            if(editorial == null)
                throw new Exception("No se encontro la editorial");
            
            super.desconectar();
            return editorial;
            
        } catch (Exception e) {
            throw e;
        }finally{
            super.desconectar();
        }
        
    }
    
    public Editorial buscarEditorialPorNombre(String nombre)throws Exception{
        
        try {
            super.conectar();
            Editorial editorial = (Editorial) em.createQuery("SELECT e FROM Editorial e where nombre like :nombre").setParameter("nombre", nombre).getSingleResult();
            
            if(editorial == null)
                throw new Exception("No se encontro la editorial");
            
            super.desconectar();
            return editorial;
            
        } catch (Exception e) {
            throw e;
        }finally{
            super.desconectar();
        }
    }
    
    public Collection<Editorial> listarEditoriales() throws Exception{
         
        try {
            
            super.conectar();
            Collection<Editorial> editoriales = em.createQuery("SELECT e FROM Editorial e ").getResultList();
            
            if(editoriales.isEmpty())
                throw new Exception("No se encontraron editoriales");
            
            super.desconectar();
            return editoriales;
            
        } catch (Exception e) {
            throw e;
        }finally{
            super.desconectar();
        }
        
    }
    
}
