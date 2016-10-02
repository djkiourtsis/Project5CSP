import java.util.ArrayList;


public class UnaryInclusiveConstraint extends Constraint {

    public UnaryInclusiveConstraint(ArrayList<Item> items, ArrayList<Bag> bags) {
        super(items, bags);
    }

    @Override
    public boolean isSatisfied(ArrayList<Bag> bags) {
        if(this.items.get(0).getBag()==null){
            return false;
        }
        for(int i = 0; i < this.bags.size(); i++){
            if(this.bags.get(i).getName() == this.items.get(0).getBag().getName()){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isSatisfiable(ArrayList<Bag> bags) {
        if(this.items.get(0).getBag()==null){
            return true;
        }
        for(int i = 0; i < this.bags.size(); i++){
            if(this.bags.get(i).getName() == this.items.get(0).getBag().getName()){
                return true;
            }
        }
        return false;
    }

}
