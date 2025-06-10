package ar.edu.davinci.excusas.excusa;

import ar.edu.davinci.excusas.empleado.interfaces.ManejadorExcusa;

public class ExcusaCompleja extends TipoExcusa {

    @Override
    public boolean puedeSerManejadaPor(ManejadorExcusa manejadorExcusa) {
        return manejadorExcusa.soyGerenteRRHH();
    }
}
