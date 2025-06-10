package ar.edu.davinci.excusas.encargado;


public class Recepcionista extends Encargado {

    public Recepcionista(String nombre, String email, int legajo) {
        super(nombre, email, legajo);
    }

    @Override
    public boolean soyRecepcionista() {
        return true;
    }

}