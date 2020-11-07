package challenge;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import business.DatosSocios;
import business.Socio;

public class DatosSociosTest {
	
	private List<Socio> socios;
	
	@Before
	public void setUp() {
		socios = new ArrayList<Socio>();
		socios.add(new Socio("Mauro", 25, "Newells", "Soltero", "Universitario"));
		socios.add(new Socio("Fernando", 51, "River", "Casado", "Terciario"));
		socios.add(new Socio("Alejando", 39, "Racing", "Casado", "Secundario"));
		
	}
	
	@Test
	public void cantidadPersonasTest() {
		DatosSocios datos = new DatosSocios(socios);
		assertEquals(3, datos.cantSocios());
	}
	
	@Test
	public void cantidadPersonasVacioTest() {
		DatosSocios datos = new DatosSocios(new ArrayList<Socio>());
		assertEquals(0, datos.cantSocios());
	}
	
	@Test
	public void promedioEdadSociosRacingTest() {
		DatosSocios datos = new DatosSocios(socios);
		assertEquals(39, datos.promedioEdadSociosRacing());
	}
	/*
	@Test
	public void sociosCasadosEnOrdenTest() {
		List<Socio> socios = new ArrayList<Socio>();
		socios.add(new Socio("Mauro", 25, "Newells", "Soltero", "Universitario"));
		socios.add(new Socio("Fernando", 51, "River", "Casado", "Terciario"));
		socios.add(new Socio("Alejando", 39, "Racing", "Casado", "Secundario"));
	
		List<Socio> expected = new ArrayList<Socio>();
		expected.add(new Socio("Alejando", 39, "Racing", "Casado", "Secundario"));
		expected.add(new Socio("Fernando", 51, "River", "Casado", "Terciario"));
	
		DatosSocios datos = new DatosSocios(socios);
		assertEquals(expected, datos.sociosCasadosEnOrden());
	}
	*/
}
