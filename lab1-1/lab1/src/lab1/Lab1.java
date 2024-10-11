/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab1;

import java.util.Scanner;

/**
 *
 * @author LAB_A601
 */
public class Lab1 {
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
          Scanner scanner = new Scanner(System.in); 
        // se crea el objeto scan para lectura de datos por pantalla
        LibroDigital libroD = new LibroDigital();
        LibroFisico libroF = new LibroFisico();
       
     int opcion; 
        do {
            System.out.println("\nMenú de Libros:");
            System.out.println("1. CRUD Libro Digital");
            System.out.println("2. CRUD Libro Fisico");
            System.out.println("3. Mostrar Inventario de Libros");
            System.out.println("4. Vender Libro");
            System.out.println("0. Salir");
            System.out.print("Introduzca una opción: ");
              opcion = scanner.nextInt();
           scanner.nextLine(); // Consumir el salto de línea

         

            switch (opcion) {
                
                case 1:
                     libroD.menuDigital();
                    break;
                case 2:
                     libroF.menuFisico();
                    break;
                case 3:
                     System.out.println("Inventario");
                    break;
                case 4:
                     System.out.println("Venta");  
                    break;      
                case 0:
                    System.out.println("Saliendo del menú...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);

        scanner.close();
    }
   
        
    }
