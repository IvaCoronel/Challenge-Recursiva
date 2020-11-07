package business;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatosSocios {
	private List<Socio> socios;
	
	public DatosSocios(List<Socio> socios){
		this.socios= socios;
	}
	
	public int cantSocios() {
		return socios.size();
	}

	public double promedioEdadSociosRacing() {
		ArrayList<Socio> sociosRacing=new ArrayList<Socio>();
		int edades= 0;
		double promedioEdad= 0;
		for(Socio socio: socios){
			if (socio.getEquipo().equals("Racing")){
				sociosRacing.add(socio);
			}		
		}
		for(Socio racing: sociosRacing){
			edades= edades + racing.getEdad();
		}
		promedioEdad= edades/sociosRacing.size();
		return promedioEdad;
	}

	public List<Socio> universitariosCasadosEnOrden() {
		ArrayList<Socio> universitariosCasados= new ArrayList <Socio>();
		for(Socio socio: socios){
			if ((socio.getEstadoCivil().equals("Casado")) && (socio.getNivelEstudios().equals("Universitario"))){
				if (universitariosCasados.size() < 100);
					universitariosCasados.add(socio);
			}
		}
		Collections.sort(universitariosCasados);
		
		//Por cada persona, mostrar: nombre, edad y equipo.
		
		return universitariosCasados;
	}
	
	public List<String> CincoNombresComunesRiver(){
		Map<String,Integer> nombresComunes= new HashMap<String,Integer>();
		for(Socio socio: socios){
			if(socio.getEquipo().equals("River")){
				if(nombresComunes.containsKey(socio.getNombre())){
					nombresComunes.put(socio.getNombre(), nombresComunes.get(socio.getNombre())+1);
				}
				else{
					nombresComunes.put(socio.getNombre(), 1);
				}
			}
		}
		
		
		
		return null;
	}
	
	/*
	int promedioEdad() {
		
		
	}
	*/

}
