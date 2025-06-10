package ar.edu.davinci.excusas.excusa;

import ar.edu.davinci.excusas.empleado.interfaces.ManejadorExcusa;

public abstract class ExcusaModerada extends TipoExcusa {

    @Override
    public boolean puedeSerManejadaPor(ManejadorExcusa manejadorExcusa) {
        return manejadorExcusa.soySupervisorArea();
    }
}
