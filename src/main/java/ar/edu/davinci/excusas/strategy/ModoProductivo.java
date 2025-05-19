package ar.edu.davinci.excusas.strategy;

import ar.edu.davinci.excusas.chain.Encargado;
import ar.edu.davinci.excusas.model.Excusa;

public class ModoProductivo implements ModoEvaluacion {
    @Override
    public void evaluar(Encargado encargado, Excusa excusa) {
        // Siempre avisa al CTO
        encargado.emailSender.enviarEmail(
                "cto@excusas.sa",
                encargado.getEmail(),
                "Evaluación Productiva",
                "Se evaluará una excusa: " + excusa.getMotivo()
        );

        if (encargado.puedeManejar(excusa.getMotivo())) {
            encargado.procesar(excusa);
        } else if (encargado.siguiente != null) {
            encargado.siguiente.manejarExcusa(excusa);
        }
    }
}
