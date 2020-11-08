package views;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import business.BuscadorSocios;
import business.LectorCSVSocios;
import models.Socio;

public class Main {
	
	public static void imprimirCantSocios(int cantSocios){
		System.out.println(" ");
		System.out.println("La cantidad total de socios es: "+ cantSocios);
		System.out.println(" ");
	}
	
	public static void imprimirPromedioEdadRacing(String promedio){
		System.out.println(" ");
		System.out.println("El promedio de edad entre los socios de Racing es: "+ promedio);
		System.out.println(" ");
	}
	
	public static void imprimirCincoNombresRiver(List<String> nombres){
		System.out.println(" ");
		System.out.println("Los cinco nombres más comunes entre los socios de River son: ");
		for (int i=0; i<nombres.size();i++){
			System.out.println(i+1 + "-" + nombres.get(i));
		}
	}
	
	public static void imprimirUniversitariosCasados(List<Socio> socios){
		System.out.println(" ");
		System.out.println("Estos son los socios con estudios Universitarios y Casados: ");
		System.out.println("______________________________________________________________________________________");
		for(Socio s: socios){
			System.out.println(" • Nombre: "+ s.getNombre() + ", Edad: " + s.getEdad() + ", Equipo: " + s.getEquipo()); 
			System.out.println("-----------------------------------------------------------------------------------");
		}

	}
	
	public static void imprimirEstadisticasEquipo(List<ArrayList<String>> equipos){
		System.out.println("Equipos ordenados de mayor a menor según la cantidad de socios: ");
		System.out.println("___________________________________________________________________________________________________________________________________________________________________");
		for(ArrayList<String> e: equipos){
			System.out.println(" • Equipo: " + e.get(0)+ ", Cantidad de Socios: " + e.get(1) + ", Promedio de edad entre los Socios: " + e.get(2) + ", Edad mínima: " + e.get(3) + ", Edad máxima: " + e.get(4));
			System.out.println("------------------------------------------------------------------------------------------------------------------------");
		 }
	}
	
	public static void menu(){
		System.out.println("Superliga");
		System.out.println("----------------------------------------------------------------------------------------------");
		System.out.println("1- Cantidad de Socios");
		System.out.println("2- Promedio de edad de los socios de Racing");
		System.out.println("3- Los cinco nombres más comunes entre los socios de River");
		System.out.println("4- Lista de socios Universitarios y casados");
		System.out.println("5- Lista ordenada por Equipos (según cantidad de socios), promedio de edad, edad Máx y Min.");
		System.out.println("6- Salir");
		System.out.println("----------------------------------------------------------------------------------------------");
		System.out.println("Ingrese el número de la opcion que desee: ");
	}

	public static void main(String[] args) throws Exception {
		String path = System.getProperty("user.dir");
		String file = "/resources/socios.csv";
		LectorCSVSocios lector =  new LectorCSVSocios(path+file);
		List<Socio> socios = lector.leerSocios();
		BuscadorSocios buscador = new BuscadorSocios(socios);
		
		Scanner sca= new Scanner(System.in);
		int numero = -1;
		
		while(numero!=6){
			menu();
			try{
				numero = sca.nextInt();
				switch(numero){
					case 1:
						imprimirCantSocios(buscador.cantSocios());
						break;
					case 2:
						imprimirPromedioEdadRacing(buscador.promedioEdadSociosRacing());
						break;
					case 3:
						imprimirCincoNombresRiver(buscador.cincoNombresComunesRiver());
						break;
					case 4:
						imprimirUniversitariosCasados(buscador.universitariosCasadosEnOrden());
						break;
					case 5:
						imprimirEstadisticasEquipo(buscador.estadisticasEquipo());
						break;
				}
			}catch(InputMismatchException e){
				System.out.println("La opcion ingresada no es correcta");
				sca.next();
			}
		}
		sca.close();
		System.out.println("Gracias por utilizar el buscador de socios");
		
	}
}
