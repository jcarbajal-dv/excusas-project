package ar.edu.davinci.excusas.model;

import ar.edu.davinci.excusas.chain.ManejadorExcusas;
import ar.edu.davinci.excusas.service.EmailSender;

public class ExcusaFamilia implements ITipoExcusa{
    public void actuar(Empleado empleado, Excusa excusa) {
        new EmailSender().enviarEmail(excusa.getEmpleado().getEmail(), encargado.getEmail() ,"Cuidado Familiar", "¿Necesitas algo?");

    }

    @Override
    public boolean puedeSerManejadaPor(ManejadorExcusa manejadorExcusa) {
        return manejadorExcusas.soySupervisorArea();
    }
}
