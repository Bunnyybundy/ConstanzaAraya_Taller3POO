package dominio;

import java.time.LocalDate;

public class Bug extends Tarea{

	public Bug(String proyectoId, String id, String tipo, String descripcion, String estado, String responsable,
			String complejidad, LocalDate fecha) {
		super(proyectoId, id, "Bug", descripcion, estado, responsable, complejidad, fecha);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void aplicarAccion() {
		System.out.println("Bug → Afecta la criticidad del proyecto.");
	}

}