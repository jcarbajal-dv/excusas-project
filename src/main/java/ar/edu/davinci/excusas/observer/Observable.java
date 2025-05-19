package ar.edu.davinci.excusas.observer;

import ar.edu.davinci.excusas.model.Prontuario;

public interface Observable {
    void registrarObservador(ObservadorCEO observador);
    void eliminarObservador(ObservadorCEO observador);
    void notificarObservadores(Prontuario prontuario);
}