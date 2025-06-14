package ar.edu.davinci.excusas.empleado;

import ar.edu.davinci.excusas.empleado.interfaces.ManejadorExcusa;
import ar.edu.davinci.excusas.excusa.Excusa;

public class Rechazador implements ManejadorExcusa {

    public Rechazador(){}

    @Override
    public void manejarExcusa(Excusa excusa) {
        procesar(excusa);
    }

    @Override
    public boolean puedeManejar(Excusa excusa) {
        return true;
    }


    public Encargado getSiguiente(){
        return null;
    }

    public void procesar(Excusa excusa){
        new EmailSender().enviarEmail(excusa.getEmpleado().getEmail(),
                "rechazador@excusas.org",
                "Excusa rechazada",
                "Necesitamos más pruebas");
    }

}
