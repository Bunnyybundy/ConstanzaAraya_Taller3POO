package dominio;
/**
 * Interfaz Visitor para aplicar operaciones sobre proyectos y tareas.
 */
public interface Visitor {
	void visitarProyecto(Proyecto p);
	void visitarTarea(Tarea t);
}
