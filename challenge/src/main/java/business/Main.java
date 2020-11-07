package business;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;

public class Main {
	
	public static Socio crearSocio(String[] line) {
		Socio s=new Socio(line[0],Integer.parseInt(line[1]),line[2],line[3],line[4]);
		return s;
	}
	
	public static List<Socio> oneByOne(Reader reader) throws Exception {
	    CSVReader csvReader = new CSVReader(reader);
	    String[] line;
	    List<Socio> socios = new ArrayList<Socio>();
	    while ((line = csvReader.readNext()) != null) {
	        socios.add(crearSocio(line));
	    }
	    reader.close();
	    csvReader.close();
	    return socios;
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Hola!");
		String path = System.getProperty("user.dir");
		String file = "/resources/socios.csv";
		
		try {
			FileReader archivo = new FileReader(new File(path+file));
			oneByOne(archivo);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("No se pudo leer el archivo");
		}
	}

}
