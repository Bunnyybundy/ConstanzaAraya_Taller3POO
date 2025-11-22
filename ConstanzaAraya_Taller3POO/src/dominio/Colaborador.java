package dominio;
/**
 * Clase que representa un usuario colaborador.
 * Hereda de Usuario y tiene permisos para ejecutar tareas asignadas.
 */
public class Colaborador extends Usuario{

	public Colaborador(String nombreUsuario, String constraseña) {
		super(nombreUsuario, constraseña, "Colaborador");
		
	}

}