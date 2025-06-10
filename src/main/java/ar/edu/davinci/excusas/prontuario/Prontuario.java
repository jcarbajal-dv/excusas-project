package ar.edu.davinci.excusas.prontuario;

import ar.edu.davinci.excusas.encargado.Empleado;
import ar.edu.davinci.excusas.encargado.Encargado;
import ar.edu.davinci.excusas.excusa.Excusa;
import ar.edu.davinci.excusas.prontuario.interfaces.IProntuario;

public class Prontuario implements IProntuario {
    private Empleado empleado;
    private Encargado encargado;
    private Excusa excusa;

    public Prontuario(Empleado empleado, Encargado encargado, Excusa excusa) {
        this.empleado = empleado;
        this.encargado = encargado;
        this.excusa = excusa;
    }

    @Override
    public Empleado getEmpleado() {
        return empleado;
    }

    @Override
    public Encargado getEncargado() {
        return this.encargado;
    }

    @Override
    public Excusa getExcusa() {
        return this.excusa;
    }
}
