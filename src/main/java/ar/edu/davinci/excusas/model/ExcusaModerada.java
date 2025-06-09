package ar.edu.davinci.excusas.model;

import ar.edu.davinci.excusas.service.EmailSender;

public class ExcusaModerada extends ITipoExcusa{
    public void actuar(Empleado empleado, Excusa excusa) {
        new EmailSender().enviarEmail(Excusa.getEmpleado().getEmail(), );
    }

    @Override
    public boolean puedeSerManejadaPor(ManejadorExcusa manejadorExcusa) {
        return manejadorExcusa.soySupervisorArea();
    }
}
