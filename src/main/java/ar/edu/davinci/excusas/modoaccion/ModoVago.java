package ar.edu.davinci.excusas.modoaccion;

import ar.edu.davinci.excusas.encargado.Encargado;
import ar.edu.davinci.excusas.excusa.Excusa;

public class ModoVago implements ModoAccion {
    @Override
    public void actuar(Encargado encargado, Excusa excusa) {
        encargado.pasarExcusa(excusa);
        }
    }

