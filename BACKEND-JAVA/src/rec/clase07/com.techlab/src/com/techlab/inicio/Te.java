package com.techlab.inicio;

public class Te extends Producto{

    public Te(String nombre, double precio, int cantidadEnStock, double volumenEnLitros){
        // Es el constructor de producto.
        // Mandanda parametros  al constructor para inicializarlos.
        super(nombre, precio, cantidadEnStock);
    }

    public double calcularPrecioFinal(){
        return 1;
    }
}
