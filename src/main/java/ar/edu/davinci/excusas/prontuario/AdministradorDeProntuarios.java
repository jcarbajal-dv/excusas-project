package ar.edu.davinci.excusas.prontuario;

import ar.edu.davinci.excusas.prontuario.interfaces.Observable;
import ar.edu.davinci.excusas.prontuario.interfaces.ObservadorCEO;

import java.util.ArrayList;
import java.util.List;

public class AdministradorDeProntuarios implements Observable {
    private static AdministradorDeProntuarios instancia;
    private AdministradorDeProntuarios() {}

    public static AdministradorDeProntuarios getInstance() {
        if (instancia == null) {
            instancia = new AdministradorDeProntuarios();
        }
        return instancia;
    }

    public void agregarProntuario(Prontuario prontuario) {
        this.prontuarios.add(prontuario);
        this.notificarObservadores(prontuario);
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