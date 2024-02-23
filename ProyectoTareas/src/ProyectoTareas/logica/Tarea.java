package ProyectoTareas.logica;

public class Tarea {
	protected int id_tarea;
	protected String nombre;
	protected String descripcion;
	protected String estado;
	
	public Tarea() {
	}
	
	public Tarea(int id_tarea, String nombre, String descripcion, String estado) {
		super();
		this.id_tarea = id_tarea;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.estado = estado;
	}

	public int getId_tarea() {
		return id_tarea;
	}

	public void setId_tarea(int id_tarea) {
		this.id_tarea = id_tarea;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}
