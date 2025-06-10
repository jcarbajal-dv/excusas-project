package ar.edu.davinci.excusas.strategy;

import ar.edu.davinci.excusas.encargado.Encargado;
import ar.edu.davinci.excusas.excusa.Excusa;

public interface ModoAccion {
    void actuar(Encargado encargado, Excusa excusa);
}
