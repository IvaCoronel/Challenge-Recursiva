package challenge;

import static org.junit.Assert.*;

import org.junit.Test;

import business.Socio;

public class SocioTest {

	@Test
	public void compararSocioEdad() {
		Socio s1 =new Socio("Federico",31,"Estudiantes","Casado","Universitario");
		Socio s2= new Socio("Anibal",22,"Boca","Casado","Universitario");
		Socio s3=new Socio("Anibal",31,"Boca","Casado","Universitario");
		
		
		assertTrue(s1.compareTo(s3) >0);
	}

}
