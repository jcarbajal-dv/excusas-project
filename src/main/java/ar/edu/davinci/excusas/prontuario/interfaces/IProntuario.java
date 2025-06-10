package ar.edu.davinci.excusas.prontuario.interfaces;


import ar.edu.davinci.excusas.encargado.Empleado;
import ar.edu.davinci.excusas.encargado.Encargado;
import ar.edu.davinci.excusas.excusa.Excusa;

public interface IProntuario {

    public Empleado getEmpleado();
    public Encargado getEncargado();
    public Excusa getExcusa();

}
