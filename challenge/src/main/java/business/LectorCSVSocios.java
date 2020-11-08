package business;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import models.Socio;

public class LectorCSVSocios {
	
	private CSVReader reader;
	
	public LectorCSVSocios(String path){
		try {
			FileReader archivo = new FileReader(new File(path));
			reader = new CSVReader(archivo);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	public List<Socio> leerSocios() throws CsvValidationException, IOException{
	    String[] line;
	    List<Socio> socios = new ArrayList<Socio>();
	    while ((line = reader.readNext()) != null) {
	    	socios.add(crearSocio(line));
	    }
	    reader.close();
	    return socios;
	}
	
	private Socio crearSocio(String[] socioCSV) {
		String[] line = socioCSV[0].split(";");
		Socio socio=new Socio(line[0],Integer.parseInt(line[1]),line[2],line[3],line[4]);
		return socio;
	}

	
	

}
