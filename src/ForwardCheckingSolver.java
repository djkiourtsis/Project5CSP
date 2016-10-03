import java.util.ArrayList;
import java.util.List;


public class ForwardCheckingSolver extends BackTrackingWithHeuristic {
    List<List<String>> itemDomains;

    public ForwardCheckingSolver(ArrayList<Bag> bags, ArrayList<Item> items, ArrayList<Constraint> constraints) {
        super(bags, items, constraints);
        this.itemDomains = new ArrayList<List<String>>();
        for(int i = 0; i < items.size(); i++){ // Set up variable domains
            itemDomains.add(i, new ArrayList<String>());
            for(int j = 0; j < bags.size(); j++){
                if(isValidAssignment(items.get(i), bags.get(j))){
                    itemDomains.get(i).add(bags.get(j).getName());
                }
            }
        }
    }

    public boolean isValidAssignment(Item i, Bag b){
        i.putInBag(b);
        boolean valid = true;
        for(int j = 0; j < constraints.size(); j++){
            if(!constraints.get(j).isSatisfiable(bags)){
                valid = false; // State can't be used to solve problem.
            }
        }
        i.putInBag(null);
        b.removeItem(i);
        return valid;
    }

    public void collapseDomains(){ // Must check all variables since each variable is linked by bag size constraint.
        List<List<String>> newDomains = new ArrayList<List<String>>();
        for(int i = 0; i < this.items.size(); i++){ // Set up variable domains
            if(items.get(i).getBag() != null){ // Skip set up items.
                newDomains.add(i, new ArrayList<String>());
                for(int j = 0; j < this.itemDomains.get(i).size(); j++){
                    newDomains.get(i).add(this.itemDomains.get(i).get(j));
                }
                continue;
            }
            newDomains.add(i, new ArrayList<String>());
            for(int j = 0; j < this.bags.size(); j++){
                if(isValidAssignment(this.items.get(i), this.bags.get(j))){
                    newDomains.get(i).add(this.bags.get(j).getName());
                }
            }
        }
        this.itemDomains = newDomains;
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
            List<List<String>> tempDomains = this.itemDomains; // Hold for backtracking
            collapseDomains();
            //System.out.println("Putting item: " + itemToModify.getName() + " in bag: " + values.get(i).getName());
            if(this.findSolution()){
                return true;
            }
            
            this.itemDomains = tempDomains;
            //System.out.println("Removing item: " + itemToModify.getName() + " from bag: " + values.get(i).getName());
            itemToModify.putInBag(null);
            values.get(i).removeItem(itemToModify);
        }
        return false; // No more valid values for item.
    }
    
    public ArrayList<Bag> valuesToSetTo(Item i){
        ArrayList<Bag> temp = new ArrayList<Bag>();
        int itemIndex = 0;
        for(int a = 0; a < this.items.size(); a++){
            if(items.get(a).getName() == i.getName()){
                itemIndex = a;
                break;
            }
        }
        for(int a = 0; a < this.bags.size(); a++){ // For each bag
            for(int b = 0; b < this.itemDomains.get(itemIndex).size(); b++){
                if(this.bags.get(a).getName() == this.itemDomains.get(itemIndex).get(b)){
                    temp.add(this.bags.get(a));
                }
            }
        }
        return temp; // Return sorted bags.
    }
}
