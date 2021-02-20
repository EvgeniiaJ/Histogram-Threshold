import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Image {
	
	private int numRows;
	private int numCols;
	private int minValue;
	private int maxValue;
	public int[] histogramArray;
	public int thresholdValue;
	
	Image(Scanner input, int thresholdValue){
		if(input.hasNext()) {
			this.numRows = input.nextInt();
		}
		if(input.hasNext()) {
			this.numCols = input.nextInt();
		}
		if(input.hasNext()) {
			this.minValue = input.nextInt();
		}
		if(input.hasNext()) {
			this.maxValue = input.nextInt();
		}
		this.thresholdValue = thresholdValue;
		
		this.histogramArray = new int[maxValue + 1];
		
		for(int i = 0; i <= maxValue; i++) {
			histogramArray[i] = 0;
		}
	}
	
	public void computeHistogram(Scanner input, int[] array) {
		int value = -1;
		while(input.hasNext()) {
			value = input.nextInt();
			array[value]++;
		}		
	}
	
	public void printHistogram(FileWriter output) {
		String str = "";
		try {
			output.write(numRows + " " + numCols + " " + minValue + " " + maxValue + "\n");
			for(int i = 0; i <= maxValue; i++) {
				
				str = "";
				if(i <= 9) {
					str += "0";
				}
				
				str += i + "  (";
				if(histogramArray[i] < 10) {
					str += "00";
				}
				else if(histogramArray[i] < 100 && histogramArray[i] > 10) {
					str += "0";
				}
				str += histogramArray[i] + "):";
				
				if(histogramArray[i] != 0) {
					int max = histogramArray[i];
					if(max > 60) {
						max = 60;
					}
					for(int j = 0; j < max; j++) {
						str += "+";
					}
				}
				output.write(str + "\n");
			}			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void thresholdOperation(Scanner input, int threshold, FileWriter output) {
		int row = 0, col = 0, pixelValue = -1;
		try {
			output.write(numRows + " " + numCols + " " + minValue + " " + maxValue + "\n");
			
			if(input.hasNext()) {
				this.numRows = input.nextInt();
			}
			if(input.hasNext()) {
				this.numCols = input.nextInt();
			}
			if(input.hasNext()) {
				this.minValue = input.nextInt();
			}
			if(input.hasNext()) {
				this.maxValue = input.nextInt();
			}
			
			while(row < numRows) {
				col = 0;
				while(col < numCols) {
					if(input.hasNext()) {
						pixelValue = input.nextInt();
					}
					else {
						break;
					}
					if(pixelValue >= threshold) {
						output.write("1 ");
					}
					else {
						output.write("0 ");
					}
					col++;
				}
				output.write("\n");
				row++;
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void prettyPrint(Scanner input, FileWriter output) {
		int row = 0, col = 0, pixelValue = -1;
		try {
			
			if(input.hasNext()) {
				this.numRows = input.nextInt();
			}
			if(input.hasNext()) {
				this.numCols = input.nextInt();
			}
			if(input.hasNext()) {
				this.minValue = input.nextInt();
			}
			if(input.hasNext()) {
				this.maxValue = input.nextInt();
			}
			
			while(row < numRows) {
				col = 0;
				while(col < numCols) {
					if(input.hasNext()) {
						pixelValue = input.nextInt();
					}
					else {
						break;
					}
					if(pixelValue > 0) {
						output.write(pixelValue  + " ");
					}
					else {
						output.write("  ");
					}
					col++;
				}
				output.write("\n");
				row++;
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

}
