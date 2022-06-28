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
        
        Libro libro = new Libro();
        
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
            
            do
            {
                System.out.print("Ingrese la cantidad de ejemplares: ");
                ejemplares = teclado.nextInt();
                
                if (ejemplares < 0)
                    System.out.println("El numero de ejemplares no puede ser negativo");
            }while(ejemplares< 0);
            
            
            
            do
            {
                System.out.print("Ingrese la cantidad de ejemplares prestados: ");
                ejemplaresPrestado = teclado.nextInt();
                
                if (ejemplaresPrestado > ejemplares || ejemplaresPrestado < 0)
                    System.out.println("No puede tener mas ejemplares prestados que la cantidad total de ejemplares fisicos");
                        
            }while ( ejemplaresPrestado > ejemplares || ejemplaresPrestado < 0);
            
            ejemplaresRestantes = ejemplares - ejemplaresPrestado;
            
            do
            {
                System.out.print("Alta(Y/N): ");
                bAlta = teclado.next().toUpperCase().charAt(0);
            }while( bAlta != 'Y' && bAlta!='N');
            
            if (bAlta=='Y')
                alta=true;
            else
                alta=false;
            
            /// limpieza de buffer
           // teclado.nextLine();
            
            do{
                System.out.print("Desar buscar un autor en la base de datos (Y/N): ");
                opcion = teclado.next().toUpperCase().charAt(0);
            }while ( opcion != 'Y' && opcion!='N');
            
            /// Opcion 1 : Lanzar excepcions 
            /// Opcion 2 : volver a pedir los ingresos
            
            if ( opcion == 'Y' )
            {
                System.out.print("Ingrese el codigo del autor a buscar: ");
                autorId= teclado.nextInt();
                autor = as.buscarAutorPorCodigo(autorId);
                
                if (autor == null)
                    throw new Exception("El autor no se encontro");
            }
            else
               autor = as.crearAutor(); 
           
            do{
                System.out.print("Desar buscar una editorial en la base de datos (Y/N): ");
                opcion = teclado.next().toUpperCase().charAt(0);
            }while ( opcion != 'Y' && opcion!='N');
            
            if ( opcion == 'Y' )
            {
                System.out.print("Ingrese el codigo de la editorial a buscar: ");
                editorialId= teclado.nextInt();
                editorial = es.buscarEditorialPorCodigo(editorialId);
                if (editorial == null)
                    throw new Exception("La editorial no se encontro");
            }
            else
               editorial = es.crearEditorial();
            
            
            libro.setIsbn(isbn);
            libro.setTitulo(titulo);
            libro.setAnio(anio);
            libro.setEjemplares(ejemplares);
            libro.setEjemplaresPrestados(ejemplaresPrestado);
            libro.setEjemplaresRestantes(ejemplaresRestantes);
            libro.setAlta(alta);
            libro.setAutor(autor);
            libro.setEditorial(editorial);
            
            libroDAO.guardarLibro(libro);
            
            return libro;
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
