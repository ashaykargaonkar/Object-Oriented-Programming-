package shop.data;
public interface Record {
	
	public Video video();
	
	public int numOwned();
	
	public int numOut();
	
	public int numRentals();
	
	public boolean equals(Object thatObject);
	
	public int hashCode();
	
	public String toString();

	
}