package dominio;

import java.time.LocalDate;

public class Documentacion extends Tarea{

	public Documentacion(String proyectoId, String id, String tipo, String descripcion, String estado,
			String responsable, String complejidad, LocalDate fecha) {
		super(proyectoId, id, "Documentacion", descripcion, estado, responsable, complejidad, fecha);
		// TODO Auto-generated constructor stub
	}

}
