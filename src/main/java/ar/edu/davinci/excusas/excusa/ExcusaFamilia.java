package ar.edu.davinci.excusas.excusa;

import ar.edu.davinci.excusas.empleado.interfaces.ManejadorExcusa;


public class ExcusaFamilia extends ExcusaModerada {

    @Override
    public boolean puedeSerManejadaPor(ManejadorExcusa manejadorExcusa) {
        return manejadorExcusa.soySupervisorArea();
    }
}
