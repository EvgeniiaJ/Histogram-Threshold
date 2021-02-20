import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		String inputFileName;
		String outputFileName1;
		String outputFileName2;
		String outputFileName3;
		String threshold;

		if(args.length < 5) {
			System.out.println("Invalid Number of Arguments. Please provide 1 input file, 3 output files and threshold value.");			
		}
		
		else if(args.length == 5) {
			
			inputFileName = args[0];
			outputFileName1 = args[1];
			outputFileName2 = args[2];
			outputFileName3 = args[3];
			threshold = args[4];
			
			try {
				Scanner input = new Scanner(new File(inputFileName));
				FileWriter output1 = new FileWriter(new File(outputFileName1));
				FileWriter output2 = new FileWriter(new File(outputFileName2));
				FileWriter output3 = new FileWriter(new File(outputFileName3));
				int thresholdValue = Integer.parseInt(threshold);
				
				Image image = new Image(input, thresholdValue);
				image.computeHistogram(input, image.histogramArray);
				image.printHistogram(output1);
				input.close();
				
				input = new Scanner(new File(inputFileName));
				image.thresholdOperation(input, thresholdValue, output2);
				output2.close();
				
				Scanner newInput = new Scanner(new File(outputFileName2));
				image.prettyPrint(newInput, output3);
				
				input.close();
				output1.close();
				newInput.close();
				output3.close();
				
			
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}

		
	}

}
