package ar.edu.davinci.excusas.excusa.interfaces;

import ar.edu.davinci.excusas.empleado.Empleado;
import ar.edu.davinci.excusas.empleado.Encargado;

public interface IExcusa {

    public Empleado getEmpleado();
    public String razon();
    public void evaluar(Encargado encargado);
    boolean puedeSerManejadaPor(Empleado empleado);

}
