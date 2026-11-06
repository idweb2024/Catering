package ar.edu.unahur.obj2.catering.Adicionales;

import ar.edu.unahur.obj2.catering.Propuestas.Propuesta;

public abstract class AdicionalDecorator implements Propuesta {
    protected Propuesta propuesta;

    public AdicionalDecorator(Propuesta propuesta) {
        this.propuesta = propuesta;
    }

    public Propuesta getPropuesta() {
        return propuesta;
    }

    public Integer getCantidadServicios() {
        return propuesta.getCantidadServicios();
    }

    public Boolean propuestaIncluye(String nombre) {
        return propuesta.propuestaIncluye(nombre);
    }

}

/*
Los clientes pueden contratar **adicionales** sobre cualquier propuesta (servicio suelto o menú completo).

| Adicional | Efecto sobre el precio | Efecto sobre la descripción |
|---|---|---|
| Mozos adicionales | + $18.000 | agrega « + Mozos adicionales» |
| Vajilla premium | + $12.000 | agrega « + Vajilla premium» |
| Servicio nocturno | + 20 % del precio acumulado hasta ese momento | agrega « + Servicio nocturno» |

*/