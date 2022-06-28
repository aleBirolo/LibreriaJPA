/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.servicios;

import java.util.Scanner;
import libreria.Persistencia.LibroDAO;
import libreria.entidades.Autor;
import libreria.entidades.Editorial;
import libreria.entidades.Libro;

/**
 *
 * @author Alejandro Birolo
 */
public class LibroServicio {
   
    private Scanner teclado;
    private final LibroDAO libroDAO;

    public LibroServicio( ) {
        this.libroDAO = new LibroDAO();
    }
    
    public Libro crearLibro() throws Exception{
        
        try {
            teclado = new Scanner(System.in).useDelimiter("\n");
            long isbn=0;
            String titulo;
            Integer anio;
            Integer ejemplares;
            Integer ejemplaresPrestado;
            Integer ejemplaresRestantes;
            char bAlta;
            Boolean alta;
            Autor autor;
            Editorial editorial;
            AutorServicio as = new AutorServicio();
            EditorialServicio es = new EditorialServicio();
            char opcion;
            Integer autorId;
            Integer editorialId;
            
            System.out.print("Ingrese ISBN del libro: ");
            isbn = teclado.nextLong();
            
            if (isbn == 0)
                throw new Exception("El ISBN del libro no puede ser cero");
            
            System.out.print("Ingrese titulo del libro: ");
            titulo = teclado.next();
            
            System.out.print("Ingrese Año del libro: ");
            anio = teclado.nextInt();
            
            System.out.print("Ingrese Año del libro: ");
            ejemplares = teclado.nextInt();
            
            System.out.print("Ingrese la cantidad de ejemplares: ");
            ejemplares = teclado.nextInt();
            
            do
            {
                System.out.print("Ingrese la cantidad de ejemplares prestados: ");
                ejemplaresPrestado = teclado.nextInt();
                
                if (ejemplaresPrestado > ejemplares)
                    System.out.println("No puede tener mas ejemplares prestados que la cantidad total de ejemplares fisicos");
                        
            }while ( ejemplaresPrestado > ejemplares);
            
            ejemplaresRestantes = ejemplares - ejemplaresPrestado;
            
            do
            {
                System.out.print("Alta(Y/N): ");
                bAlta = teclado.next().toUpperCase().charAt(0);
            }while( bAlta != 'Y' || bAlta!='N');
            
            if (bAlta=='Y')
                alta=true;
            else
                alta=false;
            
            do{
                System.out.println("Desar buscar un autor en la base de datos: (Y/N)");
                opcion = teclado.next().toUpperCase().charAt(0);
            }while ( opcion != 'Y' || opcion!='N');
            
            if ( opcion == 'Y' )
            {
                System.out.print("Ingrese el codigo del autor a buscar: ");
                autorId= teclado.nextInt();
                autor = as.buscarAutorPorCodigo(autorId);
            }
            else
               autor = as.crearAutor(); 
           
            do{
                System.out.println("Desar buscar una editorial en la base de datos: (Y/N)");
                opcion = teclado.next().toUpperCase().charAt(0);
            }while ( opcion != 'Y' || opcion!='N');
            
            if ( opcion == 'Y' )
            {
                System.out.print("Ingrese el codigo de la editorial a buscar: ");
                editorialId= teclado.nextInt();
                editorial = es.buscarEditorialPorCodigo(editorialId);
            }
            else
               editorial = es.crearEditorial();
            
            return new Libro(isbn, titulo, anio, ejemplares, ejemplaresPrestado, ejemplaresRestantes, alta, autor, editorial);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public Libro buscarLibroPorCodigo(Long isbn) throws Exception{
        try {
            
            return null;
        } catch (Exception e) {
            throw e;
        }
    }
}
