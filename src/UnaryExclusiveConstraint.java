import java.util.ArrayList;


public class UnaryExclusiveConstraint extends Constraint {

    public UnaryExclusiveConstraint(ArrayList<Item> items, ArrayList<Bag> bags) {
        super(items, bags);
    }

    @Override
    public boolean isSatisfied(ArrayList<Bag> bags) {
        for(int i = 0; i < this.bags.size(); i++){
            if(this.bags.get(i).getName() == this.items.get(0).getBag().getName()){
                return false;
            }
        }
        return true;
    }

}
