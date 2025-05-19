package ar.edu.davinci.excusas.chain;

import ar.edu.davinci.excusas.model.Excusa;
import ar.edu.davinci.excusas.model.MotivoExcusa;
import ar.edu.davinci.excusas.service.EmailSender;
import ar.edu.davinci.excusas.strategy.ModoEvaluacion;

public class SupervisorArea extends Encargado {


    public SupervisorArea(String nombre, String email, int legajo, ModoEvaluacion modo, EmailSender emailSender) {
        super(nombre, email, legajo, modo, emailSender);
    }

    @Override
    public boolean puedeManejar(MotivoExcusa motivo) {
        return motivo == MotivoExcusa.CORTE_LUZ || motivo == MotivoExcusa.CUIDADO_FAMILIAR;
    }


    @Override
    public void procesar(Excusa excusa) {
        if (excusa.getMotivo() == MotivoExcusa.CORTE_LUZ) {
            emailSender.enviarEmail("EDESUR@mailfake.com.ar", this.getEmail(),
                    "Consulta corte de luz", "¿Hubo un corte de luz en el barrio?");
        } else if (excusa.getMotivo() == MotivoExcusa.CUIDADO_FAMILIAR) {
            emailSender.enviarEmail(excusa.getEmpleado().getEmail(), this.getEmail(),
                    "Situación familiar", "¿Está todo bien?");
        }
    }
}