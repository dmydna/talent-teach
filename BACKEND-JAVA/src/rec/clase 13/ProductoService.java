@Service // permite inyeccion de dependencias del service en OTRAS instancias
public class ProductoService {

    
    @Autowired // busca dependencias de forma automatica y la inyecta en ESTA instancia 
    private final ProductoRepository repo;

    public ProductoService(ProductoRepository repo) {
        this.repo = repo;
    }

    
    public List listarTodos() {
        return repo.findAll();
    }


    public Producto obtenerPorId(int id) {
        return repo.findById(id).orElse(null);
    }


    public Producto guardar(Producto p) {
        return repo.save(p);
    }


    public Producto actualizar(int id, Producto datos) {
        Producto p = obtenerPorId(id);
        if (p != null) {
            p.setNombre(datos.getNombre());
            p.setPrecio(datos.getPrecio());
            p.setCantidadEnStock(datos.getCantidadEnStock());
            return repo.save(p);
        }
        return null;
    }


    public boolean eliminar(int id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
   }
}


