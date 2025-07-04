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
	
			if (c.getProducts().size()==0){
				throw new Empty("Cart is empty"); 
			}
		


		
		int subtotal = getTotal();
		int fees = getShippingFees(); 
		int total = subtotal + fees; 
		int subbalance = balance - total; 

			if (subbalance<0){
				 throw new LowBalance("Low Balance, cannot purchase, please remove something from cart to proceed"); 
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
		if (p.getQuantity()==0){
			throw new OutOfStock(p.getName()+" out of stock"); 
		}
			if(p.isExpired()==true){
				throw new ExpiredProd(p.getName()+" is expired, add another"); 
			}
			
		if (quantity<=p.getQuantity()){
				c.getProducts().add(p); 

			int newQuan = p.getQuantity()-quantity; 
			p.setQuantity(newQuan);
			c.getQuans().add(quantity); 
		
		}
		else{
			throw new OutOfStock("Cannot add " + quantity +" "+ p.getName() + ", only " + p.getQuantity()+ " remains in stock"); 
		}
		
	}
	
	public void remove(Product p, int quantity){

		for(int i=0; i<c.getProducts().size();i++){
			if(c.getProducts().get(i).getName().equals(p.getName())){
				c.getProducts().remove(i); 
				c.getQuans().remove(i);
			}
		}
		
	}
	
	
	
	

}
