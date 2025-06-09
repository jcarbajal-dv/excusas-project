package ar.edu.davinci.excusas.chain;

import ar.edu.davinci.excusas.model.Empleado;
import ar.edu.davinci.excusas.model.Excusa;
import ar.edu.davinci.excusas.model.TipoExcusa;
import ar.edu.davinci.excusas.strategy.ModoEvaluacion;
import ar.edu.davinci.excusas.service.EmailSender;
import ar.edu.davinci.excusas.strategy.ModoNormal;

public abstract class Encargado extends Empleado implements ManejadorExcusas {

    public ManejadorExcusas siguiente;
    protected ModoEvaluacion modo;
    public EmailSender emailSender;
    TipoExcusa tipo;

    public Encargado(String nombre, String email, int legajo, ManejadorExcusas siguiente) {
        super(nombre, email, legajo);
        this.siguiente = siguiente;
    }

    public void setSiguiente(ManejadorExcusas siguiente) {
        this.siguiente = siguiente;
    }

    public void manejarExcusa(Excusa excusa) {
        modo.evaluar(this, excusa);
    }

    public abstract boolean puedeManejar(TipoExcusa tipo);
    public abstract void procesar(Excusa excusa);
}
