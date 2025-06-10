package ar.edu.davinci.excusas.excusa.interfaces;

import ar.edu.davinci.excusas.encargado.Empleado;
import ar.edu.davinci.excusas.encargado.Encargado;

public interface IExcusa {

    public Empleado getEmpleado();
    public String razon();
    public void evaluar(Encargado encargado);
    boolean puedeSerManejadaPor(Empleado empleado);

}
