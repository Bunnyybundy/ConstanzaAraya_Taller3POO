package dominio;

import java.time.LocalDate;
/**
 * Clase abstracta que representa una tarea dentro de un proyecto.
 * Contiene atributos como id, tipo, descripción, estado, responsable,
 * complejidad y fecha.
 */
public abstract class Tarea {
	protected String proyectoId;
	protected String id;
	protected String tipo;
	protected String descripcion;
	protected String estado;
	protected String responsable;
	protected String complejidad;
	protected LocalDate fecha;
	/**
     * Constructor de la clase Tarea.
     *
     */
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
	/**
     * Obtiene el ID del proyecto al que pertenece la tarea.
     * @return id del proyecto
     */
	public String getProyectoId() {
		return proyectoId;
	}
	/**
     * Obtiene el ID de la tarea.
     * @return id de la tarea
     */
	public String getId() {
		return id;
	}
	/**
     * Obtiene el tipo de la tarea.
     * @return tipo de tarea
     */
	public String getTipo() {
		return tipo;
	}
	/**
     * Cambia el tipo de la tarea.
     * @param tipo nuevo tipo de tarea
     */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	 /**
     * Obtiene la descripción de la tarea.
     * @return descripción
     */
	public String getDescripcion() {
		return descripcion;
	}
	 /**
     * Obtiene el estado actual de la tarea.
     * @return estado
     */
	public String getEstado() {
		return estado;
	}
	 /**
     * Cambia el estado de la tarea.
     * @param estado nuevo estado
     */
	public void setEstado(String estado) {
		this.estado = estado;
	}
	/**
     * Obtiene el responsable asignado a la tarea.
     * @return responsable
     */
	public String getResponsable() {
		return responsable;
	}
	/**
     * Obtiene el nivel de complejidad de la tarea.
     * @return complejidad
     */
	public String getComplejidad() {
		return complejidad;
	}
	/**
     * Cambia el nivel de complejidad de la tarea.
     * @param complejidad nueva complejidad
     */
	public void setComplejidad(String complejidad) {
		this.complejidad = complejidad;
	}
	/**
     * Obtiene la fecha de creación de la tarea.
     * @return fecha
     */
	public LocalDate getFecha() {
		return fecha;
	}
	 /**
     * Método abstracto que aplica una acción según el tipo de tarea.
     * Debe ser implementado por las subclases (Bug, Feature, Documentación).
     */
	public abstract void aplicarAccion();
	
	
}