import com.techlab.inicio.Cliente;
import com.techlab.inicio.Producto;

public class Main {
    public static void main(String[] args) {

        Producto Cafe = new Producto("Cafe",5.6, 12);
        Producto Te = new Producto("Te",4.0, 7);
        Producto Manzana = new Producto("Manzana",1.5, 10);

        Cliente cliente1 = new Cliente("Adrian","adn@mail");
        Cliente cliente2 = new Cliente("Juan","jn@mail");
        Cliente cliente3 = new Cliente("Maria","mra@mail");

        System.out.println("\nProductos: \n");
        imprimirProducto(Cafe);
        imprimirProducto(Te);
        imprimirProducto(Manzana);

        System.out.println("\nClientes: \n");
        imprimirCliente(cliente1);
        imprimirCliente(cliente2);
        imprimirCliente(cliente3);

    }

    static void imprimirProducto(Producto p){
        p.mostrarInformacion();
        p.aplicarDescuento();
        System.out.println("precio con Descuento: " + p.precio);
        System.out.println("-------------------------------------");
    }

    static void imprimirCliente(Cliente c){
        System.out.println("Nombre: " + c.nombre + "\n" +
                           "Mail: " + c.email );
        System.out.println("-------------------------------------");
    }
}