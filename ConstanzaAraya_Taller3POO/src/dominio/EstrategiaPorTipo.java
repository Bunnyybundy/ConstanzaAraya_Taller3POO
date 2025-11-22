package dominio;

import java.util.ArrayList;
/**
 * Estrategia que ordena las tareas por tipo.
 * Bug → Feature → Documentación.
 */
public class EstrategiaPorTipo implements EstrategiaPrioridad {
	private static int nivelTipo(String tipo) {
		if(tipo.equalsIgnoreCase("Bug")) {
			return 1;
		}if(tipo.equalsIgnoreCase("Feature")) {
			return 2;
		}
		return 3;
	}
	@Override
	public void ordenar(ArrayList<Tarea> tareas) {
		for(int i = 0 ; i < tareas.size() - 1; i++) {
			for(int j = 0; j < tareas.size() - i - 1; j++) {
				if(nivelTipo(tareas.get(j).getTipo()) > nivelTipo(tareas.get(j + 1).getTipo())) {
					Tarea t = tareas.get(j);
					tareas.set(j, tareas.get(j + 1));
					tareas.set(j + 1, t);
				}
			}
		}
	}

}
