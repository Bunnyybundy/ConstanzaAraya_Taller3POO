package dominio;

import java.util.ArrayList;
/**
 * Estrategia que ordena las tareas por nivel de complejidad.
 * Baja → Media → Alta.
 */
public class EstrategiaPorComplejidad implements EstrategiaPrioridad{
	private static int nivelComplejidad(String c) {
		if(c.equalsIgnoreCase("Baja")) {
			return 1;
		}
		if(c.equalsIgnoreCase("Media")) {
			return 2;
		}
		return 3;
	}
	@Override
	public void ordenar(ArrayList<Tarea> tareas) {
		for(int i = 0; i< tareas.size() - 1; i++) {
			for(int j = 0; j < tareas.size() - i - 1; j++) {
				if(nivelComplejidad(tareas.get(j).getComplejidad()) > nivelComplejidad(tareas.get(j + 1).getComplejidad())) {
					Tarea t = tareas.get(j);
					tareas.set(j, tareas.get(j + 1));
					tareas.set(j +1, t);
				}
			}
		}
	}

}
