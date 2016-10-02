import java.util.ArrayList;


public class BagCapacityConstraint extends Constraint {
    int minLimit;
    int maxLimit;
    
    public BagCapacityConstraint(ArrayList<Item> items, ArrayList<Bag> bags, int min, int max) {
        super(items, bags);
        this.minLimit = min;
        this.maxLimit = max;
    }

    @Override
    public boolean isSatisfied(ArrayList<Bag> bags) {
        for(int i = 0; i < bags.size(); i++){
            if(bags.get(i).getItems().size() < this.minLimit || bags.get(i).getItems().size() > this.maxLimit){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isSatisfiable(ArrayList<Bag> bags) {
        for(int i = 0; i < bags.size(); i++){
            if(bags.get(i).getItems().size() > this.maxLimit){
                return false;
            }
        }
        return true;
    }

}
