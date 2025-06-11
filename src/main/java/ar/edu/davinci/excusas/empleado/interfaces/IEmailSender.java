package ar.edu.davinci.excusas.empleado.interfaces;

public interface IEmailSender {

    public void enviarEmail(String destino, String origen, String asunto, String cuerpo);
}
