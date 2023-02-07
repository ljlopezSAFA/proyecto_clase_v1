package modelos;

import java.util.*;

public class Empresa {

    private int identificador;
    private String codigoEmpresa;
    private List<Empleado> empleados;
    private TipoEmpresa tipoEmpresa;

    public Empresa(int identificador, String codigoEmpresa, List<Empleado> empleados, TipoEmpresa tipoEmpresa) {
        this.identificador = identificador;
        this.codigoEmpresa = codigoEmpresa;
        this.empleados = empleados;
        this.tipoEmpresa = tipoEmpresa;
    }

    public Empresa() {
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getCodigoEmpresa() {
        return codigoEmpresa;
    }

    public void setCodigoEmpresa(String codigoEmpresa) {
        this.codigoEmpresa = codigoEmpresa;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public TipoEmpresa getTipoEmpresa() {
        return tipoEmpresa;
    }

    public void setTipoEmpresa(TipoEmpresa tipoEmpresa) {
        this.tipoEmpresa = tipoEmpresa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empresa empresa = (Empresa) o;
        return identificador == empresa.identificador && Objects.equals(codigoEmpresa, empresa.codigoEmpresa) && Objects.equals(empleados, empresa.empleados) && tipoEmpresa == empresa.tipoEmpresa;
    }

    @Override
    public int hashCode() {
        return Objects.hash(identificador, codigoEmpresa, empleados, tipoEmpresa);
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "identificador=" + identificador +
                ", codigoEmpresa='" + codigoEmpresa + '\'' +
                ", empleados=" + empleados +
                ", tipoEmpresa=" + tipoEmpresa +
                '}';
    }
}
