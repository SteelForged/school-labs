import java.util.Scanner;
import java.io.*;

/**
 * Text menu driven program allowing the user to shop for items
 */
public class Shop implements Serializable
{
	public static void main(String[] args)
		throws IOException, ClassNotFoundException
    {
    	
    	ShoppingCart myCart = new ShoppingCart();
		Scanner input = new Scanner(System.in);
		char choice;
		do
		{
			printMenu();
			choice = input.nextLine().charAt(0);
			choice = Character.toUpperCase(choice);
			if (choice != 'Q')
			{
				dispatch(choice, myCart); // process their choice
			}
		
    	}
    	while(choice != 'Q');
		System.out.println("Thanks for shopping!");
    }

   	/**
   	 * Process the menu choices
   	 * @param choice the user's menu choice
   	 * @param basket the current shopping cart
   	 */
    public static void dispatch(char choice, ShoppingCart basket)
    	throws IOException, ClassNotFoundException
    {
    	
    	String itemName;
		double itemPrice;
		int quantity;
		Scanner input = new Scanner(System.in);
		
		switch(choice)
		{
		    
		    case 'A': // add an item to the cart
				System.out.print ("Enter the name of the item: "); 
				itemName = input.nextLine();
		
				System.out.print ("Enter the unit price: ");
				itemPrice = input.nextDouble();
		
				System.out.print ("Enter the quantity: ");
				quantity = input.nextInt();
				input.nextLine();
		
				basket.addItem(new Item(itemName, itemPrice, quantity));
				
				break;
		    case 'F': // find an item in the cart
				System.out.print("Item are you looking for: ");
				itemName = input.nextLine();
				int count = basket.countItem(new Item(itemName));
				System.out.println("You have " + count + " " +itemName + " in your cart.");
				break;
		    case 'P': // print the cart contents
				System.out.println(basket);
				break;
			
			case 'R':  // remove an item from the cart
				System.out.print("Item to remove: ");
				itemName = input.nextLine();
				if (basket.removeItem(new Item(itemName)))
					System.out.println(itemName + " has been removed from your cart.");
				else
					System.out.println("You have no " + itemName + " in your cart to remove.");
				break;
			case 'C': // check out
				System.out.printf("The total cost of your purchase before tax is $%.2f",basket.getTotalCost());
				basket.emptyCart();
				break;
			case 'S':
				System.out.print ("Choose a name for your cart: ");
				String cartName = input.nextLine();
				File f = new File(cartName);
				ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f));
				out.writeObject(basket);
				break;
			case 'L':
				System.out.print("Enter the name of the cart you want to load: ");
				String name = input.nextLine();
				File h = new File(name);
				if(h.exists()){
					ObjectInputStream in = new ObjectInputStream(new FileInputStream(h));
					basket.changeCart((ShoppingCart)in.readObject());
				}
				else
					System.out.println ("File does not exist.");
			case 'E': // empty cart
				basket.emptyCart();
				break;
			
		    default:
				System.out.println("Sorry, invalid choice");
	    }
    }
    
    


    /**
     * Prints the menu choices)
     */
    public static void printMenu()
    {

		System.out.println("\n   Menu   ");
		System.out.println("   ====");
		
		System.out.println("A: Add an item to the cart");
		System.out.println("F: Find an item in the cart by name");
		System.out.println("P: Print the cart contents");
		System.out.println("R: Remove an item from the cart");
		System.out.println("C: Check out");
		System.out.println("E: Start over with an empty cart");
		System.out.println("S: Save the cart to a file");
		System.out.println("L: Load the cart from a file");
		System.out.println("Q: Quit");
		System.out.print("\nEnter your choice: ");
    }


}

