package operaciones;

import java.sql.SQLException;
import java.sql.Statement;

import vista.Mensajes;



public class Modificar {

	
	
    public static void modificarAlumno(Statement stm) {

    	int codigo=1;
    	int codigoAlumno=1;
    	String nombre="ascsacsa";
    	int idal=1;
    	
        String sql = "UPDATE ALUMNOS SET codigoAlumno='" + codigo + "', nombre='"
                + nombre + "'" + " WHERE idal='" + idal + "'";

        try {
            stm.execute(sql);
            Mensajes.exito();
        } catch (SQLException e) {
            System.out.println("Error: Clase AlumnoDao, método actualizar");
        }
    }

	
	
	
}
