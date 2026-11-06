package ar.edu.unahur.obj2.catering.Adicionales;

import ar.edu.unahur.obj2.catering.Propuestas.Propuesta;

public class ServicioNocturno extends AdicionalDecorator {
    public ServicioNocturno(Propuesta propuesta) {
        super(propuesta);
    }
    
    @Override 
    public Double getPrecio() {
        return propuesta.getPrecio() * 1.20;
    }
    
    @Override 
    public String getDescripcion() {
        return propuesta.getDescripcion() + " + Servicio nocturno";
    }
}
