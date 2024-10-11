/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab1;
//import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author LAB_A601
 */
public class LibroDigital extends Libro {
    private double tamano; //MB
    private String formato;
    private double precio;
  //  ArrayList<LibroDigital> listaLibrosD= new ArrayList<>();
    
     // Creamos algunos libros digitales de ejemplo
        LibroDigital libro1 = new LibroDigital("AL123", "Batman","Nolan",20.0,24.0,5,2024,"accion",1,20.0,"PDF");
        LibroDigital libro2 = new LibroDigital("ABCD", "Mi Jardin","Planeta",5.0,6.2,7,2000,"niños",1,10.0,"PDF");

      
    
    
    
    public double getTamano() {
        return tamano;
    }

    public String getFormato() {
        return formato;
    }

    public void setTamano(double tamano) {
        this.tamano = tamano;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }
    
    
     public LibroDigital(String codigoLibro,String tituloLibro ,String autorLibro ,double costoLibro, double precioLibro, int librosDisponible,int anopublicacion, String categoria, int estado, double tamano, String formato) {
        super(codigoLibro,tituloLibro ,autorLibro ,costoLibro,precioLibro,librosDisponible,anopublicacion,categoria,estado); // invoca al constructor con parámetros de la clase padre
        this.tamano = tamano;
        this.formato = formato;
        //Constructor atributos propios de LibroDigital y que también llama al constructor de la clase base        
    }
     
    public LibroDigital(){
    } 
     
     public void mostrarValor() {
        double precio = getPrecioLibro();
        System.out.println(precio);
    }
     
     /*public void mostrarLibrosDigitales(ArrayList<LibroDigital> listaLibrosD){
         LibroDigital libro = listaLibrosD;
         int cont=listaLibrosD.size();
         System.out.println("Tamaño de la lista: " + listaLibrosD.size());
      while(cont>0){
            System.out.println(cont+". "+libro.getTituloLibro()+"Disponibles: "+libro.getLibrosDisponible());
            cont--;
      }
     }
*/
     
     
 //    public void mostrarLibrosDigitales(ArrayList<LibroDigital> listaLibrosD) {
 //   System.out.println("Tamaño de la lista: " + listaLibrosD.size());
//    int cont=1;
 //   for (int i=0; i<listaLibrosD.size(); i++)    
 //   {
  //      LibroDigital libro = listaLibrosD.get(i);
    //    System.out.println(cont + ". " + libro.getTituloLibro() + " Disponibles: " + libro.getLibrosDisponible());
   //     cont++;
  //  }
//}
            
    @Override
    public void leerDatos(String mensaje){
     super.leerDatos(mensaje); // se aprovecha la impresión de los datos principales
                               // en la clase padre,<<super>> permite el acceso a un método de 
                               // la clase Padre
        System.out.print("Indica tamano (MB): ");
        tamano = datos.nextDouble();
         datos.nextLine();
        System.out.print("Indica formato: ");
         formato = datos.nextLine();
         
    }
    
        @Override
    public void imprimirDatos(String mensaje){
    super.imprimirDatos(mensaje); // se aprovecha la impresión de los datos principales
                               // en la clase padre,<<super>> permite el acceso a un método de 
                               // la clase Padre
    System.out.print("El tamano del archivo es: "+ tamano+" MB ");
    System.out.print("El formato del archivo es: "+formato);
    }
       @Override
    public double calcularPrecioLibro(){
    precio=super.calcularPrecioLibro();
    precio= precio-(precio*(0.10));
            return precio;
    } 
    
    //menu de seleccion para libro Digital
    
    public void menuDigital(){
        int opcion; 
        Scanner scanner = new Scanner(System.in);
        LibroDigital lib = new LibroDigital(); //se inicializa globalmente nuestra variable libro
          // Añadimos a la lista
        listaLibrosD.add(libro1);
        listaLibrosD.add(libro2);

        do {
            System.out.println("\nMenú de Libros Digitales:");
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
                     listaLibrosD.add(lib);
                    break;
                case 2:
                     lib.imprimirDatos("Imprimiendo Datos del Libro");
                   //  mostrarLibrosDigitales(listaLibrosD);
                    break;
                case 3:
                     System.out.println("Marcando como no disponible (estado=0) ");
                     lib.marcarNoDisponible();   
                    break;
                case 4:
                     System.out.println("Aplicando Descuento");
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
