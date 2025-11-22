package dominio;
/**
 * Visitor que cuenta tareas según su estado.
 * Pendiente, En progreso, Completada.
 */
public class ContadorVisitor implements Visitor{
	private int pendiente = 0;
	private int enProgreso = 0;
	private int completada = 0;
	@Override
	public void visitarProyecto(Proyecto p) {
		if (p == null) {
	        throw new IllegalArgumentException("El proyecto no puede ser nulo.");
	    }
	    // Recorre todas las tareas del proyecto y las visita
	    for (Tarea t : p.getTareas()) {
	        visitarTarea(t);
	    }
	}

	@Override
	public void visitarTarea(Tarea t) {
		if(t.getEstado().equalsIgnoreCase("Pendiente")) {
			pendiente++;
		}else if(t.getEstado().equalsIgnoreCase("En progreso")){
			enProgreso++;
		}else if(t.getEstado().equalsIgnoreCase("Completada")) {
			completada++;
		}
	}
	/**
     * Muestra los resultados del conteo de tareas.
     */
	public void mostrarResultados() {
		System.out.println("Tareas pendientes: " + pendiente);
		System.out.println("Tareas en progreso: " + enProgreso);
		System.out.println("Tareas completadas: " + completada);
	}

}
