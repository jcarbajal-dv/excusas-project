package ar.edu.davinci.excusas.model;

import ar.edu.davinci.excusas.model.Empleado;
import ar.edu.davinci.excusas.model.MotivoExcusa;

public class Excusa{
    private Empleado empleado;
    private MotivoExcusa motivo;

    public Excusa(Empleado empleado, MotivoExcusa motivo) {
        this.empleado = empleado;
        this.motivo = motivo;
    }

    public Empleado getEmpleado() { return empleado; }
    public MotivoExcusa getMotivo() { return motivo; }
}
