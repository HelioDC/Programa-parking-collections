package _collections;
import java.util.Objects;
import java.util.Random;
public class Coche {
	
	Marca marca;
	Color color;
	
	public Coche(Marca marca, Color color) {
		this.marca = marca;
		this.color = color;
		
	}
	
	public Coche() {
		this.marca = Marca.values()[new Random().nextInt(Marca.values().length)];
		this.color = Color.values()[new Random().nextInt(Color.values().length)];
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Coche: ").append(marca + " ").append(color);
		return sb.toString();
	}
	
	@Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.marca);
        hash = 31 * hash + Objects.hashCode(this.color);
        return hash;
    }
	
	@Override 
	public boolean equals(Object obj) {
		if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Coche other = (Coche) obj;
        if (this.marca != other.marca) {
            return false;
        }
        return this.color == other.color;
    }  
	
	

}
