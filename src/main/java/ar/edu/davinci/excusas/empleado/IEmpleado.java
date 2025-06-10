package ar.edu.davinci.excusas.empleado;

import ar.edu.davinci.excusas.excusa.Excusa;
import ar.edu.davinci.excusas.excusa.TipoExcusa;

public interface IEmpleado {

    public String getNombre();
    public String getEmail();
    public int getLegajo();
    public Excusa presentarExcusa(String motivo, TipoExcusa tipoExcusa);

}
