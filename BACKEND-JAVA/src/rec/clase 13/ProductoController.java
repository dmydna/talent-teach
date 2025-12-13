@RestController// Indica que esta clase maneja solicitudes HTTP y devuelve datos en formato JSON
@RequestMapping("/productos") // Define la ruta base para todos los endpoints del controlador
public class ProductoController {
    private final ProductoService productoService;

    @Autowired
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @PostMapping //indica que este endpoint maneja peticiones HTTP POST.
    public ResponseEntity crearProducto(@RequestBody Producto producto) {
       // @RequestBody indica que el cuerpo de la petición será un objeto JSON del tipo Producto
        return ResponseEntity.ok(productoService.guardar(producto));
    }

    @GetMapping //indica que este endpoint maneja peticiones HTTP GET.
    public ResponseEntity<List<Producto>> listarTodos() {
    // El método llama al servicio ProductoService para recuperar todos los productos de la base de datos. 
   // Finalmente, devuelve una lista de productos en formato JSON.
        return ResponseEntity.ok(productoService.listarTodos());
    }

    @PutMapping("/{id}") // indica que este endpoint maneja peticiones HTTP POST.
    public ResponseEntity actualizar(@PathVariable Long id, @RequestBody Producto producto) {
        /*Recibe el ID del producto a actualizar y un objeto JSON de tipo Producto con los cambios deseados. Llama al servicio ProductoService para actualizar el producto en la base de datos y devuelve el producto actualizado en formato JSON.*/
        return ResponseEntity.ok(productoService.actualizar(producto, id));
    }

    @DeleteMapping("/{id}") //  indica que este endpoint maneja peticiones HTTP DELETE
    public ResponseEntity eliminar(@PathVariable Long id) {
        /* Recibe el ID del producto a eliminar como parámetro de ruta. Llama al servicio 
ProductoService para eliminar el producto de la base de datos y devuelve un código de estado HTTP 204
 (No Content) para indicar que la operación se completó con éxito.
        productoService.eliminar(id); */
        return ResponseEntity.noContent().build();
    }
}
