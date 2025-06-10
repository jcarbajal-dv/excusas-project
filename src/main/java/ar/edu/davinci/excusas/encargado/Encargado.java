package ar.edu.davinci.excusas.encargado;

import ar.edu.davinci.excusas.encargado.interfaces.IEncargado;
import ar.edu.davinci.excusas.encargado.interfaces.ManejadorExcusa;
import ar.edu.davinci.excusas.excusa.Excusa;
import ar.edu.davinci.excusas.modoaccion.ModoAccion;
import ar.edu.davinci.excusas.modoaccion.ModoNormal;
import ar.edu.davinci.excusas.modoaccion.ModoProductivo;
import ar.edu.davinci.excusas.modoaccion.ModoVago;

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
    public ModoAccion getModoAccion(){
        return this.modoAccion;
    }

    @Override
    public void manejarExcusa(Excusa excusa) {
        if(puedeManejar(excusa)) {
            modoAccion.actuar(this, excusa);
        }else{
            pasarExcusa(excusa);
        }
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
