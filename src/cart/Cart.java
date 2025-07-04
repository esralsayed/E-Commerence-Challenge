package cart;

import java.util.ArrayList;

import exceptions.ExpiredProd;
import exceptions.OutOfStock;
import product.Product;

public class Cart {
	
	private ArrayList<Product> products; 
	private ArrayList<Integer> quans; 
	
	public Cart(){
		products= new ArrayList<Product>(); 
		quans= new ArrayList<Integer>(); 
	}
	
	public double getTotalWeight(){
		double totalweight=0; 
		for (int i=0;i<this.products.size();i++){
			if (this.products.get(i).isShipped==true){
				for(int j=0; j<quans.get(i);j++){
					totalweight+=this.products.get(i).getShippable().getWeight(); 
					
					
				}
				
			}
		}
		return totalweight; 
	}
	


	public ArrayList<Product> getProducts() {
		return products;
	}

	public ArrayList<Integer> getQuans() {
		return quans;
	}
	


}
