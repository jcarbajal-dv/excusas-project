package ar.edu.davinci.excusas.model;

public interface ITipoExcusa{

    void actuar(Empleado empleado, Excusa excusa) {
    }

    boolean puedeSerManejadaPor(ManejadorExcusa manejadorExcusa){
        return false;
    }
}
