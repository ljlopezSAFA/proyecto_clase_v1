package utilidades;

import modelos.Cliente;
import modelos.Factura;
import modelos.LineaFactura;

import java.time.LocalDate;
import java.util.List;

public class UtilidadesFactura {


    /**
     *
     * public boolean esFacturaVencida(Factura factura).
     * Que devuelve true si la fecha de vencimiento de la factura que
     * se le pasa es mayor o igual que la fecha actual y false en caso
     * contrario.
     *
     */
    public boolean esFacturaVencida(Factura factura){

        // isAfter() --> >  es después
        // isBefore() --> < es antés
        // equals() --> == igual
        // fechaActual (LocalDate) --> LocalDate.now()
        return factura.getFechaVencimiento().isAfter(LocalDate.now()) || factura.getFechaVencimiento().equals(LocalDate.now());
        //Condicion ?  (Que hago si se cumple) : (Que hago si no se cumple);

    }

    /**
     *
     * b. public double calcularBaseFactura(Factura factura)
     * Que devuelve el importe base que debe tener la factura que se
     * le pasa. Para ello recorre todas las Linea Factura de la factura
     * que se le pasa y va acumulando en una variable, la suma del
     * importe del Producto de la LineaFactura multiplicada por la
     * cantidad de dicho producto, también indicada en la linea.
     *
     */
    public double calcularBaseFactura(Factura factura){

        double total = 0.0;

        //Recorrer la lineas  ( var in lista )
        for(LineaFactura lineaFactura : factura.getLineaFacturas()){

            //Obtengo el precio del producto
            double precioProducto = lineaFactura.getProducto().getPrecio();

            //Obtenemos la cantidad de la linea
            int cantidad = lineaFactura.getCantidad();

            //Le sumamos al total el precio * cantidad
            total += precioProducto * cantidad;

        }

        return total;

    }

    public double calcularBaseFacturaStream(Factura factura){

        return factura.getLineaFacturas()
                .stream()
                .mapToDouble(l-> l.getProducto().getPrecio() * l.getCantidad())
                .sum();
    }



    /**
     *
     * c. public double calcularTotalAPagar(Factura factura)
     * Que devuelve el totalAPagar que debe tener la factura que se
     * le pasa. Para ello hace la siguiente operación:
     * (importeBase - descuentos) * iva
     * Todos estos datos obtenidos de la factura que se le pasa.
     *
     */
    public double calcularTotalAPagar(Factura factura){

        //(importeBase - descuentos) * iva
        //También se puede hacer calcularBaseFactura(factura)

        return  (factura.getImporteBase() - factura.getDescuento()) * factura.getIva();


    }

    public Double gastoTotalCliente(List<Factura> facturas, Cliente cliente){

        Double importeTotal = 0.0;

        for(Factura factura: facturas){
            if(factura.getCliente().equals(cliente)){
                importeTotal += calcularTotalAPagar(factura);
            }
        }

        return importeTotal;
    }

    public Double gastoTotalClienteV2(List<Factura> facturas, Cliente cliente){

        return facturas
                .stream()
                .filter(f-> f.getCliente().equals(cliente))
                .mapToDouble(Factura::getTotalAPagar)
                .sum();
    }




}
