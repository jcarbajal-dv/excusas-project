package ar.edu.davinci.excusas.service;

public interface EmailSender {
    void enviarEmail(String destino, String origen, String asunto, String cuerpo);
}
