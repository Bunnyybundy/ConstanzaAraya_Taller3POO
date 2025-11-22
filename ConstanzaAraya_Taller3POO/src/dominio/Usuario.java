package dominio;
/**
 * Clase abstracta que representa un usuario del sistema.
 * Contiene nombre de usuario, contraseña y rol.
 * Se utiliza como base para Administrador y Colaborador.
 * 
 * @author Constanza Araya
 */
public abstract class Usuario {
	protected String NombreUsuario;
	protected String constraseña;
	protected String rol;
	

	public Usuario(String nombreUsuario, String constraseña, String rol) {
		this.NombreUsuario = nombreUsuario;
		this.constraseña = constraseña;
		this.rol = rol;
	}
	/**
     * Obtiene el nombre del usuario.
     * @return nombre de usuario
     */
	public String getNombreUsuario() {
		return NombreUsuario;
	}
	/**
     * Obtiene la contraseña del usuario.
     * @return contraseña
     */
	public String getConstraseña() {
		return constraseña;
	}
	/**
     * Obtiene el rol del usuario.
     * @return rol
     */
	public String getRol() {
		return rol;
	}
	
}
	
