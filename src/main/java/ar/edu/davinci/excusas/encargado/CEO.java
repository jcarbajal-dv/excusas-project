package ar.edu.davinci.excusas.encargado;

import ar.edu.davinci.excusas.encargado.interfaces.ManejadorExcusa;
import ar.edu.davinci.excusas.excusa.Excusa;
import ar.edu.davinci.excusas.prontuario.AdministradorDeProntuarios;
import ar.edu.davinci.excusas.prontuario.Prontuario;
import ar.edu.davinci.excusas.prontuario.interfaces.ObservadorCEO;

public class CEO extends Encargado implements ObservadorCEO {

    public CEO(String nombre, String email, int legajo, ManejadorExcusa siguiente) {
        super(nombre, email, legajo);
        this.siguiente = siguiente;
        AdministradorDeProntuarios.getInstance().registrarObservador(this);
    }


    @Override
    public void procesarExcusa(Excusa excusa) {
        new EmailSender().enviarEmail(
                excusa.getEmpleado().getEmail(),
                this.getEmail(),
                "Aprobado por creatividad",
                "Excusa aceptada por originalidad."
        );

        Prontuario prontuario = new Prontuario(excusa.getEmpleado(), this, excusa);
        AdministradorDeProntuarios.getInstance().agregarProntuario(prontuario);
    }

    @Override
    public void notificar(Prontuario prontuario) {
        new EmailSender().enviarEmail(
                this.getEmail(),
                "admin@excusas.sa",
                "Nuevo prontuario registrado",
                "Se ha registrado un nuevo prontuario: " + prontuario.toString()
        );
    }

    @Override
    public boolean soyCEO() {
        return true;
    }

    @Override
    public void pasarExcusa(Excusa excusa) {

    }

}
