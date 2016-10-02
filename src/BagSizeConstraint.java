import java.util.ArrayList;


public class BagSizeConstraint extends Constraint {

    public BagSizeConstraint(ArrayList<Item> items, ArrayList<Bag> bags) {
        super(items, bags);
    }

    @Override
    public boolean isSatisfied(ArrayList<Bag> bags) {
        for(int i = 0; i < bags.size(); i++){
            int bagSize = 0;
            for(int j = 0; j < bags.get(i).getItems().size(); j++){
                bagSize += bags.get(i).getItems().get(j).getWeight();
            }
            if(bagSize>bags.get(i).getCapacity() || bagSize<Math.floor(bags.get(i).getCapacity()*0.9)){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isSatisfiable(ArrayList<Bag> bags) {
        for(int i = 0; i < bags.size(); i++){
            int bagSize = 0;
            for(int j = 0; j < bags.get(i).getItems().size(); j++){
                bagSize += bags.get(i).getItems().get(j).getWeight();
            }
            if(bagSize>bags.get(i).getCapacity()){
                return false;
            }
        }
        return true;
    }

}
