package _collections;

public enum Marca {
	
	 WV("Volkswagen"), SE("Seat"), ME("Mercedes"), VO("Volvo"), BM("BMW");
 
	
	String name;
	
	private Marca(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

}
