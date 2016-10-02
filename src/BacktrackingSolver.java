import java.util.ArrayList;


public class BacktrackingSolver {
    ArrayList<Bag> bags;
    ArrayList<Item> items;
    ArrayList<Constraint> constraints;
    
    public BacktrackingSolver(ArrayList<Bag> bags, ArrayList<Item> items, ArrayList<Constraint> constraints) {
        this.bags = bags;
        this.items = items;
        this.constraints = constraints;
    }
    
    // Recursive algorithm.  Modifies variables and returns true when all constraints are satisfied.
    public boolean findSolution(){
        boolean satisfied = true;
        for(int i = 0; i < constraints.size(); i++){
            if(!constraints.get(i).isSatisfiable(bags)){
                return false; // State can't be used to solve problem.
            }
            satisfied = satisfied && constraints.get(i).isSatisfied(bags);
        }
        if(satisfied){ // All constraints satisfied.  Solution is found.
            return true;
        }
        Item itemToModify = itemToModifyNext();
        if(itemToModify == null){
            return false; // No items left
        }
        ArrayList<Bag> values = valuesToSetTo(itemToModify);
        for(int i = 0; i < values.size(); i++){
            itemToModify.putInBag(values.get(i));
            //System.out.println("Putting item: " + itemToModify.getName() + " in bag: " + values.get(i).getName());
            if(this.findSolution()){
                return true;
            }
            //System.out.println("Removing item: " + itemToModify.getName() + " from bag: " + values.get(i).getName());
            itemToModify.putInBag(null);
            values.get(i).removeItem(itemToModify);
        }
        return false; // No more valid values for item.
    }
    
    public Item itemToModifyNext(){
        for(int i = 0; i < this.items.size(); i++){ // Find first non-set item/variable
            if(this.items.get(i).getBag() == null){
                return this.items.get(i);
            }
        }
        return null; // No items left
    }
    
    public ArrayList<Bag> valuesToSetTo(Item i){
        return bags;
    }
}
