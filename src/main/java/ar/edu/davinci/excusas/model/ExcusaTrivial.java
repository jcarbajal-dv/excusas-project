package ar.edu.davinci.excusas.model;

import ar.edu.davinci.excusas.chain.Encargado;
import ar.edu.davinci.excusas.chain.ManejadorExcusas;

public class ExcusaTrivial extends TipoExcusa {

    @Override
    public boolean puedeSerManejadaPor(Encargado encargado){
        return manejadorExcusa.soyRecepcionista();
    }
}
