package buyers;

import java.time.LocalDate;

import cart.Cart;
import exceptions.Empty;
import exceptions.ExpiredProd;
import exceptions.LowBalance;
import exceptions.OutOfStock;
import product.Expirable;
import product.Product;
import product.Shippable;

public class Shop {
	
	
	public static void main(String[] args) throws OutOfStock, ExpiredProd, LowBalance, Empty{
		
		Cart c = new Cart();
		Customer cus = new Customer(c,5000); 
		
		
		
		Product p1 = new Product("Cheese", 50,5); 
		p1.setExpirable(new Expirable(){
			public LocalDate getExpiryDate() {
				LocalDate date = LocalDate.of(2025, 7, 25);
				return date;
			}
			
		});
		
		p1.setShippable(new Shippable(){

			
			public String getName() {
				return "Cheese"; 
			}

			
			public double getWeight() {
			
				return 1.1;
			}
			
			
			
		});
		
		///
		
		Product p2 = new Product("TV", 2000,  50); 
		p2.setShippable(new Shippable(){

			@Override
			public String getName() {
				// TODO Auto-generated method stub
				return "TV";
			}

			@Override
			public double getWeight() {
				// TODO Auto-generated method stub
				return 500.3;
			}
			
		});
		
		
	cus.addToCart(p1, 5);
	
	cus.addToCart(p2, 1);
	cus.checkout();
		
	}

}
