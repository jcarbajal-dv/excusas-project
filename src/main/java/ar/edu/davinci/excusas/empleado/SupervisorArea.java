package ar.edu.davinci.excusas.empleado;


public class SupervisorArea extends Encargado {


    public SupervisorArea(String nombre, String email, int legajo) {
        super(nombre, email, legajo);
    }

    @Override
    public boolean soySupervisorArea() {
        return true;
    }
}