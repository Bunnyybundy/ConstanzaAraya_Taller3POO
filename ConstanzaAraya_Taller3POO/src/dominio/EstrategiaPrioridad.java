package dominio;

import java.util.ArrayList;
/**
 * Interfaz que define la estrategia de ordenamiento de tareas.
 */
public interface EstrategiaPrioridad {
	/**
     * Ordena una lista de tareas según un criterio específico.
     * @param tareas lista de tareas
     */
	void ordenar(ArrayList<Tarea> tareas);
}
