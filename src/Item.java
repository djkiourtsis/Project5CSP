
public class Item {
//Properties of an item
	String name;
	int weight;
	Bag bagIn; //The bag the item is currently in. Always starts with a null bag.
	 
	public Item(String name, int weight, Bag bagIn){
		this.name = name;
		this.weight = weight;
		this.bagIn = bagIn;
	}
//Function to put an item into a bag	
	public void putInBag(Bag bag){
		bagIn = bag;
		bag.addItem(this);
	}
	
	public String getName(){
		return this.name;
	}
	
	public int getWeight(){
		return this.weight;
	}
	
	public Bag getBag(){
		return this.bagIn;
	}
}
