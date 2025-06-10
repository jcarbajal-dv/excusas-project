package ar.edu.davinci.excusas.prontuario;

import ar.edu.davinci.excusas.prontuario.interfaces.Observable;
import ar.edu.davinci.excusas.prontuario.interfaces.ObservadorCEO;

import java.util.ArrayList;
import java.util.List;

public class ProntuarioObservable implements Observable {

    private List<Prontuario> prontuarios = new ArrayList<>();
    private List<ObservadorCEO> observadores = new ArrayList<>();

    @Override
    public void registrarObservador(ObservadorCEO observador) {

    }

    @Override
    public void eliminarObservador(ObservadorCEO observador) {

    }

    @Override
    public void notificarObservadores(Prontuario prontuario) {

    }
}
