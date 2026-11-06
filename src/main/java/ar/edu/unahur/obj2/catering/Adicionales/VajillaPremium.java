package ar.edu.unahur.obj2.catering.Adicionales;

import ar.edu.unahur.obj2.catering.Propuestas.Propuesta;

public class VajillaPremium extends AdicionalDecorator {

    public VajillaPremium(Propuesta propuesta) {
        super(propuesta);
    }

    @Override
    public Double getPrecio() {
        return propuesta.getPrecio() + 12000.0;
    }

    @Override
    public String getDescripcion() {
        return propuesta.getDescripcion() + " + Vajilla premium";
    }

}
