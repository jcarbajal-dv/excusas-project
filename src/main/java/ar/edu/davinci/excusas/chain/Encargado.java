package ar.edu.davinci.excusas.chain;

import ar.edu.davinci.excusas.model.Empleado;
import ar.edu.davinci.excusas.model.Excusa;
import ar.edu.davinci.excusas.model.MotivoExcusa;
import ar.edu.davinci.excusas.strategy.ModoEvaluacion;
import ar.edu.davinci.excusas.service.EmailSender;

public abstract class Encargado extends Empleado implements ManejadorExcusas {

    public ManejadorExcusas siguiente;
    protected ModoEvaluacion modo;
    public EmailSender emailSender;

    public Encargado(String nombre, String email, int legajo, ModoEvaluacion modo, EmailSender emailSender) {
        super(nombre, email, legajo);
        this.modo = modo;
        this.emailSender = emailSender;
    }

    public void setSiguiente(ManejadorExcusas siguiente) {
        this.siguiente = siguiente;
    }

    public void manejarExcusa(Excusa excusa) {
        modo.evaluar(this, excusa);
    }

    public abstract boolean puedeManejar(MotivoExcusa motivo);
    public abstract void procesar(Excusa excusa);
}
