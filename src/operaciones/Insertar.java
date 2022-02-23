package operaciones;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.Scanner;

import vista.Mensajes;

public class Insertar {
	static Scanner sc = new Scanner(System.in);

	public static void insertarAlumno(Statement stm) {

		int idal=sc.nextInt();
		String codigoAlumno="ascascs";
		String nombre="ascsa";
		
		String sql = "INSERT INTO alumnos (idal,codigoAlumno,nombre) values ('" + idal + "','"
				+ codigoAlumno + "','" + nombre + "')";
		try {
			stm.execute(sql);
			Mensajes.exito();
		} catch (SQLIntegrityConstraintViolationException e) {
			System.out.println("No se puede guardar ese alumno");
		} catch (SQLException e) {
			System.out.println("Error: Clase AlumnoDao, método registrar" + e);
		}
	}

	public static void insertarProfesor(Statement stm) {

		String dni="39453678P";
		String nombre="Juana";
		String titulacion="Historia";
	

		String sql = "INSERT INTO profesores (dni,nombre,titulacion) values ('" + dni+ "','"
				+ nombre + "','" + titulacion + "')";
		try {		
			stm.execute(sql);
			Mensajes.exito();
//        } catch (DniInvalido e) {
//            System.out.println("No se ha podido guardar, el DNI no es válido");
//        } catch (SQLIntegrityConstraintViolationException e) {
			System.out.println("No se ha podido guardar, ya existe otro registro con ese mismo DNI");
		} catch (SQLException e) {
			System.out.println("Error: Clase ProfesorDao, método registrar" + e);
		}

	}

	
	    }
	



	