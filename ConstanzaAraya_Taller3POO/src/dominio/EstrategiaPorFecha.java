package dominio;

import java.util.ArrayList;
/**
 * Estrategia que ordena las tareas por fecha de creación.
 * Las más antiguas primero.
 */
public class EstrategiaPorFecha implements EstrategiaPrioridad {

	@Override
	public void ordenar(ArrayList<Tarea> tareas) {
		for(int i = 0; i < tareas.size() - 1; i++) {
			for( int j = 0; j < tareas.size() - i - 1; j++) {
				if(tareas.get(j).getFecha().isAfter(tareas.get(j+1).getFecha())) {
					Tarea t = tareas.get(j);
					tareas.set(j, tareas.get(j + 1));
					tareas.set(j + 1, t);
				}
			}
		}
		
	}

}
