import java.io.Serializable;

/**
 * The Item class represents an item in a shopping cart
 */
public class Item implements Serializable
{
    private String name;
    private double price;
    private int quantity;

	/**
	 * Constructs an item with a specified name
	 * @param itemName the name of the item
	 */
	public Item(String itemName)
	{
		name = itemName;
		price = 0;
		quantity = 0;
	}
   
   	/**
   	 * Constructs and item with a specified name, price and quantity
   	 * @param itemName the name of the item
   	 * @param itemPrice the price of the item
   	 * @param numPurchased the quantity of the item
   	 */
    public Item(String itemName, double itemPrice, int numPurchased)
    {
		name = itemName;
		price = itemPrice;
		quantity = numPurchased;
    }


    /**
     * Returns a formatted String with item data
     * @return a string version of the item
     */
    public String toString ()
    {
    	return String.format("%-20s\t$%6.2f\t%4d\t\t$%8.2f",name, price, quantity, (price * quantity));
    }

	/**
	 * Returns the price of the item
	 * @return the price of the item
	 */  
    public double getPrice()
    {
		return price;
    }

    
    /**
     * Returns the name of the item
     * @return the name of the item
     */
    public String getName()
    {
		return name;
    }

    /**
     * Returns the quantity of the item
     * @return the quantity of the item
     */
    public int getQuantity()
    {
		return quantity;
    }
    
    /**
     * Compares this item with a specified item.  Items are considered equal if
     * they have the same name
     * @param item the item to compare this item with
     * @return whether or not the item is equal to this one
     */
    public boolean equals(Object item)
    {
    	Item temp = (Item) item;
    	return this.getName().equals(temp.getName());
    }
    
   
  
}  
