import java.util.ArrayList;


public class Bag {
	
//The properties of a Bag
	String name;
	int capacity;
	ArrayList<Item> items; //The items that are in a particular bag
//The constructor for the Bag class	
	public Bag(String name, int capacity, ArrayList<Item> items){
		this.name = name;
		this.capacity = capacity;
		this.items = items;
	}
	
//Checks to see if the bag contains a particular item.	
	public boolean constainsI(Item item){
		return items.contains(item);
	}
	
	public String getName(){
		return this.name;
	}
	
	public int getCapacity(){
		return this.capacity;
	}
	
	public ArrayList<Item> getItems(){
		return this.items;
	}
}
