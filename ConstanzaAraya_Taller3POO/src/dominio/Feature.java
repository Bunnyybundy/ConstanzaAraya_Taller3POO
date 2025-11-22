package dominio;

import java.time.LocalDate;

public class Feature extends Tarea{

	public Feature(String proyectoId, String id, String tipo, String descripcion, String estado, String responsable,
			String complejidad, LocalDate fecha) {
		super(proyectoId, id, "Feature", descripcion, estado, responsable, complejidad, fecha);
		
	}

	@Override
	public void aplicarAccion() {
		 System.out.println("Feature → Impacta en la estimación de tiempo.");
	}

}