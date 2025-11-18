package dominio;

import java.time.LocalDate;

public class Bug extends Tarea{

	public Bug(String proyectoId, String id, String tipo, String descripcion, String estado, String responsable,
			String complejidad, LocalDate fecha) {
		super(proyectoId, id, tipo, descripcion, estado, responsable, complejidad, fecha);
		// TODO Auto-generated constructor stub
	}

}