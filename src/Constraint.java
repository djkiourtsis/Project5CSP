import java.util.ArrayList;


public abstract class Constraint {
    ArrayList<Item> items;
    ArrayList<Bag> bags;
    
    public Constraint(ArrayList<Item> items, ArrayList<Bag> bags){
        this.items = items;
        this.bags = bags;
        if(items == null){
            this.items = new ArrayList<Item>();
        }
        if(bags == null){
            this.bags = new ArrayList<Bag>();
        }
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
    
    public abstract boolean isSatisfied(ArrayList<Bag> bags); // Returns true if the constraint is satisfied.
    public abstract boolean isSatisfiable(ArrayList<Bag> bags); // Returns true if the constraint is still satisfiable.
}
