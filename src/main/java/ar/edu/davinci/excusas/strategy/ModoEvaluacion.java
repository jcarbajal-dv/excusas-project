package ar.edu.davinci.excusas.strategy;

import ar.edu.davinci.excusas.chain.Encargado;
import ar.edu.davinci.excusas.model.Excusa;

public interface ModoEvaluacion {
    void evaluar(Encargado encargado, Excusa excusa);
}
