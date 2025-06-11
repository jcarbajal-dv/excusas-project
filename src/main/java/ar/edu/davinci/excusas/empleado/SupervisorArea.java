package ar.edu.davinci.excusas.empleado;


import ar.edu.davinci.excusas.empleado.interfaces.ManejadorExcusa;

public class SupervisorArea extends Encargado {

    ManejadorExcusa siguiente;

    public SupervisorArea(String nombre, String email, int legajo, ManejadorExcusa siguiente) {
        super(nombre, email, legajo);
        this.siguiente = siguiente;
    }

    @Override
    public boolean soySupervisorArea() {
        return true;
    }
}