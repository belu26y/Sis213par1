package ProyectoTareas.logica;

public class FinalizadasBD {
	
	private int id_final;
	private String duracion;
	private int id_tarea;
	
	public FinalizadasBD() {
	}
	
	public FinalizadasBD(int id_final, String duracion, int id_tarea) {
		
		this.id_final = id_final;
		this.duracion = duracion;
		this.id_tarea = id_tarea;
	}

	public int getId_final() {
		return id_final;
	}

	public void setId_final(int id_final) {
		this.id_final = id_final;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public int getId_tarea() {
		return id_tarea;
	}

	public void setId_tarea(int id_tarea) {
		this.id_tarea = id_tarea;
	}
	
	
	
}
