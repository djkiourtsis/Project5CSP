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
            Bag tempB = new Bag(temp2[0], Integer.valueOf(temp2[1]), new ArrayList<Item>());
            bags.add(tempB);
            temp = input.nextLine();
        }
        temp = input.nextLine();
        while(!temp.startsWith("#")){
            String[] temp2 = temp.split("\\s+");
            BagCapacityConstraint tempBCC = new BagCapacityConstraint(null, null, Integer.valueOf(temp2[0]), Integer.valueOf(temp2[1]));
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
            for(int i = 0; i < bags.size(); i++){
                if(temp2[1].equals(bags.get(i).name)){
                    bagC.add(bags.get(i));
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
            for(int i = 0; i < bags.size(); i++){
                if(temp2[1].equals(bags.get(i).name)){
                    bagC.add(bags.get(i));
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
            for(int i = 0; i < bags.size(); i++){
                if(temp2[1].equals(bags.get(i).name)){
                    bagC.add(bags.get(i));
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
            for(int i = 0; i < bags.size(); i++){
                if(temp2[1].equals(bags.get(i).name)){
                    bagC.add(bags.get(i));
                }
            }
            BinaryNotEqualsConstraint tempW = new BinaryNotEqualsConstraint(itemC, bagC);
            constraints.add(tempW);
            temp = input.nextLine();
        }
        if(input.hasNextLine()){
            temp = input.nextLine();
        }
        while(!temp.startsWith("#") && input.hasNextLine()){
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
            temp = input.nextLine();
        }
        for(int i = 0; i < bags.size(); i++){
            System.out.println(bags.get(i));
        }
        BagSizeConstraint BSC = new BagSizeConstraint(null, null);
        constraints.add(BSC);
        input.close();

        writeOutPut(bags);
    }

    public static void writeOutPut(ArrayList<Bag> bags){
        for(int i = 0; i < bags.size(); i++){
            int iWeight = 0;
            for(int j = 0; j < bags.get(i).getItems().size(); j++){
                iWeight += bags.get(i).getItems().get(j).getWeight();
            }
            int wCap = bags.get(i).getCapacity() - iWeight;
            //System.out.print(bags.get(i));
            //System.out.println(bags.get(i).getItems());
            System.out.format("\nnumber of items: %d\n", bags.get(i).getItems().size());
            System.out.format("total weight: %d\n", bags.get(i).getItems().size());
            System.out.format("total weight: %d/%d\n", iWeight, bags.get(i).getCapacity());
            System.out.format("wasted capacity: %d\n", wCap);

        }
    }

}
