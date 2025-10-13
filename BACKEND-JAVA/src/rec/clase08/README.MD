# Modulos de Java

Un __modulo__ de Java es conjunto de __paquetes__, a su vez un __paquete__ esta compues por  un __conjunto de Clases__.
El sistema de modulos de Java permite que cada Modulos defina que paquetes son publicos  o  privados.
De esta forma cualquier Modulo puede usar paquetes publicos de otros modulos. 

Para eso __cada modulo__ tiene definido en su propio `module-info.java` los paquetes que se pueden exportar, sus dependencias etc.. 

## Estructura de directorios


```
root/
  ├── mi-modulo-1/com..
  │      └── module-info.java      
  ├── mi-modulo-2/com..
  │      └── module-info.java  
  └── mi-modulo-3/com..

```
### Ejemplo de Modulo: 

__modulo__: `mi-modulo-1`
```
root/mi-modulo-1/com/src/
  ├── module-info.java                ← define el módulo mi-modulo-1   
  ├── com/negocios/turbios            ← paquete com.negcios.turbios
          └── Contable.java
  ├── com/tienda/productos            ← paquete com.tienda.productos
  │      ├── Productos.java
  │      └── Categoria.java   
  └── com/tienda/app/Main.java        ← punto de entrada
                
```

Contiene los paquetes: <BR>
`com.otro.otro`, `com.tienda.negocios`, `tienda.productos`<BR>

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

`module-info.java`

```java
// module-info.java

module mi.modulo {
    // define que paquetes se pueden usar por desde otros modulos
    exports com.tienda.app;        // permite usar Main.java 
    exports com.tienda.productos;  // permite usar el paquete productos
   // no esta com.negocios.turbios 
   // porlo que no se puede usar desde afuera. 
}


// *MI-MODULO-1

// main.java
package com.tienda.app; // paquete donde pertence Main.java

// importamos las clases del paquete com.tienda.productos:        
import com.tienda.productos.Productos
import com.tienda.productos.Categorias   

```

### Dede Otro Modulo:

modulo: `mi-modulo-2` 

```
root/mi-modulo-2/com/src/
  ├── module-info.java                 ← define el módulo mi-modulo-2   
  ├── com/casa/puerta                  ← paquete com.casa.puerta
  │       └── AbrirPuerta.java 
  └── com/casa/app/Main.java           ← punto de entrada de modulo
``` 
```java

// main.java
package com.casa.app; // paquete donde pertence Main.java
 
// importo clases 
// del paquete com.tienda.productos 
// (de otro modulo mi-modulo-1)
import com.tienda.productos.Productos
import com.tienda.productos.Categoria
        
// no puedo importar porque no esta definido en info-module.java de mi-modulo-1        
import com.negocios.turbios.Contable        

```


### Notas Finales

- Desde el `Main.java` en el mismo modulo o paquete, no hace falta usar `import`
pero se hace por convencion. Es decir los import son necesarios para usar paquetes de otros modulos
- El `modulo-info.java` solo restringe para afuera, no para el mismo modulo.
- Cada Modulo tiene su propio `Main.java` y `modulo-info.java`
