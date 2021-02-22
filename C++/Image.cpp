#include "Image.h"

Image::Image(ifstream& input, int thresholdValue){
	if (input.good()) {
		input >> this->numRows;
		input >> this->numCols;
		input >> this->minValue;
		input >> this->maxValue;
	}
	this->thresholdValue = thresholdValue;
	histogramArray = new int[this->maxValue + 1];

	for (int i = 0; i <= this->maxValue; i++) {
		histogramArray[i] = 0;
	}
}

void Image::computeHistogram(ifstream& input, int* array){
	int value = -1;
	while (!input.eof()) {
		input >> value;
		histogramArray[value]++;
	}
}

void Image::printHistogram(ofstream& output){
	try {
		for (int i = 0; i <= this->maxValue; i++) {
			if (i <= 9) {
				output << "0";
			}
			
			output << i << "  (";
			if (histogramArray[i] < 10) {
				output << "00";
			}
			else if (histogramArray[i] < 100 && histogramArray[i] > 9) {
				output << "0";
			}
			output << histogramArray[i] << "):";
			if (histogramArray[i] != 0) {
				int max = histogramArray[i];
				if (max > 60) {
					max = 60;
				}
				for (int j = 0; j < max; j++) {
					output << "+";
				}
			}
			output << endl;

		}

	}
	catch (exception e) {
		cout << "There is an error: " << e.what() << endl;
	}
}

void Image::thresholdOperation(ifstream& input, int threshold, ofstream& output) {
	int row = 0, col = 0, pixelValue = -1;
	try {
		output << numRows << " " << numCols << " " << minValue << " " << maxValue << endl;
		if(input.good()){
			input >> numRows;
			input >> numCols;
			input >> minValue;
			input >> maxValue;
		}

		while (row < numRows) {
			col = 0;
			while (col < numCols) {
				if (input.good()) {
					input >> pixelValue;
				}
				else {
					break;
				}
				if (pixelValue >= threshold) {
					output << "1 ";
				}
				else {
					output << "0 ";
				}
				col++;
			}
			output << endl;
			row++;
		}
	}
	catch (exception e) {
		cout << "There is an error: " << e.what() << endl;
	}

}

void Image::prettyPrint(ifstream& input, ofstream& output){
	int row = 0, col = 0, pixelValue = -1;
	try {
		output << numRows << " " << numCols << " " << minValue << " " << maxValue << endl;
		if (input.good()) {
			input >> numRows;
			input >> numCols;
			input >> minValue;
			input >> maxValue;
		}

		while (row < numRows) {
			col = 0;
			while (col < numCols) {
				if (input.good()) {
					input >> pixelValue;
				}
				else {
					break;
				}
				if (pixelValue > 0) {
					output << pixelValue << " ";
				}
				else {
					output << "  ";
				}
				col++;
			}
			output << endl;
			row++;
		}
	}
	catch (exception e) {
		cout << "There is an error: " << e.what() << endl;
	}
}
