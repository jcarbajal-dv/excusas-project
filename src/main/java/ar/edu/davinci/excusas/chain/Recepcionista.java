package ar.edu.davinci.excusas.chain;

import ar.edu.davinci.excusas.model.Excusa;
import ar.edu.davinci.excusas.model.MotivoExcusa;
import ar.edu.davinci.excusas.service.EmailSender;
import ar.edu.davinci.excusas.strategy.ModoEvaluacion;

public class Recepcionista extends EncargadoBase {

    public Recepcionista(String nombre, String email, int legajo, ModoEvaluacion modo, EmailSender emailSender) {
        super(nombre, email, legajo, modo, emailSender);
    }


    @Override
    public boolean puedeManejar(MotivoExcusa motivo) {
        return motivo == MotivoExcusa.QUEDARSE_DORMIDO || motivo == MotivoExcusa.PERDI_EL_TRANSPORTE;
    }

    @Override
    public void procesar(Excusa excusa) {
        emailSender.enviarEmail(
                excusa.getEmpleado().getEmail(),
                this.getEmail(),
                "Excusa aceptada",
                "La excusa fue aceptada por el Recepcionista."
        );
    }
}