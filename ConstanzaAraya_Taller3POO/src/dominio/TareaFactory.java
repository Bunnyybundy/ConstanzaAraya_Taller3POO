package dominio;

import java.time.LocalDate;
/**
 * Fábrica de tareas que crea instancias de Bug, Feature o Documentación
 * según el tipo especificado.
 */
public class TareaFactory {
	 /**
     * Crea una tarea según el tipo.
     * @param proyectoId id del proyecto
     * @param id id de la tarea
     * @param tipo tipo de tarea (Bug, Feature, Documentación)
     * @param descripcion descripción de la tarea
     * @param estado estado inicial
     * @param responsable responsable asignado
     * @param complejidad nivel de complejidad
     * @param fecha fecha de creación
     * @return instancia de Tarea
     */
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
