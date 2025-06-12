package ar.edu.davinci.excusas.empleado;

import ar.edu.davinci.excusas.empleado.interfaces.IEncargado;
import ar.edu.davinci.excusas.empleado.interfaces.ManejadorExcusa;
import ar.edu.davinci.excusas.excusa.Excusa;
import ar.edu.davinci.excusas.empleado.modoaccion.ModoAccion;
import ar.edu.davinci.excusas.empleado.modoaccion.ModoNormal;
import ar.edu.davinci.excusas.empleado.modoaccion.ModoProductivo;
import ar.edu.davinci.excusas.empleado.modoaccion.ModoVago;

public abstract class Encargado extends Empleado implements ManejadorExcusa, IEncargado {

    public ManejadorExcusa siguiente;
    protected ModoAccion modoAccion;

    //
    public Encargado(String nombre, String email, int legajo) {
        this(nombre, email, legajo, null);
    }

    public Encargado(String nombre, String email, int legajo, ManejadorExcusa siguiente) {
        super(nombre, email, legajo);
        modoNormal();
        this.siguiente = siguiente;
    }

    @Override
    public void setSiguiente(ManejadorExcusa siguiente) {
        this.siguiente = siguiente;
    }

    @Override
    public void manejarExcusa(Excusa excusa) {
        if(puedeManejar(excusa)) {
            this.modoAccion.actuar(this, excusa);
        }else{
            pasarExcusa(excusa);
        }
    }
    
    /* sacar el loop, mentira no lo soluciona per */

    @Override
    public void procesarExcusa(Excusa excusa){
        EmailSender emailSender = new EmailSender();
        EmailSender.enviarEmail();
    }

    
    @Override
    public boolean puedeManejar(Excusa excusa){
        return excusa.puedeSerManejadaPor(this);
    }

    @Override
    public void pasarExcusa(Excusa excusa){
        siguiente.manejarExcusa(excusa);
    }

    @Override
    public void modoNormal(){
        this.modoAccion = new ModoNormal();
    }

    @Override
    public void modoProductivo(){
        this.modoAccion = new ModoProductivo();
    }

    @Override
    public void modoVago(){
        this.modoAccion = new ModoVago();
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
        return false;
    }

}
