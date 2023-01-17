package modelos;

import java.util.Objects;

public class Cliente {

    private Integer identificador;
    private  String dni;
    private String nombre;
    private String apellidos;
    private String direccion;
    private TipoCliente tipoCliente;


    public Cliente(Integer identificador, String dni, String nombre, String apellidos, String direccion, TipoCliente tipoCliente) {
        this.identificador = identificador;
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.tipoCliente = tipoCliente;
    }

    public Cliente() {
    }

    public Integer getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Integer identificador) {
        this.identificador = identificador;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(identificador, cliente.identificador) && Objects.equals(dni, cliente.dni) && Objects.equals(nombre, cliente.nombre) && Objects.equals(apellidos, cliente.apellidos) && Objects.equals(direccion, cliente.direccion) && tipoCliente == cliente.tipoCliente;
    }

    @Override
    public int hashCode() {
        return Objects.hash(identificador, dni, nombre, apellidos, direccion, tipoCliente);
    }

    @Override
    public String
    toString() {
        return "Cliente{" +
                "identificador=" + identificador +
                ", dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", direccion='" + direccion + '\'' +
                ", tipoCliente=" + tipoCliente +
                '}';
    }
}
