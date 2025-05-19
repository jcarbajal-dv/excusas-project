package ar.edu.davinci.excusas.observer;

import ar.edu.davinci.excusas.model.Prontuario;

public interface ObservadorCEO {
    void notificar(Prontuario prontuario);
}
