package business;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import models.Socio;

public class BuscadorSocios {
	private List<Socio> socios;
	
	
	public BuscadorSocios(List<Socio> socios){
		this.socios= socios;
	}
	
	public int cantSocios() {
		return socios.size();
	}

	public String promedioEdadSociosRacing() {
		return String.format("%.1f",promedioEdadSociosEquipo("Racing") );
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
		while(i <nombresRiver.size()+1 && i<6){
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
	
	public List<ArrayList<String>> estadisticasEquipo(){
		Map<String,Integer> cantSociosEquipo= new HashMap<String,Integer>();
		List<Map.Entry<String, Integer>> cantSociosOrdenada = new LinkedList<Map.Entry<String, Integer>>();
		List<ArrayList<String>> promedioEdadMinMax=new ArrayList<ArrayList<String>>();
		double promedio = 0;
		
		for(Socio socio: socios){
			if(cantSociosEquipo.containsKey(socio.getEquipo())){
				cantSociosEquipo.put(socio.getEquipo(),cantSociosEquipo.get(socio.getEquipo())+1);
			}
			else{
				cantSociosEquipo.put(socio.getEquipo(), 1);
			}
		}
		cantSociosOrdenada= ordenarPorValue(cantSociosEquipo);
		
		for(int i=0; i<cantSociosOrdenada.size();i++){
			List<String> equipo= new ArrayList<String>();
			List<String> minMax= new ArrayList<String>();
		
			equipo.add(cantSociosOrdenada.get(i).getKey()); // agrego equipo
			equipo.add(String.valueOf(cantSociosOrdenada.get(i).getValue())); //agrego cant socios
			
			promedio= promedioEdadSociosEquipo(cantSociosOrdenada.get(i).getKey());
			equipo.add(String.format("%.1f", promedio));   // agrego promedio
			
			minMax= edadMinMax(cantSociosOrdenada.get(i).getKey());
			equipo.add(minMax.get(0)); //agrego edad minima
			equipo.add(minMax.get(1)); //agrego edad maxima
			
			promedioEdadMinMax.add((ArrayList<String>) equipo);
		}
		Collections.reverse(promedioEdadMinMax);
		
		return promedioEdadMinMax;
	}
	
	private List<String> edadMinMax(String equipo) {
		int min=Integer.MAX_VALUE;
		int max=Integer.MIN_VALUE;
		for(Socio socio: socios){
			if(socio.getEquipo().equals(equipo)){
				if(socio.getEdad()<min){
					min=socio.getEdad();
				}
				if (socio.getEdad()>max){
					max=socio.getEdad();
				}
			}
		}
		List<String> minMax= new ArrayList<String>();
		minMax.add(String.valueOf(min));
		minMax.add(String.valueOf(max));
		return minMax;
	}

	private double promedioEdadSociosEquipo(String equipo) {
		double edades= 0;
		int cont=0;
		for(Socio socio: socios){
			if (socio.getEquipo().equals(equipo)){
				edades= edades + socio.getEdad();
				cont++;
			}		
		}
		return edades/cont;
	}

}
