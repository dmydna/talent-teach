@Repository
public interface ProductoRepository extends JpaRepository {
    // Métodos personalizados aquí si son necesarios
}


// Metodos Heredados de JPA. (usados en Service)

// Operaciones CRUD:
// Create: save() , create()
// Read:   findAll(), findById(ID), etc.
// Update: save()
// Delete: delete() o deleteById(ID)
