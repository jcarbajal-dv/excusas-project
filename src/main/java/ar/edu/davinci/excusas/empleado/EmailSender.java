package ar.edu.davinci.excusas.empleado;

import ar.edu.davinci.excusas.empleado.interfaces.IEmailSender;

public class EmailSender implements IEmailSender {

    @Override
    public void enviarEmail(String destino, String origen, String asunto, String cuerpo) {
    }
}