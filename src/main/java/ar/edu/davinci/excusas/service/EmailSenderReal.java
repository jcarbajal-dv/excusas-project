package ar.edu.davinci.excusas.service;

public class EmailSenderReal implements EmailSender {
    @Override
    public void enviarEmail(String destino, String origen, String asunto, String cuerpo) {
        System.out.printf("Email enviado a %s desde %s con el asunto '%s': %s%n", destino, origen, asunto, cuerpo);
    }
}