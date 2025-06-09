package ar.edu.davinci.excusas.chain;

import ar.edu.davinci.excusas.model.Excusa;

public interface ManejadorExcusas {
    void manejarExcusa(Excusa excusa);
    void setSiguiente(ManejadorExcusas siguiente);
    boolean soyCEO();
    boolean soyRecepcionista();
    boolean soyGerenteRRHH();
    boolean soySupervisorArea();
    void pasarExcusa(Excusa excusa);
    boolean soyEncargadoDefault();
    boolean puedeManejar(Excusa excusa);
    boolean pasarExcusa(Excusa excusa);
    ManejadorExcusa getSiguiente;
    void setSiguiente(ManejadorExcusa siguiente);
}
