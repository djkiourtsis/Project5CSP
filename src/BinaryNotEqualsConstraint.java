import java.util.ArrayList;


public class BinaryNotEqualsConstraint extends Constraint {

    public BinaryNotEqualsConstraint(ArrayList<Item> items, ArrayList<Bag> bags) {
        super(items, bags);
    }

    @Override
    public boolean isSatisfied(ArrayList<Bag> bags) {
        if(this.items.get(0).getBag().getName()==this.items.get(1).getBag().getName()){
            return false;
        }
        return true;
    }

}