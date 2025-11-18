package dominio;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	private static Scanner s;
	public static void main(String[] args) throws FileNotFoundException {
		
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
			menuUsuario();
		}
	}
	private static void menuAdmin() {
		System.out.println("== Menú Administrador ==");
        System.out.println("1. Ver proyectos y tareas");
        System.out.println("2. Agregar proyecto");
        System.out.println("3. Eliminar proyecto");
        System.out.println("4. Agregar tarea");
        System.out.println("5. Eliminar tarea");
        System.out.println("6. Asignar Estrategia");
        System.out.println("7. Generar reporte de proyectos");
	}
	private static void menuUsuario() {
		System.out.println("== Menú Usuario ==");
        System.out.println("1. Ver proyectos disponibles");
        System.out.println("2. Ver tareas asignadas");
        System.out.println("3. Actualizar estado de tarea");
        System.out.println("4. Aplicar Visitor");
	}

	

}