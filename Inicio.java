import javax.swing.*;

public class ListaTareas {

    public static void main(String[] args) {
        mostrarCaratula();
        mostrarMenuPrincipal();
    }

    public static void mostrarCaratula() {
        JOptionPane.showMessageDialog(null, "LISTA DE TAREAS:\nGrupo: Quesitos\nParalelo (1)\nAño: 2024");
    }

    public static void mostrarMenuPrincipal() {
        String[] opciones = {"Lista de Tareas", "Descripción de Tarea", "Salir"};
        int seleccion = JOptionPane.showOptionDialog(null, "Selecciona una opción", "Menú Principal",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);

        switch (seleccion) {
            case 0:
                mostrarListaTareas();
                break;
            case 1:
                mostrarDescripcionTarea();
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "¡Hasta luego!");
                System.exit(0);
                break;
            default:
                break;
        }
    }

    public static void mostrarListaTareas() {
        // Implementa la lógica para mostrar la lista de tareas
        JOptionPane.showMessageDialog(null, "Mostrar Lista de Tareas");
    }

    public static void mostrarDescripcionTarea() {
        // Implementa la lógica para mostrar la descripción de la tarea
        JOptionPane.showMessageDialog(null, "Mostrar Descripción de Tarea");
    }
}