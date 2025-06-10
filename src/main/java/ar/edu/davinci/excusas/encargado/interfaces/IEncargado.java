package ar.edu.davinci.excusas.encargado.interfaces;

import ar.edu.davinci.excusas.strategy.ModoAccion;

public interface IEncargado {

    public ModoAccion getModoAccion();
    public void modoNormal();
    public void modoVago();
    public void modoProductivo();
    public void enviarEmail(String destino, String origen, String asunto, String mensaje);
}
