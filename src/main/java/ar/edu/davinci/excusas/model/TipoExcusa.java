package ar.edu.davinci.excusas.model;

public class TipoExcusa implements ITipoExcusa {

    @Override
    public void actuar(Empleado empleado, Excusa excusa) {

    }

    @Override
    public boolean puedeSerManejadaPor(ManejadorExcusa manejadorExcusa) {
        return false;
    }
}
