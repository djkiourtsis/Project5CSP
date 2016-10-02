import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CSPSolver {

	public static void main(String[] args) throws IOException {
		ArrayList<Bag> bags = new ArrayList<Bag>();
		ArrayList<Item> items = new ArrayList<Item>();
		ArrayList<Constraint> constraints = new ArrayList<Constraint>();

		File inputFile = new File(args[0]);
		Scanner input = new Scanner(inputFile);
		String temp = input.nextLine();
		temp = input.nextLine();
		while(!temp.startsWith("#")){
			String[] temp2 = temp.split("\\s+");
			Item tempI = new Item(temp2[0], Integer.valueOf(temp2[1]), null);
			items.add(tempI);
			temp = input.nextLine();
		}
		temp = input.nextLine();
		while(!temp.startsWith("#")){
			String[] temp2 = temp.split("\\s+");
			Bag tempB = new Bag(temp2[0], Integer.valueOf(temp2[1]), null);
			bags.add(tempB);
			temp = input.nextLine();
		}
		temp = input.nextLine();
		while(!temp.startsWith("#")){
			String[] temp2 = temp.split("\\s+");
			BagCapacityConstraint tempBCC = new BagCapacityConstraint(null, null, Integer.valueOf(temp2[0]), Integer.valueOf(temp2[1]));
			constraints.add(tempBCC);
		}
		temp = input.nextLine();
		while(!temp.startsWith("#")){
			String[] temp2 = temp.split("\\s+");
			ArrayList<Item> itemC = new ArrayList<Item>();
			ArrayList<Bag> bagC = new ArrayList<Bag>();
			for(int i = 0; i < items.size(); i++){
				if(temp2[0].equals(items.get(i).name)){
					itemC.add(items.get(i));
				}
			}
			for(int i = 0; i < bags.size(); i++){
				if(temp2[1].equals(bags.get(i).name)){
					bagC.add(bags.get(i));
				}
			}
			UnaryInclusiveConstraint tempUIC = new UnaryInclusiveConstraint(itemC, bagC);
			constraints.add(tempUIC);
		}
		temp = input.nextLine();
		while(!temp.startsWith("#")){
			String[] temp2 = temp.split("\\s+");
			ArrayList<Item> itemC = new ArrayList<Item>();
			ArrayList<Bag> bagC = new ArrayList<Bag>();
			for(int i = 0; i < items.size(); i++){
				if(temp2[0].equals(items.get(i).name)){
					itemC.add(items.get(i));
				}
			}
			for(int i = 0; i < bags.size(); i++){
				if(temp2[1].equals(bags.get(i).name)){
					bagC.add(bags.get(i));
				}
			}
			UnaryExclusiveConstraint tempW = new UnaryExclusiveConstraint(itemC, bagC);
			constraints.add(tempW);
		}
		temp = input.nextLine();
		while(!temp.startsWith("#")){
			String[] temp2 = temp.split("\\s+");
			ArrayList<Item> itemC = new ArrayList<Item>();
			ArrayList<Bag> bagC = new ArrayList<Bag>();
			for(int i = 0; i < items.size(); i++){
				if(temp2[0].equals(items.get(i).name)){
					itemC.add(items.get(i));
				}
			}
			for(int i = 0; i < bags.size(); i++){
				if(temp2[1].equals(bags.get(i).name)){
					bagC.add(bags.get(i));
				}
			}
			BinaryEqualsConstraint tempW = new BinaryEqualsConstraint(itemC, bagC);
			constraints.add(tempW);
		}
		temp = input.nextLine();
		while(!temp.startsWith("#")){
			String[] temp2 = temp.split("\\s+");
			ArrayList<Item> itemC = new ArrayList<Item>();
			ArrayList<Bag> bagC = new ArrayList<Bag>();
			for(int i = 0; i < items.size(); i++){
				if(temp2[0].equals(items.get(i).name)){
					itemC.add(items.get(i));
				}
			}
			for(int i = 0; i < bags.size(); i++){
				if(temp2[1].equals(bags.get(i).name)){
					bagC.add(bags.get(i));
				}
			}
			BinaryNotEqualsConstraint tempW = new BinaryNotEqualsConstraint(itemC, bagC);
			constraints.add(tempW);
		}
		temp = input.nextLine();
		while(!temp.startsWith("#")){
			String[] temp2 = temp.split("\\s+");
			ArrayList<Item> itemC = new ArrayList<Item>();
			ArrayList<Bag> bagC = new ArrayList<Bag>();
			for(int i = 0; i < items.size(); i++){
				if(temp2[0].equals(items.get(i).name)){
					itemC.add(items.get(i));
				}
			}
			for(int i = 0; i < bags.size(); i++){
				if(temp2[1].equals(bags.get(i).name)){
					bagC.add(bags.get(i));
				}
			}
			MutualInclusiveConstraint tempW = new MutualInclusiveConstraint(itemC, bagC);
			constraints.add(tempW);
		}
		BagSizeConstraint BSC = new BagSizeConstraint(null, null);
		constraints.add(BSC);
		input.close();
		
	}

}
