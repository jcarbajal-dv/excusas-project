package ar.edu.davinci.excusas.prontuario;

import ar.edu.davinci.excusas.prontuario.interfaces.Observable;
import ar.edu.davinci.excusas.prontuario.interfaces.ObservadorCEO;

public class AdministradorDeProntuario implements Observable {
    private static AdministradorDeProntuario instancia;
    private AdministradorDeProntuario() {}

    public static AdministradorDeProntuario getInstance() {
        if (instancia == null) {
            instancia = new AdministradorDeProntuario();
        }
        return instancia;
    }



    @Override
    public void registrarObservador(ObservadorCEO observador) {
        observadores.add(observador);
    }

    @Override
    public void eliminarObservador(ObservadorCEO observador) {
        observadores.remove(observador);
    }

    @Override
    public void notificarObservadores(Prontuario prontuario) {
        for (ObservadorCEO observador : observadores) {
            observador.notificar(prontuario);
        }
    }
}