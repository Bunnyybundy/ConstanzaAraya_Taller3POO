package dominio;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Sistema {
	private static Sistema instance;
	private static Scanner s;
	private static ArrayList<Usuario> usuarios = new ArrayList<>();
	private static ArrayList<Proyecto> proyectos = new ArrayList<>();
	private static ArrayList<Tarea> tareas = new ArrayList<>();
	
	private Sistema() {}
	
	public static Sistema getInstance() {
		if(instance == null) {
			instance = new Sistema();
			}
			return instance;
	}
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
				
				Tarea t;
				if(tipo.equalsIgnoreCase("Bug")) {
					t = new Bug(proyectoId, id, tipo,descripcion ,estado, responsable, complejidad, fecha);
				}else if(tipo.equalsIgnoreCase("Feature")) {
					t = new Feature (proyectoId, id, tipo,descripcion ,estado, responsable, complejidad, fecha);
				}else {
					t = new Documentacion(proyectoId, id, tipo,descripcion ,estado, responsable, complejidad, fecha);
					
				}
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

	public static void aplicarVisitor() {
		// TODO Auto-generated method stub
		
	}

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

	public static void verTareasAsignadas(String u) {
		for(Proyecto p: getProyectos()) {
			for(Tarea t : p.getTareas()) {
				if(t.getResponsable().equals(u)) {
					System.out.println("" + p.getId() + t.getId() + t.getDescripcion() + t.getEstado());
				}
			}
		}
	}

	public static void verProyectosDisponibles() {
		for(Proyecto p : getProyectos()) {
			System.out.println(p.getId() + "-" + p.getNombre());
		}
	}

	public static void generarReporteProyectos() {
		// TODO Auto-generated method stub
		
	}

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
		Tarea nueva;
		if(tipo.equalsIgnoreCase("Bug")) {
			nueva = new Bug(proyectoId, id,tipo, descripcion, estado, responsable,complejidad, LocalDate.parse(fecha));
		}else if(tipo.equalsIgnoreCase("Feature")) {
			nueva = new Feature(proyectoId, id,tipo, descripcion, estado, responsable,complejidad, LocalDate.parse(fecha));
		}else{
			nueva = new Documentacion(proyectoId, id,tipo, descripcion, estado, responsable,complejidad, LocalDate.parse(fecha));
			
		}
		proyecto.agregarTarea(nueva);
		tareas.add(nueva);
		System.out.println("Tarea agregada correctamente.");
	}

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

	public static void verProyectosTareas() {
		for(Proyecto p: getProyectos()) {
			System.out.println("Proyecto: " + p.getId() + "-" + p.getNombre() + " Responsable: " + p.getResponsable() + ")");
		for(Tarea t: p.getTareas()) {
			System.out.println(" Tarea: " + t.getId() + " - " + t.getTipo() + "-" + t.getDescripcion() + "- Estado" + t.getEstado() );
			}
		}
	}

}
