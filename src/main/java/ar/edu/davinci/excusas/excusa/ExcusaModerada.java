package ar.edu.davinci.excusas.excusa;

import ar.edu.davinci.excusas.empleado.EmailSender;
import ar.edu.davinci.excusas.empleado.Encargado;
import ar.edu.davinci.excusas.empleado.interfaces.ManejadorExcusa;

public abstract class ExcusaModerada extends TipoExcusa {



    @Override
    public boolean puedeSerManejadaPor(ManejadorExcusa manejadorExcusa) {
        return manejadorExcusa.soySupervisorArea();
    }

    public void resolverExcusaModerada(Encargado encargado){};

}
