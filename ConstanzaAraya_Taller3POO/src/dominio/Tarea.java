package dominio;

import java.time.LocalDate;

public abstract class Tarea {
	protected String proyectoId;
	protected String id;
	protected String tipo;
	protected String descripcion;
	protected String estado;
	protected String responsable;
	protected String complejidad;
	protected LocalDate fecha;
	
	public Tarea(String proyectoId, String id, String tipo, String descripcion, String estado, String responsable,
			String complejidad, LocalDate fecha) {
		this.proyectoId = proyectoId;
		this.id = id;
		this.tipo = tipo;
		this.descripcion = descripcion;
		this.estado = estado;
		this.responsable = responsable;
		this.complejidad = complejidad;
		this.fecha = fecha;
	}
	
	public String getProyectoId() {
		return proyectoId;
	}

	public String getId() {
		return id;
	}

	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getResponsable() {
		return responsable;
	}

	public String getComplejidad() {
		return complejidad;
	}

	public void setComplejidad(String complejidad) {
		this.complejidad = complejidad;
	}

	public LocalDate getFecha() {
		return fecha;
	}
	
	public abstract void aplicarAccion();
	
	
}