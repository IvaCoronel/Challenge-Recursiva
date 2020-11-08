package models;


public  class Socio implements Comparable<Socio> {
	private String nombre;
	private Integer edad;
	private String equipo;
	private String estadoCivil;
	private String nivelEstudios;
	
	public Socio(String nombre, Integer edad, String equipo, String estadoCivil, String nivelEstudios) {
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

	public int compareTo(Socio arg0) {
		if (edad.compareTo(arg0.edad)<0){
			return -1;
		}
		else if (edad.compareTo(arg0.edad)>0){
			return 1;
		}
		return 0;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((edad == null) ? 0 : edad.hashCode());
		result = prime * result + ((equipo == null) ? 0 : equipo.hashCode());
		result = prime * result + ((estadoCivil == null) ? 0 : estadoCivil.hashCode());
		result = prime * result + ((nivelEstudios == null) ? 0 : nivelEstudios.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Socio other = (Socio) obj;
		if (edad == null) {
			if (other.edad != null)
				return false;
		} else if (!edad.equals(other.edad))
			return false;
		if (equipo == null) {
			if (other.equipo != null)
				return false;
		} else if (!equipo.equals(other.equipo))
			return false;
		if (estadoCivil == null) {
			if (other.estadoCivil != null)
				return false;
		} else if (!estadoCivil.equals(other.estadoCivil))
			return false;
		if (nivelEstudios == null) {
			if (other.nivelEstudios != null)
				return false;
		} else if (!nivelEstudios.equals(other.nivelEstudios))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Socio [nombre=" + nombre + ", edad=" + edad + ", equipo=" + equipo + ", estadoCivil=" + estadoCivil
				+ ", nivelEstudios=" + nivelEstudios + "]";
	}
	
	
	
	

}
