package modelos;

import java.util.Objects;

public class Contrato {

    private int identificador;
    private Double salarioBase;
    private TipoContrato tipoContrato;

    public Contrato(int identificador, Double salarioBase, TipoContrato tipoContrato) {
        this.identificador = identificador;
        this.salarioBase = salarioBase;
        this.tipoContrato = tipoContrato;
    }

    public Contrato() {
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public Double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(Double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public TipoContrato getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(TipoContrato tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contrato contrato = (Contrato) o;
        return identificador == contrato.identificador && Objects.equals(salarioBase, contrato.salarioBase) && tipoContrato == contrato.tipoContrato;
    }

    @Override
    public int hashCode() {
        return Objects.hash(identificador, salarioBase, tipoContrato);
    }

    @Override
    public String toString() {
        return "Contrato{" +
                "identificador=" + identificador +
                ", salarioBase=" + salarioBase +
                ", tipoContrato=" + tipoContrato +
                '}';
    }
}
