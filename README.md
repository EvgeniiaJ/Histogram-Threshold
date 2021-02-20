# Histogram-Threshold

The project consists of three parts:

    Part 1: Compute histogram. The histogram of an image is the statistic counting of pixel values
    	    in the input image, where hist[i] tells how many pixels having value i in the input image. 
    
    Part 2: Perform binary threshold operation on the input image using the threshold values provided
    	    by the user via argv. The binary threshold operation is the simplest way to extract 
	    foreground objects in a given grey-scale image.  Given an image and a threshold value,
	    the binary threshold operation is to transform pixels in the input image from grey-scale
	    to binary values.
    
     Part 3: Display the result of threshold image in a nice visually.  
 	       
Input:

       InFile: a txt file representing a grey-scale image, where 
	     the first text line (4 integers) is the "header" of the input image
       then follows by rows and cols of integers.
   
	For example,
	
	4  6  1 12        // image has 4 rows,6 cols, min is 1, max is 12
	2  3  4 11  2  9
	5  6 11  2 10  7
	1  1 12  1  9  9
	4  5  6  9  9  9


Output:

    OutFile1: histogram of the image
    
Display the histogram as follows:
first text line is the image header then follows by a list of : greyScale (numpixels): number of +’s
for example, the output of the histogram of the above image would be:
Use the maximum of 60 +’s for all counts greater than 60.
	
      4 6 1 12 
	0  (0):
	1  (3):+++ 
	2  (3):+++
	3  (1):+
	4  (2):++	
  5  (2):++
	6  (2):++
	7  (1):+
	8  (0):
	9  (6):++++++
	10 (1):+
	11 (2):++
	12 (1):+

    OutFile2: The result of the threshold of the input image.
	
Note: The output binary image also needs to have the image header.
	
For example, given the above image and 6 as the threshold value
then the binary image would be:
	
	4  6  0  1		// notice the min and max values have changed! 
	0  0  0  1  0  1
	0  1  1  0  1  1
	0  0  1  0  1  1
	0  0  1  1  1  1   

    OutFile3: (For nice visual purposes, no image header is needed).
	
For example, given the above threshold image, the pretty print would be:
		   
	         1     1
	   1  1     1  1
	      1     1  1
	      1  1  1  1   
 
    a threshold value  // let it be 6 for the input image.
