package operaciones;


import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import vista.Mensajes;

public class Borrar {

	public static void borrarAlumno(Statement stm) {
		int idal = 1;
		String sql = "DELETE FROM ALUMNOS WHERE idal='" + idal + "'";

		try {
			stm.execute(sql);
			Mensajes.exito();
		} catch (SQLException e) {
			System.out.println("Error: Clase AlumnoDao, método eliminar");
			e.printStackTrace();
		}
	}

	public static void borrarAsignatura(Statement stm) {
		int idas = 2;

		String sql = "DELETE FROM ASIGNATURAS WHERE idas='" + idas + "'";
		try {
			stm.execute(sql);
			Mensajes.exito();
		} catch (SQLException e) {
			System.out.println("Error: Clase AsignaturaDao, método eliminar");
			e.printStackTrace();
		}
	}

	public static void eliminarMatricula(Statement stm) {

		int idal = 2;
		int idas = 2;
		String sql = "DELETE FROM profesoresalumnosasignaturas WHERE idal='" + idal + "' and idas='" + idas + "'";

		try {
			stm.execute(sql);
			Mensajes.exito();
		} catch (SQLException e) {
			System.out.println("Error: Clase MatriculaDao, método eliminar");
			e.printStackTrace();
		}
	}

	public static void eliminar(Statement stm) {

		int idal = 2;
		int idas = 2;
		Date fecha = null;

		String sql = "DELETE FROM notas WHERE idal='" + idal + "' and idas='" + idas + "' and fecha='" + fecha + "'";

		try {
			stm.execute(sql);
			Mensajes.exito();
		} catch (SQLException e) {
			System.out.println("Error: Clase NotaDao, método eliminar");
			e.printStackTrace();
		}
	}

    public static void eliminarProfesor(Statement stm) {
    	
    	String dni="39453677P";
   	
        String sql = "DELETE FROM PROFESORES WHERE dni='" + dni + "'";
        try {
            stm.execute(sql);
            Mensajes.exito();
        } catch (SQLException e) {
            System.out.println("Error: Clase ProfesorDao, método eliminar");
            e.printStackTrace();
        }
    }   
	
	
	
	
	
	
	
	
	
	
}
