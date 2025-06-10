package ar.edu.davinci.excusas.empleado;


import ar.edu.davinci.excusas.empleado.interfaces.IEmpleado;
import ar.edu.davinci.excusas.excusa.Excusa;
import ar.edu.davinci.excusas.excusa.TipoExcusa;

public class Empleado implements IEmpleado {
    private String nombre;
    private String email;
    private int legajo;

    public Empleado(String nombre, String email, int legajo) {
        this.nombre = nombre;
        this.email = email;
        this.legajo = legajo;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public String getEmail() { return email; }
    @Override
    public int getLegajo() { return legajo; }


    @Override
    public Excusa presentarExcusa(String razon, TipoExcusa tipoExcusa) {
        Excusa excusa = new Excusa(this, razon, tipoExcusa);
        return excusa;
    }
}