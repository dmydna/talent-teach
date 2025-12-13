// Genera una tabla en BD usada por Respository.

import jakarta.persistence.*;
import lombok.Data; // Importamos la anotación clave

@Entity // Indica que esta clase se mapeará a una tabla.
@Table(name = "producto") //Nombre de la tabla
@Data // <--- ¡Esto genera automáticamente getters, setters, equals, hashCode y toString!
public class Producto {
    @Id// Llave primaria autoincremental.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Llave primaria autoincremental.
    @Getter
    private Integer id;
    @Getter @Setter
    private String nombre;
    @Getter @Setter
    private Double precio;
    @Getter @Setter
    private Integer cantidadEnStock;

    //definir getters y setters (sin lombok)
}


/*declarar dependencies en pom.xml
<dependencies>
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <optional>true</optional>
    </dependency>
</dependencies>*/

