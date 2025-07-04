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
	
	
	public static void main(String[] args){
		
		
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
//	Customer cus = new Customer(c,100); 
//	try{cus.addToCart(p1, 5);}
//	catch(IllegalArgumentException e){
//		System.out.print(e.getMessage()); 
//		System.out.print("\n"); 
//		
//		
//	}
//	catch(OutOfStock e){
//		System.out.print(e.getMessage()); 
//		System.out.print("\n"); 
//		
//	}
//	catch(ExpiredProd e){
//		System.out.print(e.getMessage()); 
//		System.out.print("\n"); 
//	}
//	try{cus.addToCart(p2, 1);}
//	catch(IllegalArgumentException e){
//		System.out.print(e.getMessage()); 
//		System.out.print("\n"); 
//		
//		
//	}
//	catch(OutOfStock e){
//		System.out.print(e.getMessage()); 
//		System.out.print("\n"); 
//		
//	}
//	catch(ExpiredProd e){
//		System.out.print(e.getMessage()); 
//		System.out.print("\n"); 
//	}
//
//
//	try {
//		cus.checkout();
//	} catch(Empty e){
//		System.out.print(e.getMessage()); 
//	}
//	catch(LowBalance e){
//		System.out.print(e.getMessage()); 
//	}

		
		//-------------------------------------------------//
		
		
//	insufficent balance case
	
	
	
//	Cart c = new Cart();
//	Customer cus = new Customer(c,100); 
//	try{cus.addToCart(p1, 5);}
//	catch(IllegalArgumentException e){
//		System.out.print(e.getMessage()); 
//		System.out.print("\n"); 
//		
//		
//	}
//	catch(OutOfStock e){
//		System.out.print(e.getMessage()); 
//		System.out.print("\n"); 
//		
//	}
//	catch(ExpiredProd e){
//		System.out.print(e.getMessage()); 
//		System.out.print("\n"); 
//	}
//	try{cus.addToCart(p2, 1);}
//	catch(IllegalArgumentException e){
//		System.out.print(e.getMessage()); 
//		System.out.print("\n"); 
//		
//		
//	}
//	catch(OutOfStock e){
//		System.out.print(e.getMessage()); 
//		System.out.print("\n"); 
//		
//	}
//	catch(ExpiredProd e){
//		System.out.print(e.getMessage()); 
//		System.out.print("\n"); 
//	}
//	try{cus.checkout();}
//	catch(Empty e){
//		System.out.print(e.getMessage()); 
//	}
//	catch(LowBalance e){
//		System.out.print(e.getMessage()); 
//	}
	
		
		//-------------------------------------------------//
		
//		cheese out of stock case
	
	
//		Cart c = new Cart();
//		Customer cus = new Customer(c,5000); 
//		try{cus.addToCart(p1, 6);}
//	catch(IllegalArgumentException e){
//		System.out.print(e.getMessage()); 
//		System.out.print("\n"); 
//		
//		
//	}
//	catch(OutOfStock e){
//		System.out.print(e.getMessage()); 
//		System.out.print("\n"); 
//		
//	}
//	catch(ExpiredProd e){
//		System.out.print(e.getMessage()); 
//		System.out.print("\n"); 
//	}
//		try{cus.addToCart(p2, 1);}
//	catch(IllegalArgumentException e){
//		System.out.print(e.getMessage()); 
//		System.out.print("\n"); 
//		
//		
//	}
//	catch(OutOfStock e){
//		System.out.print(e.getMessage()); 
//		System.out.print("\n"); 
//		
//	}
//	catch(ExpiredProd e){
//		System.out.print(e.getMessage()); 
//		System.out.print("\n"); 
//	}
//		try{cus.checkout();}
//	catch(Empty e){
//		System.out.print(e.getMessage()); 
//	}
//	catch(LowBalance e){
//		System.out.print(e.getMessage()); 
//	}
		
		//-------------------------------------------------//
		
//		empty cart case
	
//		Cart c = new Cart();
//		Customer cus = new Customer(c,100); 

//		try{cus.checkout();}
//	catch(Empty e){
//		System.out.print(e.getMessage()); 
//	}
//	catch(LowBalance e){
//		System.out.print(e.getMessage()); 
//	}
		
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
//	try{cus.addToCart(p1, 5);}
//	catch(IllegalArgumentException e){
//		System.out.print(e.getMessage()); 
//		System.out.print("\n"); 
//		
//		
//	}
//	catch(OutOfStock e){
//		System.out.print(e.getMessage()); 
//		System.out.print("\n"); 
//		
//	}
//	catch(ExpiredProd e){
//		System.out.print(e.getMessage()); 
//		System.out.print("\n"); 
//	}
//	try{cus.addToCart(p3, 1);}
//	catch(IllegalArgumentException e){
//		System.out.print(e.getMessage()); 
//		System.out.print("\n"); 
//		
//		
//	}
//	catch(OutOfStock e){
//		System.out.print(e.getMessage()); 
//		System.out.print("\n"); 
//		
//	}
//	catch(ExpiredProd e){
//		System.out.print(e.getMessage()); 
//		System.out.print("\n"); 
//	}
//	try{cus.checkout();}
//	catch(Empty e){
//		System.out.print(e.getMessage()); 
//	}
//	catch(LowBalance e){
//		System.out.print(e.getMessage()); 
//	}
//		
		
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
//	try{cus.addToCart(p1, 5);}
//	catch(IllegalArgumentException e){
//		System.out.print(e.getMessage()); 
//		System.out.print("\n"); 
//		
//		
//	}
//	catch(OutOfStock e){
//		System.out.print(e.getMessage()); 
//		System.out.print("\n"); 
//		
//	}
//	catch(ExpiredProd e){
//		System.out.print(e.getMessage()); 
//		System.out.print("\n"); 
//	}
//	try{cus.addToCart(p3,0 );}	
//	catch(IllegalArgumentException e){
//		System.out.print(e.getMessage()); 
//		System.out.print("\n"); 
//		
//		
//	}
//	catch(OutOfStock e){
//		System.out.print(e.getMessage()); 
//		System.out.print("\n"); 
//		
//	}
//	catch(ExpiredProd e){
//		System.out.print(e.getMessage()); 
//		System.out.print("\n"); 
//	}
//	
//	try{cus.checkout();}
//	catch(Empty e){
//		System.out.print(e.getMessage()); 
//	}
//	catch(LowBalance e){
//		System.out.print(e.getMessage()); 
//	}
		
		
		
		
	
		
	}

}
