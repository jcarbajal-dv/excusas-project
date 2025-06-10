package ar.edu.davinci.excusas.empleado;

public class LineaDeManejador {

    public LineaDeManejador(){
        this.recepcionista = new Recepcionista("Lucas", "luks@excusas.org", 1),
                new SupervisorArea("Martin", "martincito@excusas.org", 2),
                new GerenteRRHH("Sarah", "sari@excusas.org", 3),
                new CEO("Laura", "lanumerouno@excusas.org", 4,
                        new Rechazador()))));
    }
}
