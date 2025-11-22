package dominio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Clase Singleton que gestiona usuarios, proyectos y tareas.
 * Implementa lectura y escritura en archivos, aplicación de patrones
 * Strategy, Visitor y Factory.
 */
public class Sistema {
	private static Sistema instance;
	private static Scanner s;
	private static ArrayList<Usuario> usuarios = new ArrayList<>();
	private static ArrayList<Proyecto> proyectos = new ArrayList<>();
	private static ArrayList<Tarea> tareas = new ArrayList<>();
	
	private Sistema() {}
	
	/**
     * Obtiene la instancia única del sistema.
     * @return instancia de Sistema
     */
	public static Sistema getInstance() {
		if(instance == null) {
			instance = new Sistema();
			}
			return instance;
	}
	/**
     * Lee usuarios desde un archivo de texto.
     * @param archivo ruta del archivo
     */
	public static void leerUsuarios(String archivo) throws FileNotFoundException {
		s = new Scanner(new File(archivo));
		while(s.hasNextLine()) {
			String[] partes = s.nextLine().split("\\|");
			String nombreUsuario = partes[0];
			String contraseña = partes[1];
			String rol = partes[2];
			
			if(rol.equalsIgnoreCase("Administrador")) {
				usuarios.add(new Administrador(nombreUsuario, contraseña));
			}else {
				usuarios.add(new Colaborador(nombreUsuario, contraseña));
			}
		}
		s.close();
	}
	/**
     * Lee proyectos desde un archivo de texto.
     * @param archivo ruta del archivo
     */
	public static void leerProyectos(String archivo) throws FileNotFoundException {
		s = new Scanner(new File(archivo));	
		while(s.hasNextLine()) {
			String[] partes = s.nextLine().split("\\|");
			String id = partes[0];
			String nombreProyecto = partes[1];
			String responsable = partes[2];
			Proyecto p = new Proyecto(id, nombreProyecto, responsable);
			proyectos.add(p);
		}
	s.close();
	}
	/**
     * Lee tareas desde un archivo de texto.
     * @param archivo ruta del archivo
     */
	public static void leerTareas(String archivo) throws FileNotFoundException {
			s = new Scanner(new File(archivo));
			while(s.hasNextLine()) {
				String[] partes = s.nextLine().split("\\|");
				String proyectoId = partes[0];
				String id = partes[1];
				String tipo = partes[2];
				String descripcion = partes[3];
				String estado = partes[4];
				String responsable =partes[5];
				String complejidad = partes[6];
				LocalDate fecha = LocalDate.parse(partes[7]);
				
				Tarea t = TareaFactory.crearTarea(proyectoId, id, tipo, descripcion, estado, responsable, complejidad, fecha);
				tareas.add(t);
			}
			s.close();
	}

	public ArrayList<Usuario> getUsuarios() {
		 return usuarios; 
		 }
    public static ArrayList<Proyecto> getProyectos() {
    	return proyectos;
    	}
    public ArrayList<Tarea> getTareas() {
    	return tareas;
    	}
    /**
     * Aplica un Visitor sobre proyectos y tareas.
     */
	public static void aplicarVisitor() {
		Visitor v = new ContadorVisitor();
		for(Proyecto p: proyectos) {
			v.visitarProyecto(p);
			for(Tarea t: p.getTareas()) {
				v.visitarTarea(t);
			}
		}
		((ContadorVisitor) v).mostrarResultados();
	}
	/**
     * Actualiza el estado de una tarea.
     */
	public static void actualizarEstadoTarea(String u) {
		System.out.println("Id de la tarea a actualizar: ");
		String tareaId = s.nextLine();
		
		for(Tarea t: tareas) {
			if(t.getId().equals(tareaId) && t.getResponsable().equals(u)) {
				System.out.println("Estado actual: " + t.getEstado());
				System.out.println("Nueva estado(Pendiente/ En progreso / Completado): ");
				String nuevoEstado = s.nextLine();
				t.setEstado(nuevoEstado);
				System.out.println("Estado actualizado.");
				return;
			}
		}
		System.out.println("Tarea no encontrada.");
	}
	/**
     * Muestra las tareas asignadas a un usuario.
     */
	public static void verTareasAsignadas(String u) {
		for(Proyecto p: getProyectos()) {
			for(Tarea t : p.getTareas()) {
				if(t.getResponsable().equals(u)) {
					System.out.println("" + p.getId() + t.getId() + t.getDescripcion() + t.getEstado());
				}
			}
		}
	}
	/**
	 * Muestra en consola la lista de proyectos disponibles.
	 * Incluye ID, nombre y responsable de cada proyecto.
	 * Fuente de datos: colección interna de proyectos cargada desde archivos.
	 */
	public static void verProyectosDisponibles() {
		for(Proyecto p : getProyectos()) {
			System.out.println(p.getId() + "-" + p.getNombre());
		}
	}
	/**
     * Genera un reporte detallado de proyectos y tareas en reporte.txt.
     */
	public static void generarReporteProyectos() throws FileNotFoundException {
	try {	PrintWriter pw = new PrintWriter("Reportes.txt");
		for(Proyecto p: proyectos) {
			pw.println("Proyecto: " + p.getId() + " - " + p.getNombre() + " Responsable: " + p.getResponsable() +".");
			
			if(p.getTareas().isEmpty()) {
				pw.println(" [Sin tareas registradas] ");
			}else {
				for(Tarea t : p.getTareas()) {
					pw.println(" Tarea: " + t.getId() + " | Tipo: " + t.getTipo() + " | Descripcion: " + t.getDescripcion() + " |Estado: " + t.getEstado() + " | Responsable: " + t.getResponsable() + " | Complejidad: " + t.getComplejidad() + " | Fecha: " + t.getFecha());
				}
			}
			pw.println();
		}
		System.out.println(" Reporte generado en reporte.txt");
	}catch(Exception e) {
		System.out.println("Error al generar reporte: " + e.getMessage());
		}
	}
	
	/**
     * Asigna una estrategia de ordenamiento de tareas.
     */
	public static void asignarEstrategia() {
		System.out.println("Elige la estrategia: 1) Complejidad  2)Fecha  3)Tipo");
		int opcion = s.nextInt();
		s.nextLine();
		
		EstrategiaPrioridad estrategia;
		
		if(opcion == 1) {
			estrategia = new EstrategiaPorComplejidad();
		}else if(opcion == 2) {
			estrategia = new EstrategiaPorFecha();
		}else if(opcion == 3) {
			estrategia = new EstrategiaPorTipo();
		}else {
			System.out.println("Opcion invalida.");
			return;
		}
		
		estrategia.ordenar(tareas);
		System.out.println("Tareas ordenadas segun la estrategia elegida.");
	}
	/**
     * Elimina una tarea del sistema.
     */
	public static void eliminarTarea() {
		System.out.println("Id del proyecto: ");
		String proyectoId = s.nextLine();
		System.out.println("ID de la tarea: ");
		String tareaId = s.nextLine();
		
		Proyecto proyecto = null;
		for(Proyecto p : proyectos) {
			if(p.getId().equals(proyectoId)) {
				proyecto = p;
				break;
			}
		}
		if(proyecto == null) {
			System.out.println("Proyecto no encontrado.");
			return;
		}
		Tarea encontrada = null;
		for(Tarea t : proyecto.getTareas()) {
			if(t.getId().equals(tareaId)) {
				encontrada = t;
				break;
			}
		}
		if(encontrada != null) {
			proyecto.getTareas().remove(encontrada);
			tareas.remove(encontrada);
			System.out.println("Tarea eliminada.");
		}else {
			System.out.println("Tarea no encontrada");
		}
	}
	/**
     * Agrega una nueva tarea al sistema.
     */
	public static void agregarTarea() {
		System.out.println("ID del proyecto: ");
		String proyectoId = s.nextLine();
		
		Proyecto proyecto = null;
		for(Proyecto p : proyectos) {
			if(p.getId().equals(proyectoId)) {
				proyecto = p;
				break;
			}
		}
		if(proyecto == null) {
			System.out.println("Proyecto no encontrado.");
			return;
			
		}
		
		System.out.println("Id de la tarea: ");
		String id = s.nextLine();
		System.out.println("Tipo (Bug/Feature/Documentacion): ");
		String tipo = s.nextLine();
		System.out.println("Descripcion: ");
		String descripcion = s.nextLine();
		System.out.println("Estado: ");
		String estado = s.nextLine();
		System.out.println("Responsable: ");
		String responsable = s.nextLine();
		System.out.println("Complejidad: ");
		String complejidad = s.nextLine();
		System.out.println("Fecha (AAAA-MM-DD): ");
		String fecha = s.nextLine();
		
		for(Tarea t: tareas) {
			if(t.getResponsable().equals(responsable)&&t.getFecha().toString().equals(fecha)) {
				System.out.println("El responsable ya tiene una tarea en esa fecha.");
				return;
			}
		}
		Tarea nueva = TareaFactory.crearTarea(proyectoId, id, tipo, descripcion, estado, responsable, complejidad, LocalDate.parse(fecha));
		proyecto.agregarTarea(nueva);
		tareas.add(nueva);
		System.out.println("Tarea agregada correctamente.");
	}
	/**
	 * Muestra el listado de proyectos y permite eliminar uno seleccionado.
	 * Operación interactiva: solicita el ID y ejecuta la eliminación.
	 * Actualiza la colección interna de proyectos y tareas.
	 */
	public static void eliminarProyectos() {
		System.out.println("ID del proyecto a eliminar: ");
		String id = s.nextLine();
		
		Proyecto encontrado = null;
		for(Proyecto p : proyectos) {
			if(p.getId().equals(id)) {
				encontrado = p;
				break;
			}
		}
		if(encontrado != null) {
			proyectos.remove(encontrado);
			for(int i = 0; i< tareas.size();i++) {
				if(tareas.get(i).getProyectoId().equals(id)) {
					tareas.remove(i);
					i--;
				}
			}
			System.out.println("Proyecto y sus tareas eliminadas correctamente.");
		}else {
			System.out.println("Proyecto no encontrado.");
		}
	}
	/**
	 * Muestra un menú interactivo para agregar un nuevo proyecto.
	 * Solicita al usuario ingresar ID, nombre y responsable por consola.
	 * Crea el proyecto y lo añade a la lista interna.
	 *
	 * Efectos secundarios:
	 * - Modifica la lista global de proyectos.
	 * - Puede imprimir mensajes en consola.
	 */
	public static void agregarProyectos() {
		System.out.println("ID del proyecto: ");
		String id = s.nextLine();
		System.out.println("Nombre del proyecto: ");
		String nombre = s.nextLine();
		System.out.println("Responsable: ");
		String responsable = s.nextLine();
		
		Proyecto nuevo = new Proyecto(id, nombre, responsable);
		proyectos.add(nuevo);
		System.out.println("Proyecto agregado correctamente. ");
	}
	/**
	 * Muestra en consola todos los proyectos disponibles junto con sus tareas.
	 * 
	 * Para cada proyecto se imprime:
	 * - ID, nombre y responsable.
	 * - Lista de tareas asociadas con sus datos principales (ID, tipo, descripción, estado).
	 */
	public static void verProyectosTareas() {
		for(Proyecto p: getProyectos()) {
			System.out.println("Proyecto: " + p.getId() + "-" + p.getNombre() + " Responsable: " + p.getResponsable() + ")");
		for(Tarea t: p.getTareas()) {
			System.out.println(" Tarea: " + t.getId() + " - " + t.getTipo() + "-" + t.getDescripcion() + "- Estado" + t.getEstado() );
			}
		}
	}

}
