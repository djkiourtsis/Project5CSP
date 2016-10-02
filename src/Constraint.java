import java.util.ArrayList;


public abstract class Constraint {
    ArrayList<Item> items;
    ArrayList<Bag> bags;
    
    public Constraint(ArrayList<Item> items, ArrayList<Bag> bags){
        this.items = items;
        this.bags = bags;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public ArrayList<Bag> getBags() {
        return bags;
    }

    public void setBags(ArrayList<Bag> bags) {
        this.bags = bags;
    }
    
    public abstract boolean isSatisfied(ArrayList<Bag> bags);
}
