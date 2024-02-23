package ProyectoTareas.logica;
import java.util.HashMap;

public class TablaHashTareas {
    protected HashMap<String, Tarea> tablaTareas;

    public TablaHashTareas() {
        tablaTareas = new HashMap<>();
    }

    public void agregarTarea(Tarea producto) {
        tablaTareas.put(producto.getNombre(), producto);
    }

    public Tarea buscarTarea(String nombre) {
        return tablaTareas.get(nombre);
    }
    
    public void eliminarTarea(String nombre) {
        tablaTareas.remove(nombre);
        if (tablaTareas.containsKey(nombre)) {
            Tarea tareaEliminado = tablaTareas.remove(nombre);
            tablaTareas.remove(tareaEliminado.getNombre());
            System.out.println("Tarea eliminada por nombre: " + tareaEliminado.getNombre());
        } else {
            System.out.println("No se encontró la tarea con el nombre: " + nombre);
        }
    }

    

    public void agregarProductoInterfaz(int id_tarea, String nombre, String descripcion, String estado, String prioridad, String fecha) {
        
        Tarea nuevaTarea = new Tarea(id_tarea, nombre, descripcion, estado, prioridad, fecha);

        agregarTarea(nuevaTarea);
    }
    
    public HashMap<String, Tarea> getTablaTarea() {
        return tablaTareas;
    }
    
}
