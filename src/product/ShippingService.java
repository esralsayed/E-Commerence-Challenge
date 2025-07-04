package product;

import java.util.ArrayList;

public class ShippingService {
	
	private ArrayList<Product> shipped; 
	
	public ShippingService(ArrayList<Product> shipped){
		this.shipped = shipped; 
	}

	public ArrayList<Product> getShipped() {
		return shipped;
	}

	
	

}
