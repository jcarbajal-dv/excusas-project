package ar.edu.davinci.excusas.chain;

import ar.edu.davinci.excusas.model.Excusa;
import ar.edu.davinci.excusas.model.MotivoExcusa;
import ar.edu.davinci.excusas.observer.AdministradorDeProntuarios;
import ar.edu.davinci.excusas.model.Prontuario;
import ar.edu.davinci.excusas.observer.ObservadorCEO;
import ar.edu.davinci.excusas.service.EmailSender;
import ar.edu.davinci.excusas.strategy.ModoEvaluacion;

public class CEO extends Encargado implements ObservadorCEO {

    public CEO(String nombre, String email, int legajo, ModoEvaluacion modo, EmailSender emailSender) {
        super(nombre, email, legajo, modo, emailSender);
        AdministradorDeProntuarios.getInstance().registrarObservador(this);
    }

    @Override
    public boolean puedeManejar(MotivoExcusa motivo) {
        return motivo == MotivoExcusa.INVEROSIMIL;
    }


    @Override
    public void procesar(Excusa excusa) {
        emailSender.enviarEmail(
                excusa.getEmpleado().getEmail(),
                this.getEmail(),
                "Aprobado por creatividad",
                "Excusa aceptada por originalidad."
        );

        Prontuario prontuario = new Prontuario(excusa.getEmpleado(), excusa.getMotivo(), excusa.getEmpleado().getLegajo());
        AdministradorDeProntuarios.getInstance().agregarProntuario(prontuario);
    }

    @Override
    public void notificar(Prontuario prontuario) {
        emailSender.enviarEmail(
                this.getEmail(),
                "admin@excusas.sa",
                "Nuevo prontuario registrado",
                "Se ha registrado un nuevo prontuario: " + prontuario.toString()
        );
    }
}
