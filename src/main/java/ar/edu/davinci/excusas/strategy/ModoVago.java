package ar.edu.davinci.excusas.strategy;

import ar.edu.davinci.excusas.chain.Encargado;
import ar.edu.davinci.excusas.model.Excusa;

public class ModoVago implements ModoEvaluacion {
    @Override
    public void evaluar(Encargado encargado, Excusa excusa) {
        if (encargado.siguiente != null) {
            encargado.siguiente.manejarExcusa(excusa);
        }
    }
}
