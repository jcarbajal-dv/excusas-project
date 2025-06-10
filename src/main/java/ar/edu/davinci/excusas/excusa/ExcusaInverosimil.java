package ar.edu.davinci.excusas.excusa;

import ar.edu.davinci.excusas.empleado.interfaces.ManejadorExcusa;

public class ExcusaInverosimil extends TipoExcusa {

    @Override
    public boolean puedeSerManejadaPor(ManejadorExcusa manejadorExcusa) {
        return manejadorExcusa.soyCEO();
    }
}
