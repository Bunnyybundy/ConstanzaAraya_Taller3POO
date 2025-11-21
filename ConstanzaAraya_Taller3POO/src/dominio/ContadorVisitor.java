package dominio;

public class ContadorVisitor implements Visitor{
	private int pendientes = 0;
	private int enProgreso = 0;
	private int completadas = 0;
	@Override
	public void visitarProyecto(Proyecto p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarTarea(Tarea t) {
		if(t.getEstado().equalsIgnoreCase("Pendientes")) {
			pendientes++;
		}else if(t.getEstado().equalsIgnoreCase("En progreso")){
			enProgreso++;
		}else if(t.getEstado().equalsIgnoreCase("Completada")) {
			completadas++;
		}
	}
	
	public void mostrarResultados() {
		System.out.println("Tareas pendientes: " + pendientes);
		System.out.println("Tareas en progreso: " + enProgreso);
		System.out.println("Tareas completadas: " + completadas);
	}

}
