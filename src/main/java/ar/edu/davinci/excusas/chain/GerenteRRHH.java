package ar.edu.davinci.excusas.chain;

import ar.edu.davinci.excusas.model.Excusa;
import ar.edu.davinci.excusas.service.EmailSender;
import ar.edu.davinci.excusas.strategy.ModoEvaluacion;

public class GerenteRRHH extends Encargado {

    public GerenteRRHH(String nombre, String email, int legajo, ManejadorExcusas siguiente) {
        super(nombre, email, legajo);
        this.siguiente = siguiente;
    }

    @Override
    public void procesar(Excusa excusa) {
        emailSender.enviarEmail(
                excusa.getEmpleado().getEmail(),
                this.getEmail(),
                "Excusa recibida",
                "La excusa ha sido evaluada y aceptada."
        );
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
        return true;
    }

    @Override
    public boolean soySupervisorArea() {
        return false;
    }

    @Override
    public void pasarExcusa(Excusa excusa) {

    }

    @Override
    public boolean soyEncargadoDefault() {
        return false;
    }
}
