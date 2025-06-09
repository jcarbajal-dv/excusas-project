package ar.edu.davinci.excusas.test;

import ar.edu.davinci.excusas.chain.*;
import ar.edu.davinci.excusas.model.Empleado;
import ar.edu.davinci.excusas.model.Excusa;
import ar.edu.davinci.excusas.observer.AdministradorDeProntuarios;
import ar.edu.davinci.excusas.service.EmailSenderReal;
import ar.edu.davinci.excusas.strategy.ModoNormal;
import ar.edu.davinci.excusas.strategy.ModoProductivo;

public class test {
    public static void main(String[] args) {

        EmailSenderReal emailSender = new EmailSenderReal();


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
        ceo1.setSiguiente(encargadoPorDefecto);


        Empleado e1 = new Empleado("Juan Pérez", "juan@mail.com", 100);
        Excusa excusa1 = new Excusa(e1, MotivoExcusa.QUEDARSE_DORMIDO);

        Empleado e2 = new Empleado("Lucía García", "lucia@mail.com", 101);
        Excusa excusa2 = new Excusa(e2, MotivoExcusa.CUIDADO_FAMILIAR);

        Empleado e3 = new Empleado("Carlos Díaz", "carlos@mail.com", 102);
        Excusa excusa3 = new Excusa(e3, MotivoExcusa.COMPLEJO);

        Empleado e4 = new Empleado("Sofía Méndez", "sofia@mail.com", 103);
        Excusa excusa4 = new Excusa(e4, MotivoExcusa.INVEROSIMIL);

        Empleado e5 = new Empleado("Tobi", "tobi@mail.com", 104);
        Excusa excusa5 = new Excusa(e5, MotivoExcusa.INVEROSIMIL);


        recepcionista.manejarExcusa(excusa1);
        recepcionista.manejarExcusa(excusa2);
        recepcionista.manejarExcusa(excusa3);
        recepcionista.manejarExcusa(excusa4);
        recepcionista.manejarExcusa(excusa5);
    }
}
