package dominio;

import java.time.LocalDate;
/**
 * Clase que representa una tarea de tipo Documentación.
 * Mejora la calidad del proyecto.
 */
public class Documentacion extends Tarea{

	public Documentacion(String proyectoId, String id, String tipo, String descripcion, String estado,
			String responsable, String complejidad, LocalDate fecha) {
		super(proyectoId, id, "Documentacion", descripcion, estado, responsable, complejidad, fecha);
		
	}

	@Override
	public void aplicarAccion() {
		System.out.println("Documentación → Mejora la calidad del proyecto.");
	}

}
