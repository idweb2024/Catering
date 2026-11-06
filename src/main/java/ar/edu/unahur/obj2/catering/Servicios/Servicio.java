package ar.edu.unahur.obj2.catering.Servicios;

import ar.edu.unahur.obj2.catering.Excepciones.PrecioNegativoException;
import ar.edu.unahur.obj2.catering.Propuestas.Propuesta;

public class Servicio implements Propuesta {
    private String nombre;
    private Double precio;

    public Servicio(String nombre, Double precio) {
        if (precio < 0) {
            throw new PrecioNegativoException("El precio no puede ser negativo");
        }
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getDescripcion() {
        return nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public Integer getCantidadServicios() {
        return 1;
    }

    public Boolean propuestaIncluye(String nombre) {
        return nombre.equals(this.nombre);
    }

    public void setTarifa(Double tarifa) {
        this.precio = tarifa;
    }
}
