package business;

public class Socio {
	private String nombre;
	private int edad;
	private String equipo;
	private String estadoCivil;
	private String nivelEstudios;
	
	public Socio(String nombre, int edad, String equipo, String estadoCivil, String nivelEstudios) {
		this.nombre = nombre;
		this.edad = edad;
		this.equipo = equipo;
		this.estadoCivil = estadoCivil;
		this.nivelEstudios = nivelEstudios;
		
	}

	public String getNombre() {
		return nombre;
	}

	public int getEdad() {
		return edad;
	}

	public String getEquipo() {
		return equipo;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public String getNivelEstudios() {
		return nivelEstudios;
	}
	
	
	
	
	

}
