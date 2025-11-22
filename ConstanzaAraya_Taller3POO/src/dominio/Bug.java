package dominio;

import java.time.LocalDate;
/**
 * Clase que representa una tarea de tipo Bug.
 * Afecta la criticidad del proyecto.
 */
public class Bug extends Tarea{

	public Bug(String proyectoId, String id, String tipo, String descripcion, String estado, String responsable,
			String complejidad, LocalDate fecha) {
		super(proyectoId, id, "Bug", descripcion, estado, responsable, complejidad, fecha);
		
	}

	@Override
	public void aplicarAccion() {
		System.out.println("Bug → Afecta la criticidad del proyecto.");
	}

}