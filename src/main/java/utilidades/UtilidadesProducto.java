package utilidades;

import modelos.Almacen;
import modelos.Producto;
import modelos.TipoProducto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UtilidadesProducto {


    /**
     *
     * a. public List<Producto> getPorTipo(List<Producto> productos,
     * TipoProducto tipo).
     * El método devuelve la lista de productos del tipo que se le pasa
     * como parámetro.
     */
    public List<Producto> getPorTipo(List<Producto> productos, TipoProducto tipo){

        List<Producto> productosFinales = new ArrayList<>();


        //Recorrer los productos (var in lista)
        for(Producto p : productos){
            //Comprobar que el producto(p) es del tipo que me pasa (tipo)
            if (p.getTipoProducto().equals(tipo)){
                productosFinales.add(p);
            }
        }

        return productosFinales;
    }



    public List<Producto> getPorTipoStream(List<Producto> productos, TipoProducto tipo){

        //Stream -> Objeto de las librerías de Java (Java 8) , te sirve para tratar con colecciones y hacer una serio de métodos
        //que se aplican a esas colecciones.

        //Expresiones lambda
        // nombre -> (Lo que voy a hacer)
        return productos
                .stream()
                .filter(p ->  p.getTipoProducto().equals(tipo))
                .collect(Collectors.toList());

    }

    /**
     *
     * b. public List<Productos> getPorAlmacen(List<Producto> productos,
     * Almacen almacen)
     * El método devuelve la lista de productos del almacen que se le pasa
     * como parámetro.
     */

    public List<Producto> getPorAlmacen(List<Producto> productos, Almacen almacen){
        List<Producto> productosFinales = new ArrayList<>();

        //Recorrer los productos (var in lista)
        for(Producto p : productos){
            if (p.getAlmacen().equals(almacen)){
                productosFinales.add(p);
            }
        }
        return productosFinales;

    }


    public List<Producto> getPorAlmacenStream(List<Producto> productos, Almacen almacen){
        return productos
                .stream()
                .filter(p ->  p.getAlmacen().equals(almacen))
                .collect(Collectors.toList());

    }
}
