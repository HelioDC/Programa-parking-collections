package _collections;

import java.util.*;
import java.util.Random;

public class Parking {

	String nombre;
	int totalPlazas;
	ArrayList<Coche> listaCoches = new ArrayList<Coche>();
	
	Map<Color,Integer> mapColorCoches = new HashMap<>();
	
	Map<Marca,Integer> mapMarcaCoches = new HashMap<>();
	
	Map<Coche,Integer> mapCochesIguales = new HashMap<>();
	
	Set<Coche> setCoches = new HashSet<>();
	
	
	
	

	public Parking(int totalPlazas, String nombre) {
		this.totalPlazas = totalPlazas;
		this.nombre = nombre;
		
	}

	public boolean entraCoche(Coche c) {
		// Compara si el coche ya esta dentro y si hay sitio para otro coche
	
		boolean cocheEnParking = false; //indicara si el coche ya se encuentra en el parking.
		
		for(Coche coche : listaCoches) {
			if(coche == c) cocheEnParking = true;
		}
		
		
		if (cocheEnParking) {
			System.out.print("Este coche ya está en el parking. Coche entra: ");
			return false;
		} else if (listaCoches.size() >= totalPlazas) {
			System.out.print("El parking esta lleno. Coche entra: ");
			return false;
		}

		// si no, entra otro coche
		else {
			listaCoches.add(c);
			if(mapColorCoches.containsKey(c.color)) mapColorCoches.put(c.color, mapColorCoches.get(c.color)+1);
			else mapColorCoches.put(c.color, 1);
			
			if (mapMarcaCoches.containsKey(c.marca)) mapMarcaCoches.put(c.marca, mapMarcaCoches.get(c.marca) + 1);
			else mapMarcaCoches.put(c.marca, 1);
			
			if (mapCochesIguales.containsKey(c)) mapCochesIguales.put(c, mapCochesIguales.get(c) + 1);
			else mapCochesIguales.put(c, 1);
			
			
			System.out.print("Coche entra: ");
			return true;
		}
	}

	public boolean saleCoche(Coche c) {

		// Si el parking esta vacio sale
		if (listaCoches.size() == 0) {
			System.out.print("Parking vacio. Coche sale: ");
			return false;
		}
		// Si el coche no se encuentra dentro del parking
		else if (!listaCoches.contains(c)) {
			System.out.print("Este coche no esta en el parking. Coche sale: ");
			return false;
		} else {
			listaCoches.remove(c);
			if(mapColorCoches.get(c.color) >1 ) mapColorCoches.put(c.color, mapColorCoches.get(c.color) -1 );
			else mapColorCoches.remove(c.color);
			
			if (mapMarcaCoches.get(c.marca) > 1) mapMarcaCoches.put(c.marca, mapMarcaCoches.get(c.marca) -1);
			else mapMarcaCoches.remove(c.marca);
			System.out.print("Coche sale: ");
			return true;
		}

	}

	public boolean saleCocheAleatorio() {
		if (listaCoches.size() > 0)
			return saleCoche(listaCoches.get(new Random().nextInt(listaCoches.size())));
		else {
			System.out.print("Parking vacio. Coche sale: ");
			return false;
		}
	}

	public boolean vaciaParking() {
		
		if(listaCoches.size() == 0) {
			System.out.print("El parking ya estaba vacio. Vaciar parking = ");
			return false; 
		}
		else {
		    while(listaCoches.size()>0) {
			saleCocheAleatorio();
		    }
		    System.out.print("Vaciar parking: ");
		    return true;
		}
		
	}
	
	public void reportParking() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nListado Coches").
		append( "\n--------------").
		append("\nParking: ").append(nombre);
		listaCoches.forEach(s-> sb.append("\n " + s));
		sb.append("\nTotal coches: "+ listaCoches.size()+", plazas libres: " + (totalPlazas - listaCoches.size()));
		
		System.out.println(sb);
	}
	
	public void reportColores() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nReport de colores").
		append( "\n----------------").
		append("\nParking: ").append(nombre);
		mapColorCoches.forEach((color, num) ->{
			sb.append("\n El coche de color " + color.getName() + " se repite " + num +  (num>1?" veces" : " vez") );
		});
	    sb.append("\nTotal coches: " + listaCoches.size());
	    System.out.println(sb);
		
	}
	public void reportMarca() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nReport de marcas").
		append( "\n----------------").
		append("\nParking: ").append(nombre);
		mapMarcaCoches.forEach((marca, num) ->{
			sb.append("\n El coche de la marca " + marca.getName() + " se repite " + num +  (num>1?" veces" : " vez") );
		});
	    sb.append("\nTotal coches: " + listaCoches.size());
	    System.out.println(sb);
		
	}
	
	public void reportCochesIguales() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nReport de marcas").
		append( "\n----------------").
		append("\nParking: ").append(nombre);
		mapCochesIguales.forEach((c, num) ->{
			sb.append("\n El coche " + c.marca + " " + c.color + " se repite " + num +  (num>1?" veces" : " vez") );
		});
	    sb.append("\nTotal coches: " + listaCoches.size());
	    System.out.println(sb);
		
	}
	

}
