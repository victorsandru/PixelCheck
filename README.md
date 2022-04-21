# PixelCheck
## Installation
This project uses Java 17.0.1, you can find your system download [here](https://www.oracle.com/java/technologies/downloads/).

You can install this repo using git. You can install it [here](https://git-scm.com/downloads).

To start, create a folder to store the files. Afterwards in your chosen folder, open your console and use this command:

```
git clone https://github.com/victorsandru/PixelCheck.git
```
Here is an example: <br/>
![gif of how to install repo](/docs/clone.gif)


Use your favourite IDE to then run either the SampleRunIterative class or SampleRunRecursive class. These classes are under src/test/java.


## What does it do?
Creates an Image object. An image object consists of a 2d grid of Pixel objects. These Pixel objects location is specified by their respective row and column in the image. The Pixels can also be have "ink" in them. Meaning that you can see the pixel.

In the Image object, there can be 'blobs' of ink. The blob object represents where one or more pixels have ink and are immediate neighbours in the image. Immediate neighbours are only pixels that have other pixels either horizontally or vertically and have ink. Diagonals do not apply.

Here is an example: <br/>
![pixel placement example](/docs/pixelPlacementExample.png) <br/>
The left most blob is made of 3 orange pixels. The middle blob consists of only one teal pixel. The right most blob has 3 navy blue pixels. Notice that how the teal and navy pixels are different blobs.

There are two different algorithms to find all the pixels in a given blob. I have implemented both a recursive and a iterative method.
### Editing Parameters
To change where the algorithms start, head to line 19 of the SampleRun(iterative or recursion) class. Here you can specify where the explore algorithm starts.

### Starting the search

After installing the required files, simply run the SampleRun(iterative or recursion) class. This class will run the explore algorithm through all pixels in start nested array (line 19).

The Image object will be printed onto console and if your inputted coordinates have any blobs, it will display an array of all the pixels in the blob along with a display of the Image object.

In the image display, all pixels in the given blob will be marked with numbers. These numbers represent the order of when the algorithm reached that certain pixel.
<br/>
![image display placement](/docs/imageDisplayExample.png)
<br/>
Here the original pixel starts at the first row, and second column. Since this pixel is in a blob, the array of all pixels in the blob is displayed. Afterwards the image is displayed with the algorithms walking path.

## References
The skeleton code for this assignment was written by Prof. Jason Hinek of Carleton University.
