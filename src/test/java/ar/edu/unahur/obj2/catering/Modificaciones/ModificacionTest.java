package ar.edu.unahur.obj2.catering.Modificaciones;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.catering.Menus.Menu;
import ar.edu.unahur.obj2.catering.Servicios.Servicio;

public class ModificacionTest {
    @Test 
    public void dadaUnaActualizacionDePrecio_AlAplicarlaYRevertirla_vuelveAlPrecioAnterior() {
        Servicio parrillada = new Servicio("Parrillada completa", 240000.0);
        ActualizarPrecio actualizarPrecio = new ActualizarPrecio(300000.0, parrillada);
        actualizarPrecio.aplicar();
        actualizarPrecio.revertir();
        assertEquals(240000.0, parrillada.getPrecio());
    }

    @Test
    public void dadoUnAgregadoDePropuesta_AlAplicarloYrevertir_quitaLoAgregado() {
        Menu menu = new Menu("Menu Parrillero", 0.0);
        Servicio parrillada = new Servicio("Parrillada completa", 240000.0);
        AgregarPropuesta agregarPropuesta = new AgregarPropuesta(parrillada, menu);
        agregarPropuesta.aplicar();
        assertTrue(menu.propuestaIncluye("Parrillada completa"));
        agregarPropuesta.revertir();
        assertFalse(menu.propuestaIncluye("Parrillada completa"));
        
    }
}
