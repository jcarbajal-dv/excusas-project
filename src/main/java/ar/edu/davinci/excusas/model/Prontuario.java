package ar.edu.davinci.excusas.model;

public class Prontuario {
    private Empleado empleado;
    private String motivo;
    private int legajo;

    public Prontuario(Empleado empleado, MotivoExcusa motivo, int legajo) {
        this.empleado = empleado;
        this.motivo = getMotivo();
        this.legajo = legajo;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public String getMotivo() {
        return motivo;
    }

    public int getLegajo() {
        return legajo;
    }

    @Override
    public String toString() {
        return "Prontuario{" +
                "empleado=" + empleado.getNombre() +
                ", motivo='" + motivo + '\'' +
                ", legajo=" + legajo +
                '}';
    }
}
