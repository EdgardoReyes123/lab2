/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab1;
import java.util.ArrayList;

import java.util.Scanner;

/**
 *
 * @author LAB_A601
 */
public class LibroFisico extends Libro{
    private double peso; //KG
    private double costoEnvio;
    private double precio;
    private ArrayList<LibroFisico> listaLibrosF = new ArrayList<>();
    
      // Creamos algunos libros Fisicos de ejemplo
        LibroFisico libro1 = new LibroFisico("SF123", "Neuromante", "William Gibson", 15.99, 25.8, 350, 1984, "ciencia ficción", 1, 0.5 , 10.0);
        LibroFisico libro2 = new LibroFisico("SF456", "Dune", "Frank Herbert", 12.99, 300.0, 500, 1965, "ciencia ficción", 1, 0.3, 8.0);

    public double getPeso() {
        return peso;
    }

    public double getCostoEnvio() {
        return costoEnvio;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setCostoEnvio(double costoEnvio) {
        this.costoEnvio = costoEnvio;
    }

  
    
     public LibroFisico(String codigoLibro,String tituloLibro ,String autorLibro ,double costoLibro, double precioLibro, int librosDisponible,int anopublicacion, String categoria, int estado, double peso, double costoEnvio) {
        super(codigoLibro,tituloLibro ,autorLibro ,costoLibro,precioLibro,librosDisponible,anopublicacion,categoria,estado); // invoca al constructor con parámetros de la clase padre
        this.peso = peso;
        this.costoEnvio = costoEnvio;
        //Constructor atributos propios de LibroFisico y que también llama al constructor de la clase base        
    }
     
    public LibroFisico(){
        
   
    } 
     
     public void mostrarValor() {
        double precio = getPrecioLibro();
        System.out.println(precio);
    }
            
    @Override
    public void leerDatos(String mensaje){
     super.leerDatos(mensaje); // se aprovecha la impresión de los datos principales
                               // en la clase padre,<<super>> permite el acceso a un método de 
                               // la clase Padre
        System.out.print("Indica peso (KG)");
        peso = datos.nextDouble();
         datos.nextLine();
        System.out.print("Indica costo de envio");
         costoEnvio= datos.nextDouble();
    }
    
        @Override
    public void imprimirDatos(String mensaje){
    super.imprimirDatos(mensaje); // se aprovecha la impresión de los datos principales
                               // en la clase padre,<<super>> permite el acceso a un método de 
                               // la clase Padre
    System.out.print("El peso del libro es: "+ peso+" KG ");
    System.out.print("El costo del envio del libro es: "+costoEnvio);
    }
       @Override
    public double calcularPrecioLibro(){
    precio=super.calcularPrecioLibro();
    precio= precio+costoEnvio;
            return precio;
    } 
    
    public void mostrarLibrosFisico(ArrayList<LibroFisico> listaLibrosF) {
    System.out.println("Tamaño de la lista: " + listaLibrosF.size());
    int cont=1;
    for (int i=0; i<listaLibrosF.size(); i++)    
    {
        LibroFisico libro = listaLibrosF.get(i);
        System.out.println(cont + ". " + libro.getTituloLibro() + " Disponibles: " + libro.getLibrosDisponible());
        cont++;
    }
}
    
    //menu de seleccion para libro fisico
    
    public void menuFisico(){
        int opcion; 
        listaLibrosF.add(libro1);
        listaLibrosF.add(libro2);
        Scanner scanner = new Scanner(System.in);
        LibroFisico lib = new LibroFisico(); //se inicializa globalmente nuestra variable libro

        do {
            System.out.println("\nMenú de Libros Fisico:");
            System.out.println("1. Crear nuevo libro");
            System.out.println("2. Mostrar Informacion de Libro");
            System.out.println("3. Marcar como no disponible (para la venta) un Libro");
            System.out.println("4. Aplicar descuento al precio de un libro");
            System.out.println("5. Revisar Reposicion");
            System.out.println("0. Salir");
            System.out.print("Introduzca una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea
            
            switch (opcion) {
                
                case 1:
                     lib.leerDatos("Ingrese los datos solicitados: ");
                     listaLibrosF.add(lib);
                    break;
                case 2:
                     lib.imprimirDatos("Imprimiendo Datos del Libro: ");
                    // mostrarLibrosFisico(listaLibrosF);
                    break;
                case 3:
                     System.out.println("Marcando como no disponible (estado=0)");
                     lib.marcarNoDisponible();   
                    break;
                case 4:
                     System.out.println("Aplicando Descuento: ");
                     lib.actualizarPrecio();   
                    break;  
                case 5:
                    System.out.println("Revisando reposicion....");
                     lib.indicarReposicion();
                    
                    break;
                    
                case 0:
                    System.out.println("Saliendo del menú...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }       
}
