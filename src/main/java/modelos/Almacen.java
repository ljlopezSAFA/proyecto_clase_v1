package modelos;

import java.util.Objects;

public class Almacen {

    //Atributos
    private int identificador;
    private String nombre;
    private int capacidad;

    //Constructores
    public Almacen(){
    }

    public Almacen(int identificador, String nombre, int capacidad){
        this.identificador = identificador;
        this.nombre = nombre;
        this.capacidad = capacidad;

    }

    //Getters y Setters
    public int getIdentificador(){
        return this.identificador;
    }

    public void setIdentificador(int identificador){
        this.identificador = identificador;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Almacen almacen = (Almacen) o;
        return identificador == almacen.identificador && capacidad == almacen.capacidad && Objects.equals(nombre, almacen.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identificador, nombre, capacidad);
    }

    @Override
    public String toString() {
        return "Almacen{" +
                "identificador=" + identificador +
                ", nombre='" + nombre + '\'' +
                ", capacidad=" + capacidad +
                '}';
    }
}
