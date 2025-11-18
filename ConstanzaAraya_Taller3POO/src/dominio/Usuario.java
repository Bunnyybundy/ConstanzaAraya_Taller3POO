package dominio;

public abstract class Usuario {
	protected String NombreUsuario;
	protected String constraseña;
	protected String rol;
	

	public Usuario(String nombreUsuario, String constraseña) {
		this.NombreUsuario = nombreUsuario;
		this.constraseña = constraseña;
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
	
