package ar.edu.davinci.excusas.test;

import ar.edu.davinci.excusas.encargado.*;
import ar.edu.davinci.excusas.encargado.interfaces.ManejadorExcusa;
import ar.edu.davinci.excusas.excusa.Excusa;
import ar.edu.davinci.excusas.prontuario.AdministradorDeProntuarios;
import ar.edu.davinci.excusas.modoaccion.ModoNormal;
import ar.edu.davinci.excusas.modoaccion.ModoProductivo;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;


import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.jupiter.api.Assertions.*;

public class TestExcusasSA {

    private EmailSender dummyEmailSender;

    @BeforeEach
    public void setup() {
        dummyEmailSender = (destino, origen, asunto, cuerpo) ->
                System.out.printf("EMAIL [%s] -> %s: %s%n", destino, asunto, cuerpo);
    }

    @Test
    public void testRecepcionistaAceptaExcusaTrivial() {
        Encargado recepcionista = new Recepcionista("Recepcionista", "rec@sa.com", 1, new ModoNormal(), dummyEmailSender);

        ManejadorExcusa.Empleado e = new ManejadorExcusa.Empleado("Empleado A", "a@sa.com", 101);
        Excusa excusa = new Excusa(e, MotivoExcusa.QUEDARSE_DORMIDO);

        recepcionista.manejarExcusa(excusa);

    }

    @Test
    public void testSupervisorAceptaExcusaModerada() {
        Encargado recepcionista = new Recepcionista("Recep", "rec@sa.com", 1, new ModoNormal(), dummyEmailSender);
        Encargado supervisor = new SupervisorArea("Super", "sup@sa.com", 2, new ModoNormal(), dummyEmailSender);

        recepcionista.setSiguiente(supervisor);

        ManejadorExcusa.Empleado e = new ManejadorExcusa.Empleado("Empleado B", "b@sa.com", 102);
        Excusa excusa = new Excusa(e, MotivoExcusa.CUIDADO_FAMILIAR);

        recepcionista.manejarExcusa(excusa);
    }

    @Test
    public void testCEORegistraProntuarioYNotifica() {
        AtomicBoolean notificado = new AtomicBoolean(false);

        CEO ceo = new CEO("CEO1", "ceo1@sa.com", 4, new ModoNormal(), dummyEmailSender);
        AdministradorDeProntuarios.getInstance().registrarObservador(prontuario -> notificado.set(true));

        Excusa excusa = new Excusa(new ManejadorExcusa.Empleado("E", "e@sa.com", 105), MotivoExcusa.INVEROSIMIL);
        ceo.manejarExcusa(excusa);

        assertTrue(notificado.get(), "Se esperaba notificación a observadores de CEO");
    }

    @Test
    public void testExcusaIrrelevanteEsRechazada() {
        Encargado recepcionista = new Recepcionista("R", "r@sa.com", 1, new ModoNormal(), dummyEmailSender);
        Encargado ceo = new CEO("C", "c@sa.com", 2, new ModoNormal(), dummyEmailSender);


        recepcionista.setSiguiente(ceo);
        //ceo.setSiguiente(fin);

        Excusa excusa = new Excusa(new ManejadorExcusa.Empleado("E", "e@sa.com", 106), MotivoExcusa.INVEROSIMIL);
        recepcionista.manejarExcusa(excusa);
    }

    @Test
    public void testModoProductivoNotificaCTO() {
        Encargado supervisor = new SupervisorArea("S", "s@sa.com", 3, new ModoProductivo(), (dest, orig, as, cuerpo) -> {
            assertEquals("cto@excusas.sa", dest);
            assertTrue(as.contains("productividad"));
        });

        Excusa excusa = new Excusa(new ManejadorExcusa.Empleado("Emp", "emp@sa.com", 107), MotivoExcusa.CUIDADO_FAMILIAR);
        supervisor.manejarExcusa(excusa);
    }
}
