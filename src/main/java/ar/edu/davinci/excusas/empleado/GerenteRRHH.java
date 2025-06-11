package ar.edu.davinci.excusas.empleado;


import ar.edu.davinci.excusas.empleado.interfaces.ManejadorExcusa;

public class GerenteRRHH extends Encargado {

    public GerenteRRHH(String nombre, String email, int legajo) {
        super(nombre, email, legajo);
        this.siguiente = siguiente;
    }

    @Override
    public boolean soyGerenteRRHH() {
        return true;
    }





}
