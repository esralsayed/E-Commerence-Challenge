package product;

import java.time.LocalDate;

public class Product{
	
	private String name; 
	private int price; 
	private int quantity;
	
	private Expirable expirable; 
	private Shippable shippable; 
	
	public boolean isShipped; 

	
	public Product(String name, int price, int quantity){
		this.name= name;
		this.price= price; 
		this.quantity=quantity; 
	

	}
	
	public String getName() {
		return name;
	}
	public int getPrice() {
		return price;
	}
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public boolean isExpired() {
		if (this.expirable!=null)
			if(expirable.getExpiryDate().compareTo(LocalDate.now())<=0){
				return true; 
			}
		return false; 
		
	}

	public void setExpirable(Expirable expirable) {
		this.expirable = expirable;
	}
	
	

	public Shippable getShippable() {
		return shippable;
	}

	public Expirable getExpirable() {
		return expirable;
	}

	public void setShippable(Shippable shippable) {
		this.shippable = shippable;
		this.isShipped = true; 
	}
	
	

	

	
	

}
