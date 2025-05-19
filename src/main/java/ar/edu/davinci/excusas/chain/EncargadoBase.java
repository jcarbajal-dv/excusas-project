package ar.edu.davinci.excusas.chain;

import ar.edu.davinci.excusas.model.Excusa;
import ar.edu.davinci.excusas.model.MotivoExcusa;
import ar.edu.davinci.excusas.strategy.ModoEvaluacion;
import ar.edu.davinci.excusas.service.EmailSender;

public abstract class EncargadoBase extends Encargado {

    public EncargadoBase(String nombre, String email, int legajo, ModoEvaluacion modo, EmailSender emailSender) {
        super(nombre, email, legajo, modo, emailSender);
    }

    @Override
    public void manejarExcusa(Excusa excusa) {
        if (puedeManejar(excusa.getMotivo())) {
            procesar(excusa);
        } else if (siguiente != null) {
            siguiente.manejarExcusa(excusa);
        }
    }

    public abstract boolean puedeManejar(MotivoExcusa motivo);
    public abstract void procesar(Excusa excusa);
}