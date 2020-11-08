package challenge;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import business.BuscadorSocios;
import models.Socio;

public class BuscadorSociosTest {
	
	private List<Socio> socios;
	private BuscadorSocios datos;
	
	@Before
	public void setUp() {
		socios = new ArrayList<Socio>();
		socios.add(new Socio("Martín",46,"River","Casado","Terciario"));
		socios.add(new Socio("Daniel",38,"River","Casado","Terciario"));
		socios.add(new Socio("Daniel",31,"Racing","Soltero","Universitario"));
		socios.add(new Socio("Juan",50,"Racing","Casado","Terciario"));
		socios.add(new Socio("Santiago",56,"Boca","Casado","Secundario"));
		socios.add(new Socio("Martín",37,"River","Casado","Terciario"));
		socios.add(new Socio("Alejo",67,"River","Soltero","Secundario"));
		socios.add(new Socio("Federico",31,"Estudiantes","Casado","Universitario"));
		socios.add(new Socio("Anibal",22,"Boca","Casado","Universitario"));
		socios.add(new Socio("Marcelo",37,"Racing","Soltero","Terciario"));
		socios.add(new Socio("Alejo",24,"River","Soltero","Universitario"));
		socios.add(new Socio("Alejo",47,"River","Casado","Terciario"));
		
		datos = new BuscadorSocios(socios);
	}
	
	@Test
	public void cantidadPersonasTest() {
		assertEquals(12, datos.cantSocios());
	}
	
	@Test
	public void cantidadPersonasVacioTest() {
		BuscadorSocios datos = new BuscadorSocios(new ArrayList<Socio>());
		assertEquals(0, datos.cantSocios());
	}
	
	@Test
	public void promedioEdadSociosRacingTest() {
		assertEquals("39,3", datos.promedioEdadSociosRacing());
	}
	
	@Test
	public void  universitariosCasadosEnOrdenTest() {
		List<Socio> expected = new ArrayList<Socio>();
		expected.add(new Socio("Anibal",22,"Boca","Casado","Universitario"));
		expected.add(new Socio("Federico",31,"Estudiantes","Casado","Universitario"));
		
		Assert.assertArrayEquals(expected.toArray(),datos.universitariosCasadosEnOrden().toArray());
	}
	
	@Test
	public void cincoNombresComunesRiver() {
		List<String> expected = new ArrayList<String>();
		expected.add("Alejo");
		expected.add("Martín");
		expected.add("Daniel");
		
		Assert.assertArrayEquals(expected.toArray(), datos.cincoNombresComunesRiver().toArray());
	}
	@Test
	public void sociosPorEquipo() {
		List<ArrayList<String>> expected = new ArrayList<ArrayList<String>>();
		List<String> equipo1= new ArrayList<String>(Arrays.asList("River","6","43,2","24","67"));
		List<String> equipo2= new ArrayList<String>(Arrays.asList("Racing","3","39,3","31","50"));
		List<String> equipo3= new ArrayList<String>(Arrays.asList("Boca","2","39,0","22","56"));
		List<String> equipo4= new ArrayList<String>(Arrays.asList("Estudiantes","1","31,0","31","31"));
		expected.add((ArrayList<String>) equipo1);
		expected.add((ArrayList<String>) equipo2);
		expected.add((ArrayList<String>) equipo3);
		expected.add((ArrayList<String>) equipo4);
		
		Assert.assertArrayEquals(expected.toArray(),datos.estadisticasEquipo().toArray());
	}
	
	
}
