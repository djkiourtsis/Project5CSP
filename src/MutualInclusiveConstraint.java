import java.util.ArrayList;


public class MutualInclusiveConstraint extends Constraint {

    public MutualInclusiveConstraint(ArrayList<Item> items, ArrayList<Bag> bags) {
        super(items, bags);
    }

    @Override
    public boolean isSatisfied(ArrayList<Bag> bags) {
        if(this.items.get(0).getBag()==null && this.items.get(1).getBag()==null){
            return true;
        }
        else if(this.items.get(0).getBag()!=null && this.items.get(1).getBag()!=null){
            if(this.items.get(0).getBag().getName()==this.bags.get(0).getName() && this.items.get(1).getBag().getName()==this.bags.get(1).getName()){
                return true;
            }
        }
        return false;
    }

}
