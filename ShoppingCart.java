import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class that models a set of  Item objects.  A shopping cart has 
 * an ArrayList of items.         
 */ 
public class ShoppingCart implements Serializable
{
	
	private ArrayList <Item> cart;

	/**
	 * Constructs an empty shopping cart
	 */
	public ShoppingCart()
	{
		cart = new ArrayList <Item>();
	}
	
	/**
	 * emptyCart removes all contents from the cart
	 */
	public void emptyCart() { cart.clear(); }
	
	/**
	 * addItem adds a specified item to the cart
	 * @param purchase the item begin added
	 */
	public void addItem(Item purchase)
	{
		cart.add(purchase);
	}
	
	/**
	 * toString provides a String version of the shopping cart with
	 * each item on a separate line
	 * @return the String version of the cart
	 */
	public String toString()
	{
		String out = String.format("%-20s\t%-7s\t%4s\t\t%-10s\n","NAME","PRICE","QTY","TOTAL");
		for(Item i: cart)
			out += i + "\n";
		return out;
	}
	
	/**
	 * countItem returns the quantity of a specified item.
	 * If the item is not in the list, returns 0.
	 * @param purchase the item to count
	 * @return the quantity of that item or 0.
	 */
	public int countItem(Item purchase)
	{
		int index = cart.indexOf(purchase);
		if (index == -1)
			return 0;
		else
			return cart.get(index).getQuantity();
	}
	
	/** 
	 * removeItem removes a specified item from the cart if it exists, and returns true.
	 * If the item does not exist in the cart, returns false.
	 * @param purchase the item to search for and remove
	 * @return whether the item was removed
	 */
	public boolean removeItem(Item purchase)
	{
		int index = cart.indexOf(purchase);
		if (index == -1)
			return false;
		else
		{
			cart.remove(index);
			return true;
		}
		
	}
	
	/**
	 * getTotalCost returns the total cost of all items and quantities 
	 * in the cart.
	 * @return the cost of all items.
	 */
	public double getTotalCost()
	{
		double total = 0;
		for(Item i : cart)
			total += i.getQuantity() * i.getPrice();
		return total;
	}
	
	public void changeCart(ShoppingCart newCart){
		emptyCart();
    	for(Item i : newCart.cart){
    		addItem(new Item(i.getName(),i.getPrice(),i.getQuantity()));
    	}
    	
    }
		
}
	
	
	
	
	
    