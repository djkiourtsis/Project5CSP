import java.util.ArrayList;


public class AllItemsConstraint extends Constraint {

    public AllItemsConstraint(ArrayList<Item> items, ArrayList<Bag> bags) {
        super(items, bags);
    }

    @Override
    public boolean isSatisfied(ArrayList<Bag> bags) {
        for(int i = 0; i < items.size(); i++){
            if(items.get(i).getBag() == null){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isSatisfiable(ArrayList<Bag> bags) {
        return true;
    }

}
