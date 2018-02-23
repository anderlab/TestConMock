package tests;

import modelo.Alumno;
import modelo.AlumnoModelo;

public class AlumnoIO {
	
	public String  sumaNombres(int idAlumno){
		
		AlumnoModelo alumnoModelo=getAlumno();
		
		
		
		
		
		
		return null;
		
		
	}

	private AlumnoModelo getAlumno() {
		AlumnoModelo alumnoModelo= new JDBCAlumnoModelo();
		
		return alumnoModelo;
	}

}
