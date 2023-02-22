package _collections;

public class Test {
	
	public static void main(String[] args) {
		
		 Coche coche1 = new Coche(Marca.WV , Color.AZ);
		 Coche coche2 = new Coche(Marca.SE , Color.RO);
		 Coche coche3 = new Coche(Marca.WV , Color.AZ);
		 Coche coche4 = new Coche(Marca.WV , Color.AM);
		 Coche coche5 = new Coche(Marca.WV , Color.AZ);
		 
		 Coche[] coches = {coche1,coche2,coche3,coche4,coche5};
		 
		 Parking parking1 = new Parking( 10, "Mira Flores");
		 
		 for(int i = 0; i <5 ; i++) {
			 System.out.println(parking1.entraCoche(coches[i]));
		 }
		 System.out.println(parking1.entraCoche(coches[0]));
		 System.out.println(parking1.listaCoches);
//		 System.out.println("Sacando coches:");
//		 System.out.println("===============");
//		 System.out.println(parking1.saleCocheAleatorio());
//		 System.out.println(parking1.saleCocheAleatorio());
//		 System.out.println(parking1.saleCocheAleatorio());
//		 System.out.println(parking1.saleCocheAleatorio());
//		 System.out.println(parking1.saleCocheAleatorio());
//		 System.out.println(parking1.saleCocheAleatorio());
//		 System.out.println(parking1.vaciaParking());
//		 System.out.println(parking1.vaciaParking());
//		 System.out.println(parking1.listaCoches);
		 parking1.reportParking();
//		 System.out.println(parking1.vaciaParking());
//		 parking1.reportParking();
		 
//		 parking1.saleCoche(coche2);
//		 parking1.saleCoche(coche1);
		 
		 for(Color key : parking1.mapColorCoches.keySet()) {
			 System.out.println("key " + key);
		 }
		 System.out.println(parking1.mapColorCoches.size());
		 
		 
         parking1.reportColores();		 
         parking1.reportMarca();
         parking1.reportCochesIguales();
		 
	}

}
