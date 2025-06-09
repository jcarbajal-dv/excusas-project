package ar.edu.davinci.excusas.chain;

import ar.edu.davinci.excusas.model.Excusa;

public class Rechazador extends Encargado{
    public Rechazador(){}

    public Encargado getSiguiente(){
        return null;
    }

    public void procesar(Excusa excusa){
        System.out.println("Necesitamos mas pruebas");

    }

    public boolean soyCEO(){
        return false;
    }

    public boolean soyRecepcionista(){
        return false;
    }

    public boolean soyGerenteRRHH(){
        return false;
    }

    public boolean soySupervisorArea(){
        return false;
    }

    public boolean soyEncargadoDefault(){
        return false;
    }
}
