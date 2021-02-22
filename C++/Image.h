#pragma once
#include <fstream>
#include <string>
#include <iostream>

using namespace std;

class Image{

private:
	int numRows;
	int numCols;
	int minValue;
	int maxValue;

public:
	int* histogramArray;
	int thresholdValue;

public:
	Image(ifstream&, int);

	void computeHistogram(ifstream&, int*);

	void printHistogram(ofstream&);

	void thresholdOperation(ifstream& input, int threshold, ofstream& output);

	void prettyPrint(ifstream& input, ofstream& output);

};
