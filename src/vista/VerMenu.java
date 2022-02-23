//package vista;
//
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.Scanner;
//
//import utilidades.ControlData;
//import utilidades.Menu;
//
//
//public class VerMenu {
//  
//    
//    
//    static Scanner sc = new Scanner(System.in);
//    static Menu menuTablas = new Menu(tablas());
//    static byte op;
//
//    public static void menuPrincipal(Statement s) {
//        Menu menuPrincipal = new Menu(opciones());
//        byte opMenu;
//        System.out.println("*********************************************************************");
//        System.out.println("****************************BIENVENIDO*********************** ");
//
//        do {
//            System.out.println("*********************************************************************");
//            System.out.println("Introduzca la opción que desee realizar:");
//            menuPrincipal.printMenu();
//            opMenu = ControlData.lerByte(sc);
//            switch (opMenu) {
//                case 1:
//                    menuInsertar(s);
//                    break;
//                case 2:
//                    menuBorrar(s);
//                    break;
//                case 3:
//                    menuModificar(s);
//                    break;
//                case 4:
//                    menuBuscar(s);
//                    break;
//                case 5:
//                    menuImprimir();
//                    break;
//                case 6:
//                    menuConsultas(s);
//                    break;
//            }
//        } while (opMenu != 7);
//    }
//
//    public static void menuInsertar(Statement s) {
//            System.out.println("*********************************************************************");
//            System.out.println("¿En qué tabla desea realizar la inserción?");
//            menuTablas.printMenu();
//            op = ControlData.lerByte(sc);
//            switch (op) {
//                case 1:
//                	RegistrarVista.registrarAlumno(s);
//                    break;
//                case 2:
//                    RegistrarVista.registrarProfesor(s);
//                    break;
//                case 3:
//                	 RegistrarVista.registrarAsignatura(s);
//                    break;
//                case 4:
//                	 RegistrarVista.registrarAsignatura(s);
//                    break;
//                case 5:
//                    NotaController.registrar(s);                                
//                    break;
//
//            }
//
//    }
//
//    public static void menuBorrar(Statement s) {
//            System.out.println("*********************************************************************");
//            System.out.println("¿En qué tabla desea realizar el borrado?");
//            menuTablas.printMenu();
//            op = ControlData.lerByte(sc);
//            switch (op) {
//                case 1:
//                    ProfesorController.eliminar();
//                    break;
//                case 2:
//                    AlumnoController.eliminar();
//                    break;
//                case 3:
//                    AsignaturaController.eliminar();
//                    break;
//                case 4:
//                    MatriculaController.eliminar();
//                    break;
//                case 5:                    
//                    NotaController.eliminar();
//                    break;
//            }
//
//    }
//
//    public static void menuModificar(Statement s) {
//            System.out.println("*********************************************************************");
//            System.out.println("¿En qué tabla desea actualizar los datos?");
//            menuTablas.printMenu();
//            op = ControlData.lerByte(sc);
//            switch (op) {
//                case 1:
//                    ProfesorController.actualizar();
//                    break;
//                case 2:
//                    AlumnoController.actualizar();
//                    break;
//                case 3:
//                    AsignaturaController.actualizar();
//                    break;
//                case 4:
//                    MatriculaController.actualizar();
//                    break;
//                case 5:
//                    NotaController.actualizar();
//                    break;
//            }
//    }
//
//    public static void menuBuscar(Statement s) {
//            System.out.println("*********************************************************************");
//            System.out.println("¿Qué desea buscar?");
//            menuTablas.printMenu();
//            op = ControlData.lerByte(sc);
//            switch (op) {
//                case 1:
//                    ProfesorController.buscar();
//                    break;
//                case 2:
//                    AlumnoController.buscar();
//                    break;
//                case 3:
//                    AsignaturaController.buscar();
//                    break;
//                case 4:
//                    MatriculaController.buscar();
//                    break;
//                case 5:
//                    NotaController.buscar();
//                    break;
//            }
//    }
//
//    public static void menuImprimir(Statement s) {
//            System.out.println("*********************************************************************");
//            System.out.println("¿Qué tabla quiere imprimir?");
//            menuTablas.printMenu();
//            op = ControlData.lerByte(sc);
//            switch (op) {
//                case 1:
//                    ProfesorController.obtener();
//                    break;
//                case 2:
//                    AlumnoController.obtener();
//                    break;
//                case 3:
//                    AsignaturaController.obtener();
//                    break;
//                case 4:
//                    MatriculaController.obtener();
//                    break;
//                case 5:
//                    NotaController.obtener();
//                    break;
//            }
//    }
//    
//    public static void menuConsultas(Statement s){
//         Menu menuConsultas = new Menu(consultas());
//        byte op2;
//        menuConsultas.printMenu();
//         op2 = ControlData.lerByte(sc);
//            switch (op2) {
//                case 1:
//                    ProfesorController.verAsignaturas();
//                    break;
//                case 2:
//                    AlumnoController.verNotas();
//                    break;
//                case 3:
//                    AsignaturaController.verProfesores();
//                    break;
//            }
//    
//    }
//    
//    
//
//    static ArrayList<String> opciones() {
//        ArrayList<String> opciones = new ArrayList<String>();
//        opciones.add("Inserción de nuevas filas");
//        opciones.add("Borrar filas");
//        opciones.add("Modificar filas");
//        opciones.add("Buscar");
//        opciones.add("Imprimir tabla");
//        opciones.add("Otras consultas");
//        opciones.add("Salir");
//        return opciones;
//    }
//
//    static ArrayList<String> tablas() {
//        ArrayList<String> opciones = new ArrayList<String>();
//        opciones.add("Profesores");
//        opciones.add("Alumnos");
//        opciones.add("Asignaturas");
//        opciones.add("Matrículas");
//        opciones.add("Notas");
//        opciones.add("Volver");
//        return opciones;
//    }
//    
//        static ArrayList<String> consultas() {
//        ArrayList<String> opciones = new ArrayList<String>();
//        opciones.add("Ver las asignaturas de un profesor");
//        opciones.add("Ver las notas de un alumno");
//        opciones.add("Ver los profesores de una asignatura");
//        opciones.add("Volver");
//        return opciones;
//    }

//}
