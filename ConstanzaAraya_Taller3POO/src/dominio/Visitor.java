package dominio;

public interface Visitor {
	void visitarProyecto(Proyecto p);
	void visitarTarea(Tarea t);
}
