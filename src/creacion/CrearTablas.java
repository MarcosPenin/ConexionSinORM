package creacion;

import java.sql.SQLException;
import java.sql.Statement;

public class CrearTablas {
	   public static void crearTabla(Statement sentencia) {
	        try {
//	            sentencia.execute("DROP DATABASE IF EXISTS NUEVOINSTITUTO;");
	            sentencia.execute("CREATE DATABASE IF NOT EXISTS NUEVOINSTITUTO;");
	            sentencia.execute("USE INSTITUTO;");
	            sentencia.execute("CREATE TABLE IF NOT EXISTS PROFESORES"
	                    + "(dni VARCHAR(9) NOT NULL,"
	                    + "nombre VARCHAR(30) NOT NULL,"
	                    + "titulacion VARCHAR(30) NOT NULL,"
	                    + "PRIMARY KEY (dni))"
	                    + "ENGINE INNODB;");
	        
	            sentencia.execute("CREATE TABLE IF NOT EXISTS ALUMNOS"
	                    + "(idal int(4)  UNSIGNED ZEROFILL AUTO_INCREMENT NOT NULL ,"
	                    + "codigoAlumno VARCHAR(4) UNIQUE NOT NULL,"
	                    + "nombre varchar(30),"
	                    + "PRIMARY KEY (idal))"
	                    + "ENGINE INNODB;");

	            sentencia.execute("CREATE TABLE IF NOT EXISTS ASIGNATURAS"
	                    + "(idas int(4) UNSIGNED ZEROFILL AUTO_INCREMENT NOT NULL,"
	                    + "codigoAsignatura VARCHAR(4) NOT NULL UNIQUE,"
	                    + "nombreCiclo varchar(30),"
	                    + "PRIMARY KEY(idas))"
	                    + "ENGINE INNODB;");
	            
	            sentencia.execute("CREATE TABLE IF NOT EXISTS PROFESORESALUMNOSASIGNATURAS"
	                    + "(dni VARCHAR(9) NOT NULL,"
	                    + "idal int(4) NOT NULL,"
	                    + "idas int(4) NOT NULL,"
	                    + "PRIMARY KEY(idal,idas),"                
	                    + "FOREIGN KEY(idal) REFERENCES ALUMNOS(idal),"
	                    + "FOREIGN KEY (idas) REFERENCES ASIGNATURAS(idas),"
	                    + "FOREIGN KEY (dni) REFERENCES PROFESORES (dni))"                  
	                    + "ENGINE INNODB;");
	  
	            
	            sentencia.execute("CREATE TABLE IF NOT EXISTS NOTAS"
	                    + "(idal int not null,"
	                    + "idas int not null,"
	                    + "fecha date not null,"
	                    + "nota float not null,"
	                    + "PRIMARY KEY (idal,idas,fecha),"
	                    + "FOREIGN KEY(idal) REFERENCES ALUMNOS(idal),"
	                    + "FOREIGN KEY (idas) REFERENCES ASIGNATURAS(idas))"
	                    + "ENGINE INNODB;");

	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	            System.exit(5);

	        }
}}



