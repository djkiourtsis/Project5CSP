import java.util.ArrayList;


public class BinaryEqualsConstraint extends Constraint {
//Contains the common satisfiability functions.
    public BinaryEqualsConstraint(ArrayList<Item> items, ArrayList<Bag> bags) {
        super(items, bags);
    }

    @Override
    public boolean isSatisfied(ArrayList<Bag> bags) {
        if(this.items.get(0).getBag() == null || this.items.get(1).getBag() == null){
            return false;
        }
        else if(this.items.get(0).getBag().getName()==this.items.get(1).getBag().getName()){
            return true;
        }
        return false;
    }

    @Override
    public boolean isSatisfiable(ArrayList<Bag> bags) {
        if(this.items.get(0).getBag() == null || this.items.get(1).getBag() == null){
            return true;
        }
        else if(this.items.get(0).getBag().getName()==this.items.get(1).getBag().getName()){
            return true;
        }
        return false;
    }

}
