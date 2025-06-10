package ar.edu.davinci.excusas.excusa;

import ar.edu.davinci.excusas.encargado.Encargado;
import ar.edu.davinci.excusas.encargado.interfaces.ManejadorExcusa;
import ar.edu.davinci.excusas.excusa.interfaces.ITipoExcusa;

public class TipoExcusa implements ITipoExcusa {

    @Override
    public void hacerAlgoITE(Encargado encargado, Excusa excusa) {
        encargado.hacerAlgo(excusa);
    }


    @Override
    public boolean puedeSerManejadaPor(ManejadorExcusa manejadorExcusa) {
        return false;
    }
}
