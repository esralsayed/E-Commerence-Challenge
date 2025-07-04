package buyers;

import java.time.LocalDate;

import product.Expirable;
import product.Product;
import product.Shippable;
import cart.Cart;
import exceptions.Empty;
import exceptions.ExpiredProd;
import exceptions.LowBalance;
import exceptions.OutOfStock;

public class Customer {
	
	
	int balance; 
	Cart c; 
	
	public Customer(Cart c,int balance){
		this.c = c; 
		this.balance = balance; 
	}
	
	public void checkout() throws LowBalance, Empty{
	try{
			if (c.getProducts().size()==0){
				throw new Empty("Cart is empty"); 
			}
		
		int subtotal = getTotal();
		if (subtotal<0){
			 throw new LowBalance("Low Balance"); 
		}
		int fees = getShippingFees(); 
		int total = subtotal + fees; 
		int subbalance = balance - total; 

		if (subbalance<0){
			 throw new LowBalance("Low Balance"); 
		}
		
		
		//receipt
		System.out.print("** checkout receipt **"); 
		System.out.print("\n"); 
		for (int i=0; i<c.getProducts().size();i++){
			
			System.out.print(c.getQuans().get(i) + "x " + c.getProducts().get(i).getName()+" "+c.getProducts().get(i).getPrice());
			System.out.print("\n"); 
			
		}
		
		System.out.print("\n"); 
		
		
		//shipping reciept
		System.out.print("** shipping receipt **"); 
		System.out.print("\n"); 
		for (int i=0; i<c.getProducts().size();i++){
			if (c.getProducts().get(i).isShipped==true){
				System.out.print(c.getQuans().get(i) + "x " + c.getProducts().get(i).getName() + " " +
			c.getProducts().get(i).getShippable().getWeight() + "kg");
				System.out.print("\n"); 
				
			}
		
		}
		System.out.print("total weight is: "+Math.round(c.getTotalWeight())+"kg");
		System.out.print("\n"); 
		
		System.out.print("\n"); 
		
		System.out.print("Order subtotal is: " + subtotal); 
		System.out.print("\n"); 
		System.out.print("Shipping is: " + fees); 
		System.out.print("\n"); 
		System.out.print("Total payment is: " +  total);
		System.out.print("\n"); 
		System.out.print("Remaining balance is: " + subbalance); 
		
	}
	catch(Empty e){
		System.out.print("error: Cart is Empty, Please add items to your cart"); 
	}
	catch(LowBalance e){
		System.out.print("error: Insufficent Funds, please remove something from cart to proceed"); 
	}

	
	System.out.print("\n"); 
		
	}
	
	public int getTotal(){
		int total=0; 
		for(int i=0; i<c.getProducts().size(); i++){
			for(int j=0;j<c.getQuans().get(i);j++){
				total+=(c.getProducts().get(i).getPrice());
			}
		
		}
		return total; 
	}
	
	public int getShippingFees(){
		double totalweight=c.getTotalWeight(); 
		
		if (totalweight>=100){
			return 50; //assuming shipping fees change with total weight
		}
		else{
			if (totalweight<100 && totalweight>0)
			return 30; 
			else{
				return 0; 
			}
		}
		
	}
	
	public void addToCart(Product p, int quantity) throws OutOfStock, ExpiredProd{
		try{
		if (quantity <=0){
			 throw new IllegalArgumentException("error: " + p.getName()+" Quantity has to be bigger than 0");
             
		}
		if (p.getQuantity()==0){
			throw new OutOfStock("error " + p.getName()+" out of stock"); 
		}
			if(p.isExpired()==true){
				throw new ExpiredProd("error " + p.getName()+" is expired, add another item"); 
			}
			
		if (quantity<=p.getQuantity()){
				c.getProducts().add(p); 

			int newQuan = p.getQuantity()-quantity; 
			p.setQuantity(newQuan);
			c.getQuans().add(quantity); 
		
		}
		else{
			throw new OutOfStock("error: Cannot add " + quantity +" "+ p.getName() + ", only " + p.getQuantity()+ " remains in stock"); 
		}
		}
		catch(IllegalArgumentException e){
			System.out.print(e.getMessage()); 
			System.out.print("\n"); 
			
			
		}
		catch(OutOfStock e){
			System.out.print(e.getMessage()); 
			System.out.print("\n"); 
			
		}
		catch(ExpiredProd e){
			System.out.print(e.getMessage()); 
			System.out.print("\n"); 
		}
		
	}

	
	
	
	

}
