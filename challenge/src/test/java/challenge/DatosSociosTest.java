package challenge;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import business.DatosSocios;
import business.Socio;

public class DatosSociosTest {
	
	private List<Socio> socios;
	private DatosSocios datos;
	
	@Before
	public void setUp() {
		socios = new ArrayList<Socio>();
		socios.add(new Socio("Martín",46,"River","Casado","Terciario"));
		socios.add(new Socio("Daniel",38,"River","Casado","Terciario"));
		socios.add(new Socio("Daniel",31,"Racing","Soltero","Universitario"));
		socios.add(new Socio("Matías",38,"Huracán","Soltero","Universitario"));
		socios.add(new Socio("Juan",50,"Racing","Casado","Terciario"));
		socios.add(new Socio("Santiago",56,"Boca","Casado","Secundario"));
		socios.add(new Socio("Martín",37,"River","Casado","Terciario"));
		socios.add(new Socio("Alejo",67,"River","Soltero","Secundario"));
		socios.add(new Socio("Federico",31,"Estudiantes","Casado","Universitario"));
		socios.add(new Socio("Anibal",22,"Boca","Casado","Universitario"));
		socios.add(new Socio("Marcelo",37,"Racing","Soltero","Terciario"));
		socios.add(new Socio("Alejo",24,"River","Soltero","Universitario"));
		socios.add(new Socio("Alejo",47,"River","Casado","Terciario"));
		
		datos = new DatosSocios(socios);
	}
	
	@Test
	public void cantidadPersonasTest() {
		
		assertEquals(13, datos.cantSocios());
	}
	
	@Test
	public void cantidadPersonasVacioTest() {
		DatosSocios datos = new DatosSocios(new ArrayList<Socio>());
		assertEquals(0, datos.cantSocios());
	}
	
	@Test
	public void promedioEdadSociosRacingTest() {
		assertEquals(39,3, datos.promedioEdadSociosRacing());
	}
	
	@Test
	public void sociosCasadosEnOrdenTest() {
		List<Socio> expected = new ArrayList<Socio>();
		expected.add(new Socio("Anibal",22,"Boca","Casado","Universitario"));
		expected.add(new Socio("Federico",31,"Estudiantes","Casado","Universitario"));
		
		Assert.assertArrayEquals(expected.toArray(),datos.universitariosCasadosEnOrden().toArray());
	}
	
	/*@Test
	public void CincoNombresComunesRiver() {
		List<String> expected = new ArrayList<String>();
		expected.add("Alejo");
		expected.add("Martin");
		expected.add("Daniel");
		Assert.assertArrayEquals(expected.toArray(), datos.CincoNombresComunesRiver().toArray());
	}
	*/
	
}
