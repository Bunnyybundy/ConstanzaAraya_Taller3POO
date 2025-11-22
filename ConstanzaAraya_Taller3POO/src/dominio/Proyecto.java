package dominio;

import java.util.ArrayList;
import java.util.List;
/**
 * Clase que representa un proyecto dentro del sistema.
 * Contiene un ID, nombre, responsable y una lista de tareas.
 */
public class Proyecto {
	private String id;
	private String nombre;
	private String responsable;
	private List<Tarea> tareas = new ArrayList<>();
	
	public Proyecto(String id, String nombre, String responsable) {
		this.id = id;
		this.nombre = nombre;
		this.responsable = responsable;

	}
	/**
     * Obtiene el ID del proyecto.
     * @return id del proyecto
     */
	public String getId() {
		return id;
	}
	/**
     * Obtiene el nombre del proyecto.
     * @return nombre del proyecto
     */
	public String getNombre() {
		return nombre;
	}
	/**
     * Obtiene el responsable del proyecto.
     * @return responsable
     */
	public String getResponsable() {
		return responsable;
	}
	 /**
     * Obtiene la lista de tareas asociadas al proyecto.
     * @return lista de tareas
     */
	public List<Tarea> getTareas() {
		return tareas;
	}
	/**
     * Agrega una tarea al proyecto.
     * @param t tarea a agregar
     */
	public void agregarTarea( Tarea t) {
		tareas.add(t);
	}
	
	
}