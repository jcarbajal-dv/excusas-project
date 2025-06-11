package ar.edu.davinci.excusas.empleado;


import ar.edu.davinci.excusas.empleado.interfaces.ManejadorExcusa;

public class Recepcionista extends Encargado {

    ManejadorExcusa siguiente;

    public Recepcionista(String nombre, String email, int legajo, ManejadorExcusa siguiente) {
        super(nombre, email, legajo);
        this.siguiente = siguiente;
    }

    @Override
    public boolean soyRecepcionista() {
        return true;
    }

}