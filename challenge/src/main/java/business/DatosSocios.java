package business;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
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
				if (universitariosCasados.size() <= 100);
					universitariosCasados.add(socio);
			}
		}
		Collections.sort(universitariosCasados);
		
		//Por cada persona, mostrar: nombre, edad y equipo.
		
		return universitariosCasados;
	}
	
	
	public List<String> cincoNombresComunesRiver(){
		Map<String,Integer> nombresComunes= new HashMap<String,Integer>();
		List<String> cincoNombres= new ArrayList<String>();
		List<Map.Entry<String, Integer> > nombresRiver = new LinkedList<Map.Entry<String, Integer>>();
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
		//sort
		nombresRiver= ordenarPorValue(nombresComunes);
		
		int i=1;
		while(i <nombresRiver.size()+1 && i<7){
			cincoNombres.add(nombresRiver.get(nombresRiver.size()-i).getKey());
			i++;
		}
		return cincoNombres;
	}
	
	
	private List<Map.Entry<String, Integer>> ordenarPorValue(Map<String,Integer> ordenada){
		List<Map.Entry<String, Integer>> nombresRiver = new LinkedList<Map.Entry<String, Integer>>(ordenada.entrySet()); 
		Collections.sort(nombresRiver, new Comparator<Map.Entry<String, Integer> >() { 
	            public int compare(Map.Entry<String, Integer> o1,  
	                               Map.Entry<String, Integer> o2) 
	            { 
	                return (o1.getValue()).compareTo(o2.getValue()); 
	            } 
	    }); 
		return nombresRiver;
	}
	
	public List<ArrayList<String>> sociosPorEquipo(){
		Map<String,Integer> cantSociosEquipo= new HashMap<String,Integer>();
		List<Map.Entry<String, Integer>> cantSociosOrdenada = new LinkedList<Map.Entry<String, Integer>>();
		for(Socio socio: socios){
			if(cantSociosEquipo.containsKey(socio.getEquipo())){
				cantSociosEquipo.put(socio.getEquipo(),cantSociosEquipo.get(socio.getEquipo())+1);
			}
			else{
				cantSociosEquipo.put(socio.getNombre(), 1);
			}
		}
		cantSociosOrdenada= ordenarPorValue(cantSociosEquipo);
		
		return null;
	}
	


}
