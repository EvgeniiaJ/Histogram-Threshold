#include <fstream>
#include <string>
#include <iostream>

#include "Image.h"

using namespace std;

int main(int argc, char** argv) {

	string inputFileName;
	string outputFileName1;
	string outputFileName2;
	string outputFileName3;
	int threshold;

	if (argc != 6) {
		cout << "Invalid number of arguments" << endl;
		return 0;
	}

	try {
		ifstream input;
		ofstream output1;
		ofstream output2;
		ofstream  output3;

		input.open(argv[1]);
		output1.open(argv[2]);
		output2.open(argv[3]);
		output3.open(argv[4]);
		threshold = atoi(argv[5]);

		Image* image = new Image(input, threshold);
		image->computeHistogram(input, image->histogramArray);
		image->printHistogram(output1);
		input.close();

		input.open(argv[1]);
		image->thresholdOperation(input, threshold, output2);
		output2.close();

		ifstream newInput;
		newInput.open(argv[3]);
		image->prettyPrint(newInput, output3);

		input.close();
		output1.close();
		newInput.close();
		output3.close();
	}
	catch (exception e) {
		cout << "There is an error: " << e.what() << endl;
	}

	return 0;
}