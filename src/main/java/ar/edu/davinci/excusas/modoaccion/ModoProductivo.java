package ar.edu.davinci.excusas.modoaccion;

import ar.edu.davinci.excusas.encargado.Encargado;
import ar.edu.davinci.excusas.excusa.Excusa;
import ar.edu.davinci.excusas.encargado.EmailSender;

public class ModoProductivo implements ModoAccion {
    @Override
    public void actuar(Encargado encargado, Excusa excusa) {
        new EmailSender().enviarEmail( encargado.getEmail(),"cto@excusas.org", "idk", "Ojeen esto");
        encargado.manejarExcusa(excusa);
        }
    }

