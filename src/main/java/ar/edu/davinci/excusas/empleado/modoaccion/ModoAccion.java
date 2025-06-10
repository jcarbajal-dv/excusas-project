package ar.edu.davinci.excusas.empleado.modoaccion;

import ar.edu.davinci.excusas.empleado.Encargado;
import ar.edu.davinci.excusas.excusa.Excusa;

public interface ModoAccion {
    void actuar(Encargado encargado, Excusa excusa);
}
