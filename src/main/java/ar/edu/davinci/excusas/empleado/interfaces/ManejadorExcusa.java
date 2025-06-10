package ar.edu.davinci.excusas.empleado.interfaces;

import ar.edu.davinci.excusas.excusa.Excusa;

public interface ManejadorExcusa {
    void manejarExcusa(Excusa excusa);
    void setSiguiente(ManejadorExcusa siguiente);
    boolean soyCEO();
    boolean soyRecepcionista();
    boolean soyGerenteRRHH();
    boolean soySupervisorArea();
    void pasarExcusa(Excusa excusa);
    boolean puedeManejar(Excusa excusa);
    void hacerAlgo(Excusa excusa);
    ManejadorExcusa getSiguiente();




}
