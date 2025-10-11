import com.techlab.inicio.Carrito;
import com.techlab.inicio.Producto;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {


        int stock = 15;

        ArrayList<Producto> productos = new ArrayList<>();
        productos.add(new Producto("Cafe", 5.7, stock));
        productos.add(new Producto("Te", 10.7, stock));
        productos.add(new Producto("Manzana", 8, stock));
        productos.add(new Producto("Orange", 17.2, stock));

//        testStock(productos, stock);
//        carritoIterativo(productos);

    }


    static void testStock(ArrayList<Producto> productos, int stock){
        Carrito carrito = new Carrito();
        int i=0, j=0;

        for (Producto p: productos) {
            carrito.agregarProducto(p, i++);
        }

        for (Producto p : carrito.getProductos()){
            int cantidad = stock - j++;
            if(p.getCantidadEnStock() != cantidad){
                System.out.println("Error en cantidad en Carrito!");
            }else{
                System.out.printf("\nProducto: %-10s  \n Stock Inicial: %d \n Stock Actual: %d \n Cantidad en Carrito: %d\n",
                        p.getNombre() ,stock,  cantidad, (stock - cantidad) ) ;
            }
        }
    }

    static void carritoIterativo(ArrayList<Producto> productos){
        Carrito carrito = new Carrito();
        agregarCarritoSCanner(productos, carrito);
        System.out.println("\n========= Productos en Carrito ==========\n");
        ImprimirArrayProductos(carrito.getProductos());
    }

    // auxiliar
    static void agregarCarritoSCanner(ArrayList<Producto> productos, Carrito c){
        Scanner sc = new Scanner(System.in);
        for (Producto p : productos){
            p.mostrarInformacion();
            System.out.println("¿Desea agregar al Carrito? (s/n): ");
            String respuesta = sc.nextLine().trim().toLowerCase();

            if(respuesta.equals("s")){
                System.out.println("Ingrega Cantidad: ");
                String cantidad = sc.nextLine().trim().toLowerCase();
                c.agregarProducto(p, Integer.parseInt(cantidad));
                System.out.println(p.getNombre().toUpperCase() + " agregado al carrito. \n");
            }else{
                System.out.println( " ...no agrega al carrito. \n");
            }
        }
        sc.close();
    }

    // auxiliar
    static  void  ImprimirArrayProductos(ArrayList<Producto> productos){
        for (Producto p : productos){
            String bloque = """
                === Detalle del producto ===
                Nombre: %s
                Precio: $%.2f
                Stock: %d unidades
                """.formatted(p.getNombre(), p.getPrecio(), p.getCantidadEnStock());

            System.out.println(bloque);
        }
    }




}