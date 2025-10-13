package com.techlab.inicio;

public class Bebida extends Producto implements Descontable{
    private double volumenEnLitros;

    public Bebida(String nombre, double precio, int cantidadEnStock, double volumenEnLitros){
        super(nombre, precio, cantidadEnStock);
        this.volumenEnLitros = volumenEnLitros;
    }

    @Override
    public double aplicarDecuento(double porcentaje) {
        return getPrecio()*0.95;
    }

    @Override
    public double calcularPrecioFinal() {
        return 0;
    }
}