package ar.edu.davinci.excusas.encargado;

import ar.edu.davinci.excusas.excusa.Excusa;

public class Rechazador extends Encargado{

    public Rechazador(){}

    public Encargado getSiguiente(){
        return null;
    }

    public void procesar(Excusa excusa){
        System.out.println("Necesitamos mas pruebas");

    }

}
