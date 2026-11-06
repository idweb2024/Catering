package ar.edu.unahur.obj2.catering.Contratos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.catering.Adicionales.MozosAdicionales;
import ar.edu.unahur.obj2.catering.Menus.Menu;
import ar.edu.unahur.obj2.catering.Propuestas.Propuesta;
import ar.edu.unahur.obj2.catering.Servicios.Servicio;

public class ContratoTest {
    @Test 
    public void dadoUnContratoCreado_alActualizarElPrecioDeUnServicio_elImporteContratadoNoCambia() {
        Servicio mesaDeEntrada = new Servicio("Mesa de entradas", 80000.0);
        Servicio parrilladaCompleta = new Servicio("Parrillada completa", 240000.0);
        Servicio mesaDulce = new Servicio("Mesa dulce", 60000.0);

        Menu menuParrillero = new Menu("Menu Parrillero", 10.0);
        menuParrillero.agregarPropuesta(mesaDeEntrada);
        menuParrillero.agregarPropuesta(parrilladaCompleta);
        menuParrillero.agregarPropuesta(mesaDulce);

        Propuesta conMozos = new MozosAdicionales(menuParrillero);

        Contrato contrato = new Contrato("Lucía", conMozos);
        assertEquals(360000.0, contrato.getImporte());
        mesaDeEntrada.setTarifa(90000.0);
        assertEquals(360000.0, contrato.getImporte());

    }
}
