package ar.edu.davinci.excusas.excusa;

import ar.edu.davinci.excusas.empleado.EmailSender;
import ar.edu.davinci.excusas.empleado.Empleado;
import ar.edu.davinci.excusas.empleado.Encargado;
import ar.edu.davinci.excusas.empleado.interfaces.ManejadorExcusa;


public class ExcusaFamilia extends ExcusaModerada {

    private String asunto="Cuidado familiar.";
    private String cuerpo="Está todo bien?";
    //me falta el mail del empleado y está joya esto

    @Override
    public boolean puedeSerManejadaPor(ManejadorExcusa manejadorExcusa) {
        return manejadorExcusa.soySupervisorArea();
    }

    @Override
    public void resolverExcusaModerada(Encargado encargado){
        EmailSender emailSender = new EmailSender();
        emailSender.enviarEmail(encargado.getEmail(), empleado.getEmail(), asunto, cuerpo);
    }
}
