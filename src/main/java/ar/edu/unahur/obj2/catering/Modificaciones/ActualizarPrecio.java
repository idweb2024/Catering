package ar.edu.unahur.obj2.catering.Modificaciones;

import ar.edu.unahur.obj2.catering.Servicios.Servicio;

public class ActualizarPrecio implements ModificacionCommand {
    private Double nuevoPrecio;
    private Servicio servicio;
    private Double precioAnterior;

    public ActualizarPrecio(Double nuevoPrecio, Servicio servicio) {
        this.nuevoPrecio = nuevoPrecio;
        this.servicio = servicio;
    }

    public void revertir() {
        servicio.setTarifa(precioAnterior);
    }

    @Override
    public void aplicar() {
        precioAnterior = servicio.getPrecio();
        servicio.setTarifa(nuevoPrecio);
    }

   
}   
