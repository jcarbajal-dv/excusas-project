package ar.edu.davinci.excusas.test;

import ar.edu.davinci.excusas.encargado.*;
import ar.edu.davinci.excusas.encargado.interfaces.ManejadorExcusa;
import ar.edu.davinci.excusas.excusa.Excusa;
import ar.edu.davinci.excusas.prontuario.AdministradorDeProntuarios;
import ar.edu.davinci.excusas.encargado.EmailSender;
import ar.edu.davinci.excusas.modoaccion.ModoNormal;
import ar.edu.davinci.excusas.modoaccion.ModoProductivo;

public class test {
    public static void main(String[] args) {

        EmailSender emailSender = new EmailSender();


        Recepcionista recepcionista = new Recepcionista("Ana", "ana@excusas.sa", 1, new ModoNormal(), emailSender);
        SupervisorArea supervisor = new SupervisorArea("Luis", "luis@excusas.sa", 2, new ModoProductivo(), emailSender);
        GerenteRRHH gerente = new GerenteRRHH("Marta", "marta@excusas.sa", 3, new ModoNormal(), emailSender);
        CEO ceo1 = new CEO("Claudio", "claudio@excusas.sa", 4, new ModoNormal(), emailSender);
        CEO ceo2 = new CEO("Roxana", "roxana@excusas.sa", 5, new ModoNormal(), emailSender);
        EncargadoPorDefecto encargadoPorDefecto = new EncargadoPorDefecto("Encargado Default", "encargado@excusas.sa", 999, emailSender);


        AdministradorDeProntuarios.getInstance().registrarObservador(ceo1);
        AdministradorDeProntuarios.getInstance().registrarObservador(ceo2);


        recepcionista.setSiguiente(supervisor);
        supervisor.setSiguiente(gerente);
        gerente.setSiguiente(ceo1);


        ManejadorExcusa.Empleado e1 = new ManejadorExcusa.Empleado("Juan Pérez", "juan@mail.com", 100);
        Excusa excusa1 = new Excusa(e1, MotivoExcusa.QUEDARSE_DORMIDO);

        ManejadorExcusa.Empleado e2 = new ManejadorExcusa.Empleado("Lucía García", "lucia@mail.com", 101);
        Excusa excusa2 = new Excusa(e2, MotivoExcusa.CUIDADO_FAMILIAR);

        ManejadorExcusa.Empleado e3 = new ManejadorExcusa.Empleado("Carlos Díaz", "carlos@mail.com", 102);
        Excusa excusa3 = new Excusa(e3, MotivoExcusa.COMPLEJO);

        ManejadorExcusa.Empleado e4 = new ManejadorExcusa.Empleado("Sofía Méndez", "sofia@mail.com", 103);
        Excusa excusa4 = new Excusa(e4, MotivoExcusa.INVEROSIMIL);

        ManejadorExcusa.Empleado e5 = new ManejadorExcusa.Empleado("Tobi", "tobi@mail.com", 104);
        Excusa excusa5 = new Excusa(e5, MotivoExcusa.INVEROSIMIL);


        recepcionista.manejarExcusa(excusa1);
        recepcionista.manejarExcusa(excusa2);
        recepcionista.manejarExcusa(excusa3);
        recepcionista.manejarExcusa(excusa4);
        recepcionista.manejarExcusa(excusa5);
    }
}
