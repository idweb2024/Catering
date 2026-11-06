package ar.edu.unahur.obj2.catering.Contratos;

import ar.edu.unahur.obj2.catering.Propuestas.Propuesta;

public class Contrato {
    private String cliente;
    private Double importe;
    private String propuestaContratada;

    public Contrato(String cliente, Propuesta propuesta) {
        this.cliente = cliente;
        this.importe = propuesta.getPrecio();
        this.propuestaContratada = propuesta.getDescripcion();           
    }

    public String getPropuestaContratada() {
        return propuestaContratada;
    }

    public String getCliente() {
        return cliente;
    }

    public Double getImporte() {
        return importe;
    }
}
