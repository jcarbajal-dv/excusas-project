package ar.edu.davinci.excusas.chain;

import ar.edu.davinci.excusas.model.Excusa;
import ar.edu.davinci.excusas.model.MotivoExcusa;
import ar.edu.davinci.excusas.service.EmailSender;
import ar.edu.davinci.excusas.strategy.ModoNormal;

public class EncargadoPorDefecto extends Encargado {

    public EncargadoPorDefecto(String nombre, String email, int legajo, EmailSender emailSender) {
        super(nombre, email, legajo, new ModoNormal(), emailSender); // modo no relevante
    }

    @Override
    public boolean puedeManejar(MotivoExcusa motivo) {
        return true;
    }

    @Override
    public void procesar(Excusa excusa) {
        emailSender.enviarEmail(
                excusa.getEmpleado().getEmail(),
                this.getEmail(),
                "Excusa rechazada",
                "Excusa rechazada: necesitamos pruebas contundentes."
        );
    }
}
