package ar.edu.unahur.obj2.catering.Modificaciones;

import ar.edu.unahur.obj2.catering.Menus.Menu;
import ar.edu.unahur.obj2.catering.Propuestas.Propuesta;

public class AgregarPropuesta implements ModificacionCommand {
    private Propuesta nuevaPropuesta;
    private Menu menu;
    
    public AgregarPropuesta(Propuesta nuevaPropuesta, Menu menu) {
        this.nuevaPropuesta = nuevaPropuesta;
        this.menu = menu;
    }

    public void aplicar() {
        menu.agregarPropuesta(nuevaPropuesta);
    }

    public void revertir() {
        menu.quitarPropuesta(nuevaPropuesta);
    }
}
