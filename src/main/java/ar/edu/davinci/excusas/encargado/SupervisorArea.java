package ar.edu.davinci.excusas.encargado;

import ar.edu.davinci.excusas.excusa.Excusa;
import ar.edu.davinci.excusas.service.EmailSender;
import ar.edu.davinci.excusas.strategy.ModoAccion;


public class SupervisorArea extends Encargado {


    public SupervisorArea(String nombre, String email, int legajo) {
        super(nombre, email, legajo);
    }


    @Override
    public boolean soyCEO() {
        return false;
    }

    @Override
    public boolean soyRecepcionista() {
        return false;
    }

    @Override
    public boolean soyGerenteRRHH() {
        return false;
    }

    @Override
    public boolean soySupervisorArea() {
        return true;
    }

}