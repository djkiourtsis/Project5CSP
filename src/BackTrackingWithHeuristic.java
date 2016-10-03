import java.util.ArrayList;

public class BackTrackingWithHeuristic extends BacktrackingSolver {

    public BackTrackingWithHeuristic(ArrayList<Bag> bags, ArrayList<Item> items, ArrayList<Constraint> constraints) {
        super(bags, items, constraints);
    }

    public Item itemToModifyNext(){
        Item temp = null;
        int maxDegree = -1;
        int minValidValues = 5000;

        for(int k = 0; k < this.items.size(); k++){ // MRV Heuristic selects item to mess with.
            int validValues = 0;
            if(this.items.get(k).getBag() == null){
                for(int p = 0; p < this.bags.size(); p++){
                    this.items.get(k).putInBag(this.bags.get(p));
                    boolean satisfied = true;
                    for(int c = 0; c < this.constraints.size(); c++){
                        satisfied = satisfied && constraints.get(c).isSatisfied(bags);
                    }
                    if(satisfied){
                        validValues++;
                    }
                    this.items.get(k).putInBag(null);
                    this.bags.get(p).removeItem(this.items.get(k));
                }
                if(validValues < minValidValues){
                    minValidValues = validValues;
                    temp = this.items.get(k);
                    int degree = 0;
                    for(int i = 0; i < this.constraints.size(); i++){ // Must set maxDegree for degree heuristic
                        for(int j = 0; j < this.constraints.get(i).getItems().size(); j++){
                            if(this.items.get(k).getName() == this.constraints.get(i).getItems().get(j).getName()){
                                degree += 1;
                                break;
                            }
                        }
                    }
                    maxDegree = degree;
                }
                else if(validValues == minValidValues){ // Degree heuristic breaks ties
                    int degree = 0;
                    for(int i = 0; i < this.constraints.size(); i++){
                        for(int j = 0; j < this.constraints.get(i).getItems().size(); j++){
                            if(this.items.get(k).getName().equals(this.constraints.get(i).getItems().get(j).getName())){
                                degree += 1;
                                break;
                            }
                        }
                    }
                    if(degree > maxDegree){
                        maxDegree = degree;
                        temp = this.items.get(k);
                    }
                }
            }
        }
        return temp;
    }

    public ArrayList<Bag> valuesToSetTo(Item i){
        ArrayList<Bag> temp = new ArrayList<Bag>();
        ArrayList<Integer> degrees = new ArrayList<Integer>();
        for(int a = 0; a < this.bags.size(); a++){ // For each bag
            int degree = 0;
            for(int b = 0; b < this.constraints.size(); b++){ // For each constraint
                for(int j = 0; j < this.constraints.get(b).getBags().size(); j++){
                    if(this.bags.get(a).getName().equals(this.constraints.get(b).getBags().get(j).getName())){
                        degree += 1; // Increment if constraint affects bag.
                        break;
                    }
                }
            }
            boolean added = false;
            for(int j = 0; j < degrees.size(); j++){ // Create bags list sorted by increasing degree.
                if(degree < degrees.get(j)){
                    degrees.add(j, degree);
                    temp.add(j, this.bags.get(a));
                    added = true;
                    break;
                }
            }
            if(!added){
                degrees.add(degree);
                temp.add(this.bags.get(a));
            }
        }
        return temp; // Return sorted bags.
    }
}

