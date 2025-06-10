package ar.edu.davinci.excusas.encargado;


import ar.edu.davinci.excusas.encargado.Encargado;
import ar.edu.davinci.excusas.encargado.interfaces.ManejadorExcusa;

public class GerenteRRHH extends Encargado {

    public GerenteRRHH(String nombre, String email, int legajo, ManejadorExcusa siguiente) {
        super(nombre, email, legajo);
        this.siguiente = siguiente;
    }

    @Override
    public boolean soyGerenteRRHH() {
        return true;
    }





}
