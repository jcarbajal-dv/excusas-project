package ar.edu.davinci.excusas.empleado.modoaccion;

import ar.edu.davinci.excusas.empleado.Encargado;
import ar.edu.davinci.excusas.excusa.Excusa;

public class ModoNormal implements ModoAccion {
    @Override
    public void actuar(Encargado encargado, Excusa excusa) {
       encargado.manejarExcusa(excusa);
    }
}
