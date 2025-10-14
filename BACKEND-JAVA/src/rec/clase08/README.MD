# Modulos de Java

Un __modulo__ de Java es un conjunto de __paquetes__, a su vez un __paquete__ esta compuesto por  un __conjunto de Clases__. 
<BR>

El sistema de modulos de Java permite que cada __Modulo__ defina que paquetes son publicos  o  privados _(exportables)_.
De esta forma cualquier Modulo puede usar _(importar)_ paquetes publicos de otros modulos. 

Para eso __cada modulo__ tiene definido en su propio `module-info.java` los paquetes que se pueden exportar y sus dependencias .. 

## Estructura de directorios


```
root/
  ├── mi_modulo_uno/
  │      └── module-info.java      
  ├── mi_modulo_dos/
  │      └── module-info.java  
  └── mi_modulo_tres/
  ...

```
### Ejemplo de Modulo: 

__modulo__: `mi.modulo`
```
root/mi.modulo
  ├── module-info.java                ← define el módulo mi-modulo  
  └── src/com
      ├── tienda/app/                 ← paquete com.tienda.app    
      │        └── Main.java          * punto de entrada del modulo
      ├── tienda/productos            ← paquete com.tienda.productos
      │        ├── Productos.java
      │        └── Categoria.java   
      └── negocios/turbios            ← paquete com.negocios.turbios
              └── Contable.java           
```

Contiene los paquetes: <BR>
`com.negocios.turbios`, `com.tienda.app`, `tienda.productos`<BR>

>__Nota__: 
>Los modulos pueden depender de otro modulos.<BR>
>ej: 
>`mi-modulo-2` puede depender de `mi-modulo-1`<BR> 
> usando `requires mi.modulo-1;`


### Ejemplo de paquete

__paquete__ `com.tienda.productos`

```
com/tienda/productos/
 ├── Producto.java
 ├── Categoria.java
 └── Inventario.java
```
Contiene todas las clases relacionadas con los productos de la tienda

### Definicion de Modulo:

####  module-info.java

```java
module mi.modulo {
    // define que paquetes se pueden usar por desde otros modulos
    exports com.tienda.app;        // permite usar Main.java 
    exports com.tienda.productos;  // permite usar el paquete productos
    requires mi.modulo.dos;        // define dependencia de otro modulo 
   // com.negocios.turbios
}
``` 
el paquete ``com.negocios.turbios`` asi como otros paquetes que no estan definidos,
no se pueden usar desde otros modulo.


#### Main.java

```java
package com.tienda.app; // paquete donde pertence Main.java

// importamos las clases del paquete com.tienda.productos:        
import com.tienda.productos.Productos
import com.tienda.productos.Categorias   

// esto no es necesario pues estos paquetes pertencen al modulo.
```
<HR>

### Desde Otros Modulos:

__modulo__: `otro.modulo` 


#### Estructura de directorio
```
root/otro-modulo/
  ├── module-info.java                 ← define el módulo otro-modulo  
  └── src/com
      ├── casa/puerta/                 ← paquete com.casa.puerta
      │      └── Main.java             * punto de entrada de modulo
      └── casa/ventana                 ← paquete com.casa.ventana
             └── AbrirVentana.java 
``` 


#### Main.java

```java
package com.casa.puerta; // paquete donde pertence Main.java
 
// importa clases del paquete com.tienda.productos (del modulo mi-modulo)
import com.tienda.productos.Productos
import com.tienda.productos.Categoria
        
// no puedo importar porque no esta definido (en info-module.java de mi-modulo)        
import com.negocios.turbios.Contable        

```

---
### Notas Finales

- Desde el `Main.java` en el mismo modulo o paquete, no hace falta usar `import`
pero se hace por convencion. Es decir los import son necesarios para usar paquetes de otros modulos
- El `modulo-info.java` solo restringe para afuera, no para el mismo modulo.
- Cada Modulo tiene su propio `Main.java` y `modulo-info.java`
