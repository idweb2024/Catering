package ar.edu.unahur.obj2.catering.Adicionales;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.catering.Menus.Menu;
import ar.edu.unahur.obj2.catering.Propuestas.Propuesta;
import ar.edu.unahur.obj2.catering.Servicios.Servicio;

public class AdicionalesTest {
    @Test
    public void dadoUnServicioNocturnoAplicadoAntesQueMozos_alCalcularPrecio_elOrdenAlteraElPrecioFinal() {
        Servicio mesaDeEntrada = new Servicio("Mesa de entradas", 80000.0);
        Servicio parrilladaCompleta = new Servicio("Parrillada completa", 240000.0);
        Servicio mesaDulce = new Servicio("Mesa dulce", 60000.0);

        Menu menuParrillero = new Menu("Menu Parrillero", 10.0);
        menuParrillero.agregarPropuesta(mesaDeEntrada);
        menuParrillero.agregarPropuesta(parrilladaCompleta);
        menuParrillero.agregarPropuesta(mesaDulce);

        Propuesta conMozos = new MozosAdicionales(menuParrillero);
        Propuesta conMozosYNocturno = new ServicioNocturno(conMozos);

        
        assertEquals(432000.0, conMozosYNocturno.getPrecio());
        assertEquals("Menu Parrillero + Mozos adicionales + Servicio nocturno", conMozosYNocturno.getDescripcion());

    }

    @Test
    public void dadoUnServicioNocturnoAplicadoAntesQueMozos_alCalcularPrecio_elOrdenAlteraElPrecioFinalIntercambiandoLugares() {

        Servicio mesaDeEntrada = new Servicio("Mesa de entradas", 80000.0);
        Servicio parrilladaCompleta = new Servicio("Parrillada completa", 240000.0);
        Servicio mesaDulce = new Servicio("Mesa dulce", 60000.0);

        Menu menuParrillero = new Menu("Menu Parrillero", 10.0);
        menuParrillero.agregarPropuesta(mesaDeEntrada);
        menuParrillero.agregarPropuesta(parrilladaCompleta);
        menuParrillero.agregarPropuesta(mesaDulce);

        Propuesta nocturno = new ServicioNocturno(menuParrillero);
        Propuesta conMozosYNocturno = new MozosAdicionales(nocturno);
        

        
        assertEquals(428400.0, conMozosYNocturno.getPrecio());
        assertEquals("Menu Parrillero + Servicio nocturno + Mozos adicionales", conMozosYNocturno.getDescripcion());

    }

}


/*
**Resultados esperados**
        Servicio mesaDeEntrada = new Servicio("Mesa de entradas", 80000.0);
        Servicio parrilladaCompleta = new Servicio("Parrillada completa", 240000.0);
        Servicio mesaDulce = new Servicio("Mesa dulce", 60000.0);

        Menu menuParrillero = new Menu("Menu Parrillero", 0.0);
        menuParrillero.agregarPropuesta(mesaDeEntrada);
        menuParrillero.agregarPropuesta(parrilladaCompleta);
        menuParrillero.agregarPropuesta(mesaDulce);


| Propuesta | Precio | Descripción |
|---|---|---|
| *Menú Parrillero* + Mozos adicionales + Servicio nocturno | $432.000 | `Menú Parrillero + Mozos adicionales + Servicio nocturno` |
| *Menú Parrillero* + Servicio nocturno + Mozos adicionales | $428.400 | `Menú Parrillero + Servicio nocturno + Mozos adicionales` |
| *Brindis de bienvenida* + Vajilla premium + Vajilla premium | $74.000 | `Brindis de bienvenida + Vajilla premium + Vajilla premium` |
| *Mesa dulce* + Servicio nocturno + Servicio nocturno | $86.400 | `Mesa dulce + Servicio nocturno + Servicio nocturno` |
| *Evento Completo* + Vajilla premium | $530.800 | `Evento Completo + Vajilla premium` |

*/