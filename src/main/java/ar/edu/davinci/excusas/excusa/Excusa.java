package ar.edu.davinci.excusas.excusa;

import ar.edu.davinci.excusas.encargado.Empleado;
import ar.edu.davinci.excusas.encargado.interfaces.ManejadorExcusa;

public class Excusa {

    private Empleado empleado;
    private String razon;
    private TipoExcusa tipoExcusa;

    public Excusa(Empleado empleado, String razon, TipoExcusa tipoExcusa) {
        this.empleado = empleado;
        this.tipoExcusa = tipoExcusa;
    }

    public Empleado getEmpleado() {
        return this.empleado;
    }

    public String getRazon() {
        return this.razon;
    }

    public TipoExcusa getTipoExcusa() {
        return this.tipoExcusa;
    }

    public boolean puedeSerManejadaPor(ManejadorExcusa manejadorExcusa) {
        return this.tipoExcusa.puedeSerManejadaPor(manejadorExcusa);
    }

}