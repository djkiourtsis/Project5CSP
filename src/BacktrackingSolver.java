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
            satisfied = constraints.get(i).isSatisfied(bags);
            if(!satisfied){
                break;
            }
        }
        if(satisfied){ // All constraints satisfied.  Solution is found.
            return true;
        }
        return false; // Recursion stuff here.
    }
    
    public Item itemToModifyNext(){
        return null;
    }
    
    public ArrayList<Bag> valuesToSetTo(Item i){
        return null;
    }
}
