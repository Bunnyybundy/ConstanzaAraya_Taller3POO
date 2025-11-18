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
		if(instance == null) 
			instance = new Sistema();
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
    public ArrayList<Proyecto> getProyectos() {
    	return proyectos;
    	}
    public ArrayList<Tarea> getTareas() {
    	return tareas;
    	}

}
