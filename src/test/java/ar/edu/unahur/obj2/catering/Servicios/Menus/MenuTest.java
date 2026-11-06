package ar.edu.unahur.obj2.catering.Servicios.Menus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.catering.Excepciones.DescuentoInvalidoException;
import ar.edu.unahur.obj2.catering.Menus.Menu;
import ar.edu.unahur.obj2.catering.Servicios.Servicio;

public class MenuTest {
    @Test 
    public void dadoUnMenuConDescuentoMayorACien_alCrearlo_lanzaDescuentoInvalidoException() {
        assertThrows(DescuentoInvalidoException.class, () -> new Menu("Menu", 101.0));
    }

    @Test 
    public void dadoUnMenuQueContieneOtrosMenus_alContarServicios_sumaLosDeTodosLosNiveles() {
        Servicio servicio1 = new Servicio("Servicio1", 1.0);
        Servicio servicio2 = new Servicio("Servicio2", 1.0);

        Menu menu1 = new Menu("Menu1", 0.0);
        Menu menu2 = new Menu("Menu2", 0.0);
        Menu menu3 = new Menu("Menu3", 0.0);

        menu2.agregarPropuesta(servicio1);
        menu3.agregarPropuesta(servicio2);

        menu1.agregarPropuesta(menu2);
        menu1.agregarPropuesta(menu3);
        assertEquals(2, menu1.getCantidadServicios());
    }

    @Test 
    public void dadoUnMenuParrillero_alConsultarSuPrecio_Devuelve342000() {
        Servicio mesaDeEntrada = new Servicio("Mesa de entradas", 80000.0);
        Servicio parrilladaCompleta = new Servicio("Parrillada completa", 240000.0);
        Servicio mesaDulce = new Servicio("Mesa dulce", 60000.0);

        Menu menuParrillero = new Menu("Menu Parrillero", 10.0);
        menuParrillero.agregarPropuesta(mesaDeEntrada);
        menuParrillero.agregarPropuesta(parrilladaCompleta);
        menuParrillero.agregarPropuesta(mesaDulce);
        assertEquals(342000.0, menuParrillero.getPrecio());
    }

    @Test 
    public void dadoUnMenuParrillero_alConsultarSusServicios_Devuelve3() {
        Servicio mesaDeEntrada = new Servicio("Mesa de entradas", 80000.0);
        Servicio parrilladaCompleta = new Servicio("Parrillada completa", 240000.0);
        Servicio mesaDulce = new Servicio("Mesa dulce", 60000.0);

        Menu menuParrillero = new Menu("Menu Parrillero", 0.0);
        menuParrillero.agregarPropuesta(mesaDeEntrada);
        menuParrillero.agregarPropuesta(parrilladaCompleta);
        menuParrillero.agregarPropuesta(mesaDulce);
        assertEquals(3, menuParrillero.getCantidadServicios());
    }

    public void dadoUnMenuParrillero_alConsultarParrilladaCompleta_DevuelveTrue() {
        Servicio mesaDeEntrada = new Servicio("Mesa de entradas", 80000.0);
        Servicio parrilladaCompleta = new Servicio("Parrillada completa", 240000.0);
        Servicio mesaDulce = new Servicio("Mesa dulce", 60000.0);

        Menu menuParrillero = new Menu("Menu Parrillero", 0.0);
        menuParrillero.agregarPropuesta(mesaDeEntrada);
        menuParrillero.agregarPropuesta(parrilladaCompleta);
        menuParrillero.agregarPropuesta(mesaDulce);
        assertEquals(true, menuParrillero.propuestaIncluye("Parrillada completa"));
    }

}

/*
| Consulta | Resultado |
|---|---|
| Precio de *Menú Parrillero* | $342.000 |
| Precio de *Pack Fiesta* | $256.500 |
| Cantidad de servicios de *Menú Parrillero* | 3 |
| *Menú Parrillero* incluye *Parrillada completa* | sí |
| *Menú Parrillero* incluye *DJ y sonido* | no |

*/
/*
| 1 | Precio con descuento · cantidad de servicios · inclusión · precio negativo · 
descuento inválido · precio, cantidad e inclusión con menús anidados |
*/

/*
| Nombre | Precio |
|---|---|
| Mesa de entradas | $80.000 |
| Parrillada completa | $240.000 |
| Mesa dulce | $60.000 |
| Barra de tragos | $150.000 |
| DJ y sonido | $120.000 |
| Brindis de bienvenida | $50.000 |

**Menús**

| Menú | Descuento | Contiene |
|---|---|---|
| Menú Parrillero | 10 % | Mesa de entradas, Parrillada completa, Mesa dulce |
| Pack Fiesta | 5 % | Barra de tragos, DJ y sonido |
| Evento Completo | 20 % | Menú Parrillero, Pack Fiesta, Brindis de bienvenida |




Servicio barraDeTragos = new Servicio("Barra de tragos", 150000.0);
Servicio djYSonido = new Servicio("DJ y sonido", 120000.0);
Servicio brindisDeBienvenida = new Servicio("Brindis de bienvenida", 50000.0);

*/