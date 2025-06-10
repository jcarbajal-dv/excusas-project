package ar.edu.davinci.excusas.observer.interfaces;

import ar.edu.davinci.excusas.prontuario.Prontuario;

public interface Observable {
    void registrarObservador(ObservadorCEO observador);
    void eliminarObservador(ObservadorCEO observador);
    void notificarObservadores(Prontuario prontuario);
}