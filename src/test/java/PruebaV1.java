import modelos.*;

import java.time.LocalDate;

public class PruebaV1 {

    public static void main(String[] args) {

        Almacen almacen1 = new Almacen();
        almacen1.setNombre("Almacen Conservas");
        almacen1.setCapacidad(500);
        almacen1.setIdentificador(1000);

        Producto producto1 = new Producto(1, "P001", "Tomate en conserva", LocalDate.now(),
                TipoProducto.ALIMENTACION, almacen1);

        Cliente cliente1 = new Cliente();
        cliente1.setNombre("Pepe");
        cliente1.setApellidos("Viyuela");
        cliente1.setDireccion("Calle Calatrava");
        cliente1.setDni("12345678Y");
        cliente1.setTipoCliente(TipoCliente.PARTICULAR);
        cliente1.setIdentificador(110);


        System.out.println(almacen1);
        System.out.println(producto1);
        System.out.println(cliente1);


    }


}
