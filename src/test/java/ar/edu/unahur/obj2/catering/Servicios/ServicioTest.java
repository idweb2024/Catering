package ar.edu.unahur.obj2.catering.Servicios;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.catering.Excepciones.PrecioNegativoException;

public class ServicioTest {
    @Test 
    public void dadoUnServicioConPrecioNegativo_alCrearlo_lanzaPrecioNegativoException() {
        assertThrows(PrecioNegativoException.class, () -> new Servicio("Servicio", -1.0));
    }

    @Test 
    public void dadoUnServicioConNombreServicio_AlConsultarDescripcion_retornaElNombreDelServicio() {
        Servicio servicio = new Servicio("Servicio", 1.0);
        assert servicio.getDescripcion().equals("Servicio");
    }

    @Test 
    public void dadoUnServicioConPrecio_AlConsultarPrecio_retornaElPrecioDelServicio() {
        Servicio servicio = new Servicio("Servicio", 1.0);
        assert servicio.getPrecio().equals(1.0);
    }

    @Test
    public void dadoUnServicio_AlConsultarCantidadDeServicios_retorna1() {
        Servicio servicio = new Servicio("Servicio", 1.0);
        assertEquals(1, servicio.getCantidadServicios());
      
    }
}

