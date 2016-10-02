import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CSPSolver {
	
    public static void main(String[] args) throws IOException {
    	ArrayList<String> inputArr = new ArrayList<String>();
    	File inputFile = new File(args[0]);
    	Scanner input = new Scanner(inputFile);
			while(input.hasNext()){
				String temp = input.nextLine();
				if(!temp.startsWith("#")){
					inputArr.add(temp);
				}
			}
			for(int i = 0; i < inputArr.size(); i++){
				System.out.println(inputArr.get(i));
			}
			input.close();
    }

}
