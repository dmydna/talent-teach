/** Clase 07 - Herencia y Polimorfismo */
import com.techlab.inicio.Coffee;
import com.techlab.inicio.Producto;
import com.techlab.inicio.Te;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        int stock = 12;

        ArrayList<Producto> productos = new ArrayList<>();
        productos.add(new Coffee("Cafe Suave", 5.7, stock, 3));
        productos.add(new Te("Te Amargo", 10.7, stock, 4));
        productos.add(new Coffee("Cafe Negro", 8, stock,5));

        imprimirProductos(productos);

    }

    public static void imprimirProductos(ArrayList<Producto> productos){
        for (Producto p : productos){
                System.out.printf("\nProducto: %-10s  \n Stock: %d \n Precio: %f \n PrecioFinal: %-10s",
                        p.getNombre() , p.getCantidadEnStock(), p.getPrecio() , p.calcularPrecioFinal()) ;
        }
    }
}

