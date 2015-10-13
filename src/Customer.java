import java.util.Vector;
public class Customer {
	private String name;
	private Vector rentals = new Vector();
	public Customer (String name){
		name = name;
	};
	public void addRental(Rental arg) {
		this.rentals.addElement(arg);
	};
	public String getName (){
		return name;
	};
};