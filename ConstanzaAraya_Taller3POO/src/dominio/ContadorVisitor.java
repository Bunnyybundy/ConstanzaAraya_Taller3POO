package dominio;

public class ContadorVisitor implements Visitor{
	private int pendiente = 0;
	private int enProgreso = 0;
	private int completada = 0;
	@Override
	public void visitarProyecto(Proyecto p) {
		// TODO Auto-generated method stub
		
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
	
	public void mostrarResultados() {
		System.out.println("Tareas pendientes: " + pendiente);
		System.out.println("Tareas en progreso: " + enProgreso);
		System.out.println("Tareas completadas: " + completada);
	}

}
