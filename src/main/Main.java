package main;



import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

import conexion.Conexion;
import creacion.CrearTablas;
import operaciones.*;

public class Main {

	public static void main(String[] args) {

		Conexion conexion = Conexion.getInStance();
		CrearTablas.crearTabla(Conexion.sentencia);
		
		Statement stm=Conexion.sentencia;
	
		Insertar.insertarAlumno(stm);
		Modificar.modificarAlumno(stm);
		
		try {
			Consultar.notasAlumno(stm);
			Consultar.asignaturasProfesor(stm);
			Consultar.profesoresAsignatura(stm);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		Conexion.close();

	}

}
