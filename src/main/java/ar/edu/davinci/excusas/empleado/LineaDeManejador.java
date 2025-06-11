package ar.edu.davinci.excusas.empleado;

import ar.edu.davinci.excusas.empleado.interfaces.ManejadorExcusa;
import ar.edu.davinci.excusas.excusa.Excusa;

public class LineaDeManejador implements ManejadorExcusa {

    private Encargado recepcionista;

    public LineaDeManejador(){
        this.recepcionista = new Recepcionista("Lucas", "luks@excusas.org", 1,
                new SupervisorArea("Martin", "martincito@excusas.org", 2,
                new GerenteRRHH("Sarah", "sari@excusas.org", 3,
                new CEO("Laura", "lanumerouno@excusas.org", 4,
                        new Rechazador()))));
    }

    @Override
    public void manejarExcusa(Excusa excusa) {
        this.manejarExcusa(excusa);
    }
}
