package ar.edu.davinci.excusas.excusa.interfaces;

import ar.edu.davinci.excusas.encargado.Encargado;
import ar.edu.davinci.excusas.encargado.interfaces.ManejadorExcusa;
import ar.edu.davinci.excusas.excusa.Excusa;

public interface ITipoExcusa {

    public void hacerAlgoITE(Encargado encargado, Excusa excusa);

    public boolean puedeSerManejadaPor(ManejadorExcusa manejadorExcusa);

}
