import java.util.ArrayList;


public class MutualInclusiveConstraint extends Constraint {

    public MutualInclusiveConstraint(ArrayList<Item> items, ArrayList<Bag> bags) {
        super(items, bags);
    }

    @Override
    public boolean isSatisfied(ArrayList<Bag> bags) {
        if(this.items.get(0).getBag()==null && this.items.get(1).getBag()==null){
            return true; // Both null
        }
        else if(this.items.get(0).getBag()!=null){
            if(this.items.get(0).getBag().getName()==this.bags.get(0).getName()){
                if(this.items.get(1).getBag()==null || this.items.get(1).getBag().getName()!=this.bags.get(1).getName()){
                    return false;
                }
                else{
                    return true; // Both in specified bags
                }
            }
            else if(this.items.get(0).getBag().getName()==this.bags.get(1).getName()){
                if(this.items.get(1).getBag()==null || this.items.get(1).getBag().getName()!=this.bags.get(0).getName()){
                    return false;
                }
                else{
                    return true; // Both in specified bags
                }
            }
        }
        else if(this.items.get(1).getBag().getName()==this.bags.get(0).getName() || this.items.get(1).getBag().getName()==this.bags.get(1).getName()){
            return false;
        }
        return true;
    }

    @Override
    public boolean isSatisfiable(ArrayList<Bag> bags) {
        if(this.items.get(0).getBag()==null || this.items.get(1).getBag()==null){
            return true; // One+ null
        }
        if(this.items.get(0).getBag().getName()==this.bags.get(0).getName() && this.items.get(1).getBag().getName()==this.bags.get(1).getName()){
            return true; // In each bag
        }
        else if(this.items.get(0).getBag().getName()==this.bags.get(1).getName() && this.items.get(1).getBag().getName()==this.bags.get(0).getName()){
            return true; // In each bag
        }
        return false;
    }

}
