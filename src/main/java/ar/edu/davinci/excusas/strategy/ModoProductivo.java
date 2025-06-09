package ar.edu.davinci.excusas.strategy;

import ar.edu.davinci.excusas.chain.Encargado;
import ar.edu.davinci.excusas.model.Excusa;
import ar.edu.davinci.excusas.service.EmailSender;

public class ModoProductivo implements ModoEvaluacion {
    @Override
    public void evaluar(Encargado encargado, Excusa excusa) {
        new emailSender().sendEmail("cto@excusas.org", encargado.getEmail(), "idk", "Ojeen esto");
        encargado.manejarExcusa(excusa);
        }
    }

