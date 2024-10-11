/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab1;
import java.util.Scanner;

/**
 * @author LAB_A601
 */
public abstract class Libro {
    private String codigoLibro;
    private String tituloLibro;
    private String autorLibro;
    private double costoLibro;
    private double precioLibro;
    private int librosDisponible;
    private int anopublicacion;
    private String categoria;
    private int estado;
    
      public Libro(String codigoLibro,String tituloLibro ,String autorLibro ,double costoLibro, double precioLibro, int librosDisponible,int anopublicacion, String categoria, int estado) {
        this.codigoLibro = codigoLibro;
        this.tituloLibro = tituloLibro;
        this.autorLibro = autorLibro;
        this.costoLibro = costoLibro;
        this.precioLibro = precioLibro;
        this.librosDisponible = librosDisponible;
        this.anopublicacion = anopublicacion;
        this.categoria = categoria;
        this.estado = estado;
    }
    
    public Libro(){
        codigoLibro="";
        tituloLibro="";
        autorLibro=""; 
        costoLibro=2;
        precioLibro=10.0;
        librosDisponible=1;
        anopublicacion=0;
        categoria="Locura";
        estado=0;     
    }
    Scanner datos = new Scanner(System.in);
    
    public String getCodigoLibro() {
        return codigoLibro;
    }

    public String getTituloLibro() {
        return tituloLibro;
    }

    public String getAutorLibro() {
        return autorLibro;
    }

    public double getCostoLibro() {
        return costoLibro;
    }

    public double getPrecioLibro() {
        return precioLibro;
    }

    public int getLibrosDisponible() {
        return librosDisponible;
    }

    public int getAnopublicacion() {
        return anopublicacion;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getEstado() {
        return estado;
    }

    public void setCodigoLibro(String codigoLibro) {
        this.codigoLibro = codigoLibro;
    }

    public void setTituloLibro(String tituloLibro) {
        this.tituloLibro = tituloLibro;
    }

    public void setAutorLibro(String autorLibro) {
        this.autorLibro = autorLibro;
    }

    public void setCostoLibro(double costoLibro) {
        this.costoLibro = costoLibro;
    }

    public void setPrecioLibro(double precioLibro) {
        this.precioLibro = precioLibro;
    }

    public void setLibrosDisponible(int librosDisponible) {
        this.librosDisponible = librosDisponible;
    }

    public void setAnopublicacion(int anopublicacion) {
        this.anopublicacion = anopublicacion;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    public void leerDatos(String mensaje){
     // método para leer los datos por pantalla.
        System.out.println(mensaje);
        System.out.print("Indica Còdigo del Libro: ");
        codigoLibro = datos.nextLine(); //utiliza el objeto Scanner para capturar un string desde la pantalla
        System.out.print("Indica nombre del Libro: ");
        tituloLibro = datos.nextLine(); 
        System.out.print("Indica autor del Libro: ");
        autorLibro = datos.nextLine(); 
        System.out.print("Indica costo del Libro: ");
        costoLibro = datos.nextDouble(); 
        precioLibro= calcularPrecioLibro();
        System.out.print("Indica cantidad de unidades disponibles: ");
        librosDisponible = datos.nextInt(); 
        System.out.print("Indica año de publicacion del Libro: ");
        anopublicacion = datos.nextInt();
        datos.nextLine();
        System.out.print("Indica Categoria del libro: ");
        categoria = datos.nextLine(); 
        System.out.print("Indica el estado de venta del libro: ");
        estado = datos.nextInt();  
    }
    
    public void marcarNoDisponible(){ //si el estado es =1 esta disponible para la venta
    if (estado==1){
        estado=0;
    }else{ 
        System.out.println("no se hizo ningún cambio ya que el estado es no disponible");
    }
    }
    public double actualizarPrecio(){
        double porcentajeDescuento;
        System.out.println("Coloque el porcentaje a descontar en el precio");
        porcentajeDescuento = datos.nextDouble();
        precioLibro=precioLibro-(precioLibro*(porcentajeDescuento/100.0));
        return precioLibro;
    }
        public void imprimirDatos(String mensaje){
        System.out.println("*************************************************************");
        System.out.println("******* "+mensaje+ "*******");
        System.out.println("Còdigo del Libro: "+codigoLibro);
        System.out.println("Titulo del Libro: "+tituloLibro);
        System.out.println("Autor del Libro: "+autorLibro);
        System.out.println("Costo del Libro: "+costoLibro);
        System.out.println("precio del Libro: "+precioLibro);
        System.out.println("Cantidad Disponible del Libro: "+librosDisponible);
        System.out.println("Anio de publicacion: "+anopublicacion);
        System.out.println("Categoria del Libro: "+categoria);
        System.out.println("estado de venta del libro: "+estado);  
    }
        
    public void indicarReposicion(){
    if (librosDisponible<=1){
        System.out.println("Còdigo del Libro: "+codigoLibro);
        System.out.println("Titulo del Libro: "+tituloLibro);
        System.out.println("Autor del Libro: "+autorLibro);
        System.out.println("Necesita reposicion");      
    }else{
        System.out.println("Còdigo del Libro: "+codigoLibro);
        System.out.println("Titulo del Libro: "+tituloLibro);
        System.out.println("No necesita reposicion");      
    }
    } 
    
    
    public double calcularPrecioLibro(){
    int porcentajeGanancia;
    System.out.println("El libro seleccionado tiene un costo de "+costoLibro);
    do{
    System.out.println("Indique el porcentaje de ganancia que desea obtener:");
    System.out.println("Coloque un numero no mayor al 50%");
     porcentajeGanancia= datos.nextInt(); }
      while (porcentajeGanancia>50);
              precioLibro=costoLibro+(costoLibro*(porcentajeGanancia/100.0));
              System.out.println("Ahora el Precio es: "+ precioLibro);
            return precioLibro;
    }
    
    
    
    
    
    
    }  

