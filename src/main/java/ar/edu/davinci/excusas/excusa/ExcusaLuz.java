package ar.edu.davinci.excusas.excusa;

import ar.edu.davinci.excusas.empleado.EmailSender;
import ar.edu.davinci.excusas.empleado.Encargado;
import ar.edu.davinci.excusas.empleado.interfaces.ManejadorExcusa;

public class ExcusaLuz extends ExcusaModerada {

    private String destino="EDESUR@fake.com";
    private String asunto="Problemas con el suministro";
    private String cuerpo="Está chequeado esto?";

    @Override
    public boolean puedeSerManejadaPor(ManejadorExcusa manejadorExcusa) {
        return manejadorExcusa.soySupervisorArea();
    }

    @Override
    public void resolverExcusaModerada(Encargado encargado){
        EmailSender emailSender = new EmailSender();
        emailSender.enviarEmail(destino, encargado.getEmail(), asunto, cuerpo);

    }

}
