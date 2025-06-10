package ar.edu.davinci.excusas.modoaccion;

import ar.edu.davinci.excusas.encargado.Encargado;
import ar.edu.davinci.excusas.excusa.Excusa;

public interface ModoAccion {
    void actuar(Encargado encargado, Excusa excusa);
}
