package ar.edu.unahur.obj2.catering.Modificaciones;

import ar.edu.unahur.obj2.catering.Menus.Menu;
import ar.edu.unahur.obj2.catering.Propuestas.Propuesta;

public class QuitarPropuesta implements ModificacionCommand {
    private Propuesta propuestaAQuitar;
    private Menu menu;

    public QuitarPropuesta(Propuesta propuestaAQuitar, Menu menu) {
        this.propuestaAQuitar = propuestaAQuitar;
        this.menu = menu;
    }


    public void aplicar() {
        menu.quitarPropuesta(propuestaAQuitar);
    }

 
    public void revertir() {
        menu.agregarPropuesta(propuestaAQuitar);
    }
}
