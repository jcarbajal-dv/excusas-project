package ar.edu.davinci.excusas.model;

import ar.edu.davinci.excusas.service.EmailSender;

public class ExcusaLuz implements ITipoExcusa{
    public void actuar(Empleado empleado, Excusa excusa) {
        new EmailSender().enviarEmail("Edesur@fake.com",encargado.getEmail(), "Consulta sumnisitro", "está chequeado esto?");
    }

    @Override
    public boolean puedeSerManejadaPor(ManejadorExcusa manejadorExcusa) {
        return manejadorExcusa.soySupervisorArea();
    }
}
