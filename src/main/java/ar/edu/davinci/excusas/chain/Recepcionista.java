package ar.edu.davinci.excusas.chain;

import ar.edu.davinci.excusas.model.Excusa;
import ar.edu.davinci.excusas.service.EmailSender;
import ar.edu.davinci.excusas.strategy.ModoEvaluacion;

public class Recepcionista extends EncargadoBase implements ManejadorExcusas {

    public Recepcionista(String nombre, String email, int legajo, ManejadorExcusas siguiente) {
        super(nombre, email, legajo, modo, emailSender);
        this.siguiente = siguiente;
    }



    @Override
    public void procesar(Excusa excusa) {
        emailSender.enviarEmail(
                excusa.getEmpleado().getEmail(),
                this.getEmail(),
                "Excusa aceptada",
                "La excusa fue aceptada por el Recepcionista."
        );
    }

    @Override
    public boolean soyCEO() {
        return false;
    }

    @Override
    public boolean soyRecepcionista() {
        return true;
    }

    @Override
    public boolean soyGerenteRRHH() {
        return false;
    }

    @Override
    public boolean soySupervisorArea() {
        return false;
    }

    @Override
    public void pasarExcusa(Excusa excusa) {

    }

    @Override
    public void setSiguiente(ManejadorExcusa siguiente) {

    }

    @Override
    public boolean soyEncargadoDefault() {
        return false;
    }

    @Override
    public boolean puedeManejar(Excusa excusa) {
        return false;
    }
}