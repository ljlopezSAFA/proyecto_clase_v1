package modelos;

import java.util.Objects;

public class Empleado extends Persona {

    private String numTelefeno;
    private Empresa empresa;
    private Contrato contrato;

    public Empleado(Integer identificador, String dni, String nombre, String apellidos, String direccion, String numTelefeno, Empresa empresa, Contrato contrato) {
        super(identificador, dni, nombre, apellidos, direccion);
        this.numTelefeno = numTelefeno;
        this.empresa = empresa;
        this.contrato = contrato;
    }

    public Empleado(String numTelefeno, Empresa empresa, Contrato contrato) {
        this.numTelefeno = numTelefeno;
        this.empresa = empresa;
        this.contrato = contrato;
    }

    public Empleado(){

    }

    public Empleado(Empresa empresa){
        this.empresa = empresa;
    }

    public String getNumTelefeno() {
        return numTelefeno;
    }

    public void setNumTelefeno(String numTelefeno) {
        this.numTelefeno = numTelefeno;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Empleado empleado = (Empleado) o;
        return Objects.equals(numTelefeno, empleado.numTelefeno) && Objects.equals(empresa, empleado.empresa) && Objects.equals(contrato, empleado.contrato);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numTelefeno, empresa, contrato);
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "numTelefeno='" + numTelefeno + '\'' +
                ", contrato=" + contrato +
                '}';
    }
}
