package ar.edu.davinci.excusas.strategy;

import ar.edu.davinci.excusas.chain.Encargado;
import ar.edu.davinci.excusas.model.Excusa;

public class ModoNormal implements ModoEvaluacion {
    @Override
    public void evaluar(Encargado encargado, Excusa excusa) {
       encargado.manejarExcusa(excusa);
    }
}
