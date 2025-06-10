package ar.edu.davinci.excusas.observer;

import ar.edu.davinci.excusas.observer.interfaces.Observable;
import ar.edu.davinci.excusas.observer.interfaces.ObservadorCEO;
import ar.edu.davinci.excusas.prontuario.Prontuario;

import java.util.ArrayList;
import java.util.List;

public class AdministradorDeProntuarios implements Observable {
    private static AdministradorDeProntuarios instancia;
    private List<Prontuario> prontuarios = new ArrayList<>();
    private List<ObservadorCEO> observadores = new ArrayList<>();

    private AdministradorDeProntuarios() {}

    public static AdministradorDeProntuarios getInstance() {
        if (instancia == null) {
            instancia = new AdministradorDeProntuarios();
        }
        return instancia;
    }

    public void agregarProntuario(Prontuario prontuario) {
        prontuarios.add(prontuario);
        notificarObservadores(prontuario);
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