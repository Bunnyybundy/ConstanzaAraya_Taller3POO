package dominio;
/**
 * Clase que representa un usuario administrador.
 * Hereda de Usuario y tiene permisos para gestionar proyectos y tareas.
 */
public class Administrador extends Usuario{

	public Administrador(String nombreUsuario, String constraseña) {
		super(nombreUsuario, constraseña, "Administrador");
		
	}


	
}


