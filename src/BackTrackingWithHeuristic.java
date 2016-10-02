import java.util.ArrayList;

public class BackTrackingWithHeuristic extends BacktrackingSolver {

	public BackTrackingWithHeuristic(ArrayList<Bag> bags, ArrayList<Item> items, ArrayList<Constraint> constraints) {
		super(bags, items, constraints);

	}

	public Item itemToModifyNext(){
		Item temp = null;
		int degree2 = 0;
		int solutions2 = 0;

		for(int k = 0; k < this.items.size(); k++){
			int solutions = 0;
			if(this.items.get(k).getBag() == null){
				for(int p = 0; p < this.constraints.size(); p++){
					if(constraints.get(p).isSatisfiable(bags)){
						solutions -= 1; 
					}
					if(solutions < solutions2){
						solutions2 = solutions;
						temp = this.items.get(k);
					}
				}
			}
			if(solutions == solutions2){
			for(int i = 0; i < this.items.size(); i++){
				int degree = 0;
				for(int j = 0; j < this.constraints.size(); j++){
					if(this.items.get(i).getName().equals(this.constraints.get(j).getItems().get(j).getName())){
						degree += 1;
					}
					if(degree > degree2){
						degree2 = degree;
						temp = this.items.get(i);
					}
				}
			}
		}
		}
		return temp;
	}

	public ArrayList<Bag> valuesToSetTo(Item i){
		int degree2 = 0;
		ArrayList<Bag> temp = null;
		for(int d = 0; d < this.bags.size(); d++){
			int degree = 0;
			for(int j = 0; j < this.constraints.size(); j++){
				if(this.bags.get(d).getName().equals(this.constraints.get(j).getItems().get(j).getName())){
					degree += 1;
				}
				if(degree > degree2){
					degree2 = degree;
				}
		}
	}
		return temp;
	}
}

