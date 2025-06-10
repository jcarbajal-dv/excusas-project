package ar.edu.davinci.excusas.excusa;

import ar.edu.davinci.excusas.encargado.interfaces.ManejadorExcusa;


public class ExcusaFamilia extends TipoExcusa {

    @Override
    public boolean puedeSerManejadaPor(ManejadorExcusa manejadorExcusa) {
        return manejadorExcusa.soySupervisorArea();
    }
}
