package com.techlab.inicio;

public class Producto {
    private String nombre;
    private double precio;
    private int cantidadEnStock;

    static int cantidadProductosCreados = 0;


    // Constructor con parametros
    public Producto(String nombre, double precio, int cantidadEnStock){
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadEnStock = cantidadEnStock;
        cantidadProductosCreados = 0;
    }


    public String getNombre(){
        return nombre;
    }


    public void setNombre(String nombre){
        if(nombre != null && !nombre.trim().isEmpty()){
            this.nombre = nombre;
        }
    }

    public double getPrecio(){
        return precio;
    }

    public void setPrecio(double precio){
        if(precio >= 0){
            this.precio = precio;
        }
    }

    public int getCantidadEnStock(){
        return cantidadEnStock;
    }

    public void setCantidadEnStock(int cantidadEnStock){
        if(cantidadEnStock >= 0){
            this.cantidadEnStock = cantidadEnStock;
        }
    }

    public void descontarStock(int cantidad){
        this.cantidadEnStock -= cantidad;
    }

    public static double calcularImpuestos(double precio){
        return precio * 0.21;
    }

    public void mostrarInformacion(){
        System.out.println("Nombre: " + this.nombre + "\n" +
                           "Precio: " + this.precio + "\n" +
                           "Stock: "  + this.cantidadEnStock);
    }

}


