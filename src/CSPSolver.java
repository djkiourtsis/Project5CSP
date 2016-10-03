import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CSPSolver {
    static int bagMaxCapacity;
    
	public static void main(String[] args) throws IOException {
		/**
		*The following code block reads the input file and goes through eight
		*while loops to create the bags, items, and constraints and adds them 
		*to their respective arraylists.
		**/ 
		bagMaxCapacity=0;
		int algorithmToRun = 0;
		ArrayList<Bag> bags = new ArrayList<Bag>();
		ArrayList<Item> items = new ArrayList<Item>();
		ArrayList<Constraint> constraints = new ArrayList<Constraint>();
		if(args.length < 1){
		    System.out.println("Usage: java CSPSolver <filename> <optional: 1, 2, or 3>");
		    System.out.println("Optional argument: 1-BackTracking  2-BackTrackingWithHeuristic  3-ForwardChecking");
		    System.exit(0);
		}
		if(args.length > 1){
		    algorithmToRun = Integer.valueOf(args[1]);
		}

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
			Bag tempB = new Bag(temp2[0], Integer.valueOf(temp2[1]), new ArrayList<Item>());
			bags.add(tempB);
			temp = input.nextLine();
		}
		temp = input.nextLine();
		while(!temp.startsWith("#")){
			String[] temp2 = temp.split("\\s+");
			BagCapacityConstraint tempBCC = new BagCapacityConstraint(null, null, Integer.valueOf(temp2[0]), Integer.valueOf(temp2[1]));
			bagMaxCapacity = Integer.valueOf(temp2[1]);
			constraints.add(tempBCC);
			temp = input.nextLine();
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
			for(int c = 1; c < temp2.length; c++){
			    for(int i = 0; i < bags.size(); i++){
			        if(temp2[c].equals(bags.get(i).name)){
			            bagC.add(bags.get(i));
			        }
			    }
			}
			UnaryInclusiveConstraint tempUIC = new UnaryInclusiveConstraint(itemC, bagC);
			constraints.add(tempUIC);
			temp = input.nextLine();
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
			for(int c = 1; c < temp2.length; c++){
                for(int i = 0; i < bags.size(); i++){
                    if(temp2[c].equals(bags.get(i).name)){
                        bagC.add(bags.get(i));
                    }
                }
            }
			UnaryExclusiveConstraint tempW = new UnaryExclusiveConstraint(itemC, bagC);
			constraints.add(tempW);
			temp = input.nextLine();
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
			for(int i = 0; i < items.size(); i++){
				if(temp2[1].equals(items.get(i).name)){
					itemC.add(items.get(i));
				}
			}
			BinaryEqualsConstraint tempW = new BinaryEqualsConstraint(itemC, bagC);
			constraints.add(tempW);
			temp = input.nextLine();
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
			for(int i = 0; i < items.size(); i++){
				if(temp2[1].equals(items.get(i).name)){
					itemC.add(items.get(i));
				}
			}
			BinaryNotEqualsConstraint tempW = new BinaryNotEqualsConstraint(itemC, bagC);
			constraints.add(tempW);
			temp = input.nextLine();
		}
		if(input.hasNextLine()){
			temp = input.nextLine();
		}
		while(!temp.startsWith("#")){
			String[] temp2 = temp.split("\\s+");
			ArrayList<Item> itemC = new ArrayList<Item>();
			ArrayList<Bag> bagC = new ArrayList<Bag>();
			for(int c = 0; c < 2; c++){
                for(int i = 0; i < items.size(); i++){
                    if(temp2[c].equals(items.get(i).name)){
                        itemC.add(items.get(i));
                    }
                }
            }
			for(int c = 2; c < temp2.length; c++){
                for(int i = 0; i < bags.size(); i++){
                    if(temp2[c].equals(bags.get(i).name)){
                        bagC.add(bags.get(i));
                    }
                }
            }
			MutualInclusiveConstraint tempW = new MutualInclusiveConstraint(itemC, bagC);
			constraints.add(tempW);
			if(!input.hasNextLine()){
			    break;
			}
			temp = input.nextLine();
		}

		BagSizeConstraint BSC = new BagSizeConstraint(null, null);
		constraints.add(BSC);
		AllItemsConstraint AIC = new AllItemsConstraint(items, null);
		constraints.add(AIC);
		input.close();

		BacktrackingSolver bts = null;
		if(algorithmToRun==2){
		    bts = new BackTrackingWithHeuristic(bags, items, constraints);
		}
		else if(algorithmToRun==3){
		    bts = new ForwardCheckingSolver(bags, items, constraints);
		}
		else{
		    bts = new BacktrackingSolver(bags, items, constraints);
		}
		long startTime = System.currentTimeMillis();//Calculates time
		System.out.println("Solution possible:"+ " " + bts.findSolution());//Solves CSP
		long endTime = System.currentTimeMillis();
		writeOutPut(bags);//Prints solution
		long timeSpent = endTime - startTime;
		System.out.format("\n%d milliseconds",timeSpent);
	}

	public static void writeOutPut(ArrayList<Bag> bags){
		for(int i = 0; i < bags.size(); i++){
		    System.out.println();
			int iWeight = 0;
			for(int j = 0; j < bags.get(i).getItems().size(); j++){
				iWeight += bags.get(i).getItems().get(j).getWeight();
			}
			System.out.print(bags.get(i).getName());
			for(int k = 0; k < bags.get(i).getItems().size(); k++){
				System.out.print(" " + bags.get(i).getItems().get(k).getName());
			}
			System.out.format("\nnumber of items: %d\n", bags.get(i).getItems().size());
			System.out.format("total weight: %d/%d\n", iWeight, bags.get(i).getCapacity());
			if(bagMaxCapacity > 0){
	            System.out.format("wasted capacity: %d\n", bagMaxCapacity-bags.get(i).getItems().size());
			}
			else{
	            System.out.format("wasted capacity: %d\n", 0);
			}

		}
	}

}
