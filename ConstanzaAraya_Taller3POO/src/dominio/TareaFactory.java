package dominio;

import java.time.LocalDate;

public class TareaFactory {
	public static Tarea crearTarea(String proyectoId, String id, String tipo,
            String descripcion, String estado,
            String responsable, String complejidad,
            LocalDate fecha) {
		if(tipo.equalsIgnoreCase("Bug")) {
			return new Bug(proyectoId, id,tipo, descripcion, estado,responsable, complejidad, fecha);
		}else if(tipo.equalsIgnoreCase("Feature")) {
			return new Feature(proyectoId, id,tipo, descripcion, estado,responsable, complejidad, fecha);
		}else {
			return new Documentacion(proyectoId, id,tipo, descripcion, estado,responsable, complejidad, fecha);
		}
	}
}
