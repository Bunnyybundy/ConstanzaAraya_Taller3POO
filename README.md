# Taller 3 en Programacion Orientada a Objetos

## 📌 Descripción
Este proyecto implementa un **sistema de gestión de proyectos y tareas** en Java, aplicando conceptos de **herencia, polimorfismo, interfaces** y varios **patrones de diseño**.  
El sistema permite a **administradores** y **colaboradores** interactuar mediante un menú de opciones, gestionando proyectos y tareas con persistencia en archivos de texto.

---

## 🎯 Objetivos del taller
- Diseñar un **modelo de dominio** y diagrama UML consistente con la implementación en Java.
- Implementar **herencia, polimorfismo e interfaces** en un sistema orientado a objetos.
- Aplicar patrones de diseño:
  - **Singleton**: garantizar una única instancia del sistema.
  - **Factory**: centralizar la creación de tareas (`Bug`, `Feature`, `Documentacion`).
  - **Strategy**: ordenar tareas según diferentes criterios (fecha, complejidad, tipo).
  - **Visitor**: recorrer proyectos y tareas para aplicar operaciones adicionales (ej. contar tareas por estado).
- Implementar **persistencia en archivos de texto** para lectura y escritura de proyectos, tareas y usuarios.

---

## 🏗️ Modelo de dominio
- **Usuario (abstracta)**  
  - Subclases: `Administrador`, `Colaborador`.
- **Proyecto**  
  - Contiene una lista de `Tarea`.
- **Tarea (abstracta)**  
  - Subclases: `Bug`, `Feature`, `Documentacion`.
- **Sistema (Singleton)**  
  - Gestiona usuarios, proyectos y tareas.
- **Interfaces y patrones**  
  - `EstrategiaPrioridad` (Strategy).  
  - `Visitor` (Visitor).  
  - `TareaFactory` (Factory).

---

## ⚙️ Funcionalidades principales

### 👨‍💼 Menú Administrador
1. Ver proyectos y tareas.  
2. Agregar proyecto.  
3. Eliminar proyecto.  
4. Agregar tarea.  
5. Eliminar tarea.  
6. Asignar estrategia de ordenamiento (Strategy).  
7. Generar reporte de proyectos (`reporte.txt`).  
8. Salir.

### 👩‍💻 Menú Usuario
1. Ver proyectos disponibles.  
2. Ver tareas asignadas.  
3. Actualizar estado de tarea.  
4. Aplicar Visitor (conteo de tareas por estado).  
5. Salir.

---

## 📂 Persistencia en archivos
- **usuarios.txt** → lista de usuarios con rol.  
- **proyectos.txt** → lista de proyectos con responsable.  
- **tareas.txt** → lista de tareas asociadas a proyectos.  
- **reporte.txt** → archivo generado con información detallada de proyectos y sus tareas.

---

## 🛠️ Patrones de diseño aplicados
- **Singleton**: clase `Sistema` con `getInstance()`.  
- **Factory**: clase `TareaFactory` para crear instancias de tareas.  
- **Strategy**: clases `EstrategiaPorFecha`, `EstrategiaPorComplejidad`, `EstrategiaPorTipo`.  
- **Visitor**: interfaz `Visitor` y clase `ContadorVisitor`.

---

## 🚀 Ejecución
1. Compilar todas las clases en el paquete `dominio`.  
2. Ejecutar `Main`.  
3. Ingresar usuario y contraseña desde `usuarios.txt`.  
4. Usar el menú según el rol (Administrador o Colaborador).  
5. Los cambios se reflejan en los archivos de texto y en el reporte generado.

---

## 📖 Ejemplo de reporte generado
Proyecto: PR001 - Plataforma de E-commerce (Responsable: admin1) 
Tarea: T001 | Tipo: Bug | Descripción: Error en el login de usuarios | Estado: Pendiente | Responsable: colab1 | Complejidad: Alta | Fecha: 2025-08-01 
Tarea: T002 | Tipo: Feature | Descripción: Agregar carrito de compras | Estado: Pendiente | Responsable: colab2 | Complejidad: Media | Fecha: 2025-08-01 
Tarea: T003 | Tipo: Documentacion | Descripción: Redactar manual de usuario | Estado: En progreso | Responsable: colab1 | Complejidad: Baja | Fecha: 2025-08-02
