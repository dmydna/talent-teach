package com.techlab.inicio;

public class Producto {
    public String nombre;
    public double precio;
    public int cantidadEnStock;



    // Constructor con parametros
    public Producto(String nombre, double precio, int cantidadEnStock){
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadEnStock = cantidadEnStock;
    }


    public void descontarStock(int cantidad){
        this.cantidadEnStock -= cantidad;
    }

    public static double calcularImpuestos(double precio){
        return precio * 0.21;
    }

    public void aplicarDescuento(){
        this.precio *= 0.10;
    }
    public void mostrarInformacion(){
        System.out.println("Nombre: "  + this.nombre + "\n" +
                           "Precio: " + this.precio + "\n" +
                           "Stock: " + this.cantidadEnStock) ;
    }

}


