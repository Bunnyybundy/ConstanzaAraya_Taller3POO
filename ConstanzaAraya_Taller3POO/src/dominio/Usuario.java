package dominio;

public abstract class Usuario {
	protected String NombreUsuario;
	protected String constraseña;
	protected String rol;
	

	public Usuario(String nombreUsuario, String constraseña, String rol) {
		this.NombreUsuario = nombreUsuario;
		this.constraseña = constraseña;
		this.rol = rol;
	}

	public String getNombreUsuario() {
		return NombreUsuario;
	}

	public String getConstraseña() {
		return constraseña;
	}

	public String getRol() {
		return rol;
	}
	
}
	
