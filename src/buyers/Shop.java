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
		
		
//	working fully case
//	Cart c = new Cart();
//	Customer cus = new Customer(c,5000); 
//	cus.addToCart(p1, 5);
//	cus.addToCart(p2, 1);
//	c.toString();
//	cus.checkout();

		
		//-------------------------------------------------//
		
		
//	insufficent balance case
//	Cart c = new Cart();
//	Customer cus = new Customer(c,100); 
//	cus.addToCart(p1, 5);
//	cus.addToCart(p2, 1);
//	cus.checkout();
		
		//-------------------------------------------------//
		
//		cheese out of stock case
//		Cart c = new Cart();
//		Customer cus = new Customer(c,5000); 
//		cus.addToCart(p1, 6);
//		cus.addToCart(p2, 1);
//		cus.checkout();
		
		//-------------------------------------------------//
		
//		empty cart case
//		Cart c = new Cart();
//		Customer cus = new Customer(c,100); 

//		cus.checkout();
		
		//-------------------------------------------------//
		
//		Product expired case
		
//		Product p3 = new Product("Pizza", 100,5); 
//		p3.setExpirable(new Expirable(){
//		public LocalDate getExpiryDate() {
//			LocalDate date = LocalDate.of(2025, 7, 1);
//		return date;
//		}
//		
//	});
//	Cart c = new Cart();
//	Customer cus = new Customer(c,5000); 
//	cus.addToCart(p1, 5);
//	cus.addToCart(p3, 1);	cus.checkout();
		
		
//-------------------------------------------------//
		
//		Quantity illegal case
		
//	Product p3 = new Product("Pizza", 100,5); 
//	p3.setExpirable(new Expirable(){
//	public LocalDate getExpiryDate() {
//		LocalDate date = LocalDate.of(2025, 7, 25);
//		return date;
//		}
//		
//	});
//	Cart c = new Cart();
//	Customer cus = new Customer(c,5000); 
//	cus.addToCart(p1, 5);
//	cus.addToCart(p3,0 );	cus.checkout();
		
		
		
		
	
		
	}

}
