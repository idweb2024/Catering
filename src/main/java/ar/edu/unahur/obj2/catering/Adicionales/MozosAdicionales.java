package ar.edu.unahur.obj2.catering.Adicionales;

import ar.edu.unahur.obj2.catering.Propuestas.Propuesta;

public class MozosAdicionales extends AdicionalDecorator {
    public MozosAdicionales(Propuesta propuesta) {
        super(propuesta);
    }

    @Override
    public Double getPrecio() {
        return propuesta.getPrecio() + 18000.0;
    }

    @Override
    public String getDescripcion() {
        return propuesta.getDescripcion() + " + Mozos adicionales";
    }


}
