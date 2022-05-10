# PixelCheck
## Introduction
This project is originally a school assignment from COMP1006.

The objective is to create two algorithms that finds connecting squares when given a set of coordinates. There is either a iterative option or recursive algorithm to choose from. 
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

First it creates a grid of rows and columns. In this grid there are specific pixels that may or may not have ink within them. If the pixel has ink, it is visible on the visible grid.

Within the grid, there can be blobs of ink. These blobs are inked pixels that are connected either vertically or horizontally. Diagonal connections do not apply.
<!-- Creates an Image object. An image object consists of a 2d grid of Pixel objects. These Pixel objects location is specified by their respective row and column in the image. The Pixels can also be have "ink" in them. Meaning that you can see the pixel. -->

<!-- In the Image object, there can be 'blobs' of ink. The blob object represents where one or more pixels have ink and are immediate neighbours in the image. Immediate neighbours are only pixels that have other pixels either horizontally or vertically and have ink. Diagonals do not apply. -->

Here is an example: <br/>

![pixel placement example](/docs/pixelPlacementExample.png) <br/>

The left most blob is made of 3 orange pixels. The middle blob consists of only one teal pixel. The right most blob has 3 navy blue pixels. Notice teal and navy pixels are different blobs.

When the algorithm is run, it will return an array of coordinates of all pixels within the blob. Moreover, a grid will be printed. If the inputted coordinates are within a blob, the grid will showcase the walking path of the algorithm. 
<!-- There are two different algorithms to find all the pixels in a given blob. I have implemented both a recursive and a iterative method. -->
## Starting the search

Choose to either use the recursive or iterative algorithm. Both algorithms will return the same results. Only difference between the two is of course it's methodology but also its path. The recursive algorithm is based upon a Depth-first Search algorithm, while the iterative is based on a Breadth-first Search.


After installing the required files, run the SampleRun(iterative or recursion) class. This class will start the explore algorithm at the inputted coordinates.

An array of coordinates will be returned and outputted to console. These coordinates are all of the pixels within the same blob as the inputted pixel. If the array is empty, then there is no ink at the given coordinate.

<!-- The Image object will be printed onto console and if your inputted coordinates have any blobs, it will display an array of all the pixels in the blob along with a display of the Image object. -->

In the image display, all pixels in the given blob will be marked with numbers. These numbers represent the order of when the algorithm reached that certain pixel.

As mentioned prior, the grid will be printed onto console along with an array of coordinates. Here is an example of a start location of (1,2).
<br/>
![image display placement](/docs/imageDisplayExample.png)
<br/>

The start location starts at the first row, and second column. Since this specifed pixel has ink, it will start the explore algorithm. Within the returned array, the walking path of the algorithm will display in order. The order will also show in the grid, where the path is specififed with it's respective number.
<!-- 
Here the original pixel starts at the first row, and second column. Since this pixel is in a blob, the array of all pixels in the blob is displayed. Afterwards the image is displayed with the algorithms walking path. -->

## Editing Parameters
To change where the algorithms start, head to line 19 of the SampleRun (iterative or recursion) class. Here you can specify where the explore algorithm starts.
# References
The skeleton code for this assignment was written by Prof. Jason Hinek of Carleton University.
