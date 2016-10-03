import java.util.ArrayList;


public class BinaryNotEqualsConstraint extends Constraint {
//Contains the common satisfiability functions.
    public BinaryNotEqualsConstraint(ArrayList<Item> items, ArrayList<Bag> bags) {
        super(items, bags);
    }

    @Override
    public boolean isSatisfied(ArrayList<Bag> bags) {
        if(this.items.get(0).getBag() == null || this.items.get(1).getBag() == null){
            return true;
        }
        if(this.items.get(0).getBag().getName()==this.items.get(1).getBag().getName()){
            return false;
        }
        return true;
    }

    @Override
    public boolean isSatisfiable(ArrayList<Bag> bags) {
        return isSatisfied(bags);
    }

}
