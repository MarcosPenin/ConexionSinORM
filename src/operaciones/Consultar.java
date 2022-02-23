package operaciones;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Consultar {

	public static void notasAlumno(Statement s) throws IOException, SQLException {

		int idal = 1;

		ResultSet notas = s.executeQuery(
				"SELECT N.NOTA, A.NOMBRECICLO, A.IDAS FROM NOTAS AS N INNER JOIN ASIGNATURAS AS A ON N.IDAS=A.IDAS WHERE N.IDAL='"
						+ idal + "'");

		if (notas.first()) {
			System.out.println("Notas del alumno de ID " + idal + ":");
			System.out.printf("%-4s %-50s %-6s %n", "ID", "Asignatura", "Nota");
			notas.previous();
			while (notas.next()) {
				System.out.printf("%-4s %-50s %-4.2f %n", notas.getInt("A.IDAS"), notas.getString("A.NOMBRE"),
						notas.getFloat("N.NOTA"));
			}
		} else {
			System.out.println("Ese alumno no tiene ninguna nota registrada.");

			notas.close();
		}
	}

	public static void asignaturasProfesor(Statement s) throws IOException, SQLException {
		String dni = "39494949P";

		if (Recursos.buscarProfesor(s, dni) != 0) {
			ResultSet asignaturas = s.executeQuery(
					"SELECT DISTINCT APA.IDAS, A.NOMBRECICLO FROM PROFESORESALUMNOSASIGNATURAS AS APA INNER JOIN ASIGNATURAS AS A ON APA.IDAS=A.IDAS WHERE APA.DNI = '"
							+ dni + "'");
			if (asignaturas.first()) {
				System.out.println("Asignaturas del profesor de DNI " + dni + ": ");
				asignaturas.previous();
				while (asignaturas.next()) {
					System.out.println(" - " + asignaturas.getString("A.NOMBRECICLO"));
				}
			} else {
				System.out.println("Ese profesor no imparte ninguna asignatura.");
			}
			asignaturas.close();
		}else {
			System.out.println("No hay ningún profesor con DNI " + dni);}
	}
	

	public static void profesoresAsignatura( Statement s) throws IOException, SQLException {
        
        int id = 1;
        
        if(Recursos.buscarAsignatura(s, id)!=0){
            ResultSet profesores = s.executeQuery("SELECT DISTINCT P.NOMBRE FROM PROFESORES AS P INNER JOIN PROFESORESALUMNOSASIGNATURAS AS APA ON P.DNI=APA.DNI WHERE APA.IDAS='"+id+"'");
            if(profesores.first()){
                    System.out.println("Profesores que imparten la asignatura de ID "+id+": ");
                    profesores.previous();
                    while(profesores.next()){
                        System.out.println(" - "+profesores.getString("P.NOMBRE"));
                    }
                }else{
                    System.out.println("Esa asignatura no es impartida por ningún profesor.");
                }
        }else{
            System.out.println("No hay ningúna asignatura con ese ID.");
        }
}}