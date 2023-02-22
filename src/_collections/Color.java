package _collections;

public enum Color {
	
	RO("Rojo"), NA("Naranja"), AM("Amarillo"), VE("verde"),
	AZ("Azul"),IN("Indigo"),VI("Violeta");
	
	String name;
	
	private Color(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	

}
