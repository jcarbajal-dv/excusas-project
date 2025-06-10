package ar.edu.davinci.excusas.empleado.interfaces;

import ar.edu.davinci.excusas.empleado.modoaccion.ModoAccion;

public interface IEncargado {

    public ModoAccion getModoAccion();
    public void modoNormal();
    public void modoVago();
    public void modoProductivo();
    public void enviarEmail(String destino, String origen, String asunto, String mensaje);
}
