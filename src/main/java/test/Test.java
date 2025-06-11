package test;

import ar.edu.davinci.excusas.empleado.*;
import ar.edu.davinci.excusas.empleado.modoaccion.ModoNormal;
import ar.edu.davinci.excusas.empleado.modoaccion.ModoVago;
import ar.edu.davinci.excusas.excusa.*;
import ar.edu.davinci.excusas.prontuario.Prontuario;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;


class Test {

    @Test
    void testRecepcionistaManejaExcusaTrivial() {

        Recepcionista recepcionista = new Recepcionista("Lucas", "lucas@excusas.org", 1);
        ExcusaTrivial excusaTrivial = new ExcusaTrivial();
        Excusa excusa = new Excusa(new Empleado("Juan", "juan@excusas.org", 10), "Llegué tarde", excusaTrivial);

        assertTrue(excusa.puedeSerManejadaPor(recepcionista), "El recepcionista debería manejar excusas triviales.");
    }

    @Test
    void testSupervisorManejaExcusaModerada() {
        SupervisorArea supervisor = new SupervisorArea("Martín", "martin@excusas.org", 2);
        ExcusaLuz excusaLuz = new ExcusaLuz();
        Excusa excusa = new Excusa(new Empleado("Ana", "ana@excusas.org", 20), "Corte de luz", excusaLuz);

        assertTrue(excusa.puedeSerManejadaPor(supervisor), "El supervisor debería manejar excusas moderadas.");
    }

    @Test
    void testGerenteRRHHManejaExcusaCompleja() {
        GerenteRRHH gerente = new GerenteRRHH("Sarah", "sarah@excusas.org", 3, null);
        ExcusaCompleja excusaCompleja = new ExcusaCompleja();
        Excusa excusa = new Excusa(new Empleado("Pedro", "pedrito@excusas.org", 30), "Una paloma robó mi bicicleta", excusaCompleja);

        assertTrue(excusa.puedeSerManejadaPor(gerente), "El gerente de RRHH debería manejar excusas complejas.");
    }

    @Test
    void testCEORecibeExcusaInverosimil() {
        CEO ceo = new CEO("Laura", "laura@excusas.org", 4, null);
        ExcusaInverosimil excusaInverosimil = new ExcusaInverosimil();
        Excusa excusa = new Excusa(new Empleado("Sofía", "sofi@excusas.org", 40), "Tenía que celebrar que mi abuela llegó a Challenger en el LoL", excusaInverosimil);

        assertTrue(excusa.puedeSerManejadaPor(ceo), "El CEO debería manejar excusas inverosímiles.");
    }



    @Test
    void testCadenaDeResponsabilidad() {
        Recepcionista recepcionista = new Recepcionista("Lucas", "lucas@excusas.org", 1);
        SupervisorArea supervisor = new SupervisorArea("Martín", "martin@excusas.org", 2);
        GerenteRRHH gerente = new GerenteRRHH("Sarah", "sarah@excusas.org", 3, supervisor);
        CEO ceo = new CEO("Laura", "laura@excusas.org", 4, null);

        recepcionista.setSiguiente(supervisor);
        supervisor.setSiguiente(gerente);
        gerente.setSiguiente(ceo);

        ExcusaCompleja excusaCompleja = new ExcusaCompleja();
        Excusa excusa = new Excusa(new Empleado("María", "maria@excusas.org", 50), "Fui abducido por aliens", excusaCompleja);

        recepcionista.manejarExcusa(excusa);
        assertFalse(excusa.puedeSerManejadaPor(recepcionista), "La excusa debería pasar al supervisor.");
        assertFalse(excusa.puedeSerManejadaPor(supervisor), "La excusa debería pasar al gerente.");
        assertTrue(excusa.puedeSerManejadaPor(gerente), "Finalmente, el gerente maneja la excusa.");
    }

    @Test
    void testModoAccionNormal() {

        SupervisorArea supervisor = new SupervisorArea("Martín", "martin@excusas.org", 2);
        supervisor.modoNormal();

        ExcusaLuz excusaLuz = new ExcusaLuz();
        Excusa excusa = new Excusa(new Empleado("Ana", "ana@excusas.org", 20), "Corte de luz", excusaLuz);

        supervisor.manejarExcusa(excusa);


        assertEquals(ModoNormal.class, supervisor.getModoAccion().getClass(),
                "El supervisor debería estar en modo normal.");
    }

    @Test
    void testModoAccionVago() {

        SupervisorArea supervisor = new SupervisorArea("Martín", "martin@excusas.org", 2);
        supervisor.modoVago();

        ExcusaLuz excusaLuz = new ExcusaLuz();
        Excusa excusa = new Excusa(new Empleado("Ana", "ana@excusas.org", 20), "Corte de luz", excusaLuz);

        supervisor.manejarExcusa(excusa);

        assertEquals(ModoVago.class, supervisor.getModoAccion().getClass(),
                "El supervisor debería estar en modo vago.");
    }

    @Test
    void testProntuarioCreacion() {

        Empleado empleado = new Empleado("Carlos", "carlos@excusas.org", 60);
        SupervisorArea supervisor = new SupervisorArea("Martín", "martin@excusas.org", 2);
        ExcusaTrivial excusaTrivial = new ExcusaTrivial();
        Excusa excusa = new Excusa(empleado, "Perdi el bondi", excusaTrivial);

        Prontuario prontuario = new Prontuario(empleado, supervisor, excusa);


        assertEquals(empleado, prontuario.getEmpleado(), "El empleado debería coincidir en el prontuario.");
        assertEquals(supervisor, prontuario.getEncargado(), "El encargado debería coincidir en el prontuario.");
        assertEquals(excusa, prontuario.getExcusa(), "La excusa debería coincidir en el prontuario.");
    }
}