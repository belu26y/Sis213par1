package ProyectoTareas.logica;

public class Finalizada extends Tarea{
	private int duracion;

	public Finalizada() {
	}

	public Finalizada(int id_tarea, String nombre, String descripcion, String estado, String prioridad, String fecha, int duracion) {
		super(id_tarea, nombre, descripcion, estado, prioridad, fecha);
		this.duracion = duracion;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	
}
