package ar.edu.davinci.excusas.encargado;


public class SupervisorArea extends Encargado {


    public SupervisorArea(String nombre, String email, int legajo) {
        super(nombre, email, legajo);
    }

    @Override
    public boolean soySupervisorArea() {
        return true;
    }
}