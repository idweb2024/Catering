package ar.edu.unahur.obj2.catering.Menus;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.catering.Excepciones.DescuentoInvalidoException;
import ar.edu.unahur.obj2.catering.Propuestas.Propuesta;


public class Menu implements Propuesta {
    private String nombre;
    private Double descuento;

    private List<Propuesta> propuestas = new ArrayList<>();


    public Menu(String nombre, Double descuento) {
        if (descuento < 0 || descuento > 100) {
            throw new DescuentoInvalidoException("El descuento debe ser entre 0 y 100");
        }
        this.nombre = nombre;
        this.descuento = descuento;
    }

    public String getDescripcion() {
        return nombre;
    }

    public Double getPrecio() {
        Double dineroAcumulado = 0.0;
        for (Propuesta servicio : propuestas) {
            dineroAcumulado += servicio.getPrecio();
        }
        return dineroAcumulado - (dineroAcumulado * descuento) / 100;
    }

    public Boolean propuestaIncluye(String nombre) {
        return this.propuestas.stream().
        anyMatch(servicio -> servicio.propuestaIncluye(nombre));
    }

    public Double getDescuento() {
        return descuento;
    }
    
    public Integer getCantidadServicios() {
        Integer total = 0;
        for (Propuesta servicio : propuestas) {
            total += servicio.getCantidadServicios();
        }
        return total;
    }

    public void agregarPropuesta(Propuesta propuesta) {
        propuestas.add(propuesta);
    }

}
