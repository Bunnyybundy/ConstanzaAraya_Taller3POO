package dominio;
//Nombre: Constanza Fernanda Araya Plaza
//RUT: 21.609.057-8
//Carrera: Ingeniería Civil en Computación e Informática
import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Clase principal que inicia la ejecución del sistema.
 * Permite el login de usuarios y despliega menús según el rol.
 */
public class Main {
	private static Scanner s;
    /**
     * Método principal de ejecución del programa.
     * 
     * @param args argumentos de línea de comandos (no utilizados)
     * @throws FileNotFoundException si los archivos de datos no existen
     */
	public static void main(String[] args) throws FileNotFoundException {
		// Carga inicial de datos y login
		Sistema sistema = Sistema.getInstance();
		Sistema.leerUsuarios("usuarios.txt");
		Sistema.leerProyectos("proyectos.txt");
		Sistema.leerTareas("tareas.txt");
		
		s = new Scanner(System.in);
		System.out.println("Nombre de usuario: ");
		String usuario = s.nextLine();
		System.out.println("Contraseña: ");
		String contraseña = s.nextLine();
		
		Usuario encontrado = null;
		for(Usuario nombreUsuario: sistema.getUsuarios()) {
			if(nombreUsuario.getNombreUsuario().equals(usuario)&& nombreUsuario.getConstraseña().equals(contraseña)) {
				encontrado = nombreUsuario;
				break;
			}
		}
		
		if(encontrado == null) {
			System.out.println("Login invalido.");
			return;
		}
		
		System.out.println("Bienvenido " + encontrado.getNombreUsuario() + "(" + encontrado.getRol() + ")");
		if(encontrado.getRol().equalsIgnoreCase("Administrador")) {
			menuAdmin();
			
		}else {
			menuUsuario(encontrado);
		}
	}

	/**
     * Menú para el rol Administrador.
     * 
     * Opciones disponibles:
     * 1. Ver proyectos y tareas
     * 2. Agregar proyecto
     * 3. Eliminar proyecto
     * 4. Agregar tarea
     * 5. Eliminar tarea
     * 6. Asignar estrategia de ordenamiento
     * 7. Generar reporte de proyectos
     * 8. Salir del menú
     * 
     * @throws FileNotFoundException si ocurre error al acceder a archivos
     */
	private static void menuAdmin() throws FileNotFoundException {
		// Implementación del menú administrador
		s = new Scanner(System.in);
		int opcion;
		do {
		System.out.println("== Menú Administrador ==");
        System.out.println("1. Ver proyectos y tareas");
        System.out.println("2. Agregar proyecto");
        System.out.println("3. Eliminar proyecto");
        System.out.println("4. Agregar tarea");
        System.out.println("5. Eliminar tarea");
        System.out.println("6. Asignar Estrategia");
        System.out.println("7. Generar reporte de proyectos");
        System.out.println("8. Salir del menu");
        opcion = s.nextInt(); 
        s.nextLine();
        switch(opcion) {
        case 1:
        	Sistema.verProyectosTareas();
        	break;
        case 2:
        	Sistema.agregarProyectos();
        	break;
        case 3:
        	Sistema.eliminarProyectos();
        	break;
        case 4:
        	Sistema.agregarTarea();
        	break;
        case 5:
        	Sistema.eliminarTarea();
        	break;
        case 6:
        	Sistema.asignarEstrategia();
        	break;
        case 7:
        	Sistema.generarReporteProyectos();
        	break;
        case 8:
        	System.out.println("Saliendo del menu...");
        	break;
        default:
        	System.out.println("Opcion incorrecta...Intente nuevamente.");
        	
        }
		}while(opcion!= 8);
	}
	/**
     * Menú para el rol Usuario (Colaborador).
     * 
     * Opciones disponibles:
     * 1. Ver proyectos disponibles
     * 2. Ver tareas asignadas
     * 3. Actualizar estado de tarea
     * 4. Aplicar Visitor
     * 5. Salir del menú
     * 
     * @param u usuario autenticado que accede al menú
     */
	private static void menuUsuario(Usuario u) {
		// Implementación del menú usuario
		s = new Scanner(System.in);
		int opcion;
		do {
		System.out.println("== Menú Usuario ==");
        System.out.println("1. Ver proyectos disponibles.");
        System.out.println("2. Ver tareas asignadas.");
        System.out.println("3. Actualizar estado de tarea.");
        System.out.println("4. Aplicar Visitor.");
        System.out.println("5. Salir del menu.");
        opcion = s.nextInt(); 
        s.nextLine();
        switch(opcion) {
        case 1:
        	Sistema.verProyectosDisponibles();
        	break;
        case 2:
        	Sistema.verTareasAsignadas(u.getNombreUsuario());
        	break;
        case 3:
        	Sistema.actualizarEstadoTarea(u.getNombreUsuario());
        	break;
        case 4:
        	Sistema.aplicarVisitor();
        	break;
        case 5:
        	System.out.println("Saliendo del menu...");
        	break;
        default:
        	System.out.println("Opcion incorrecta...Intente nuevamente.");
        	
        }
		}while(opcion!= 5);
	}

	

}