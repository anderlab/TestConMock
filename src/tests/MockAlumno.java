package tests;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Alumno;
import modelo.AlumnoModelo;
import modelo.Conector;
import modelo.Config;

public class MockAlumno  {
	
	ArrayList <Alumno> listaAlumnos;
	boolean falloConexion;
	
	public MockAlumno(boolean falloConexion){
		
		listaAlumnos= new ArrayList <Alumno>();
		this.falloConexion=falloConexion;
		
	}
	
	private void compuebaConexion() throws IOException{
		if(falloConexion){
			throw new IOException("Fallo al conextar a la BBDD");
		}
	}

	
	public ArrayList<Alumno> selectAll() throws IOException {
		this.compuebaConexion();
		return listaAlumnos;
	}



	public void insertar(Alumno alumno) throws IOException {
		this.compuebaConexion();
		if(this.selectPorId(alumno.getId())==null){
			listaAlumnos.add(alumno);
			
		}else{
			throw new IOException("El empleado ya existe en la base de datos");
		}
		

	}

	public Alumno selectPorId(int id) throws IOException {

		this.compuebaConexion();

			for (Alumno alumno: listaAlumnos) {
				if(alumno.getId()==id){
					return alumno;
				}
			}

	
		return null;

	}
}
