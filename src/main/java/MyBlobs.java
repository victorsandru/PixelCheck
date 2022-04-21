// Victor Sandru
// 101231111

import java.util.Deque;
import java.util.ArrayDeque;

/* -----------------------------------------
   Note: The ArrayDeque is an implementation 
         of the Deque ADT. That is, it is a 
		 double-ended queue. 

		 You can simulate both a Stack and 
		 a regular Queue with this data structure
		 in the following way:

		 Stack: push  ~ addFirst
		        pop   ~ removeFirst
		
		 Queue: enqueue ~ addLast
		        dequeue ~ removeFirst
  ------------------------------------------ */

public class MyBlobs extends Blobs{

	// do NOT change or remove this constructor. We will use it to create 
	// objects when testing your code. If it is removed, we cannot test 
	// your code!
	public MyBlobs(){}
	
	@Override
	public void blobRecursiveHelper(int row, int col, Deque<Pixel> blobSoFar){

		Pixel current = image.getPixel(row,col);

		if(!current.visited() && current.hasInk){
			current.setVisited(true);
			blobSoFar.addLast(current);

			// check if pixel to up is greater than 0(row--)
			if(current.getRow() - 1 >= 0){
				blobRecursiveHelper(row - 1, col, blobSoFar);
			}
			// check if pixel right is greater than 0 (column++)
			if(current.getCol() + 1 < image.cols){
				blobRecursiveHelper(row, col + 1, blobSoFar);
			}
			// check if pixel down is greater than 0 (row++)
			if(current.getRow() + 1 < image.rows){
				blobRecursiveHelper(row + 1, col, blobSoFar);
			}
			//check if pixel left is greater than 0 (column--)
			if(current.getCol() - 1 >= 0){
				blobRecursiveHelper(row, col - 1, blobSoFar);
			}

		} else return;
	}

	//queue 
	@Override
	public Deque<Pixel> blobIterative(int row, int col){
		ArrayDeque<Pixel> blobList = new ArrayDeque<>();
		ArrayDeque<Pixel> workingList = new ArrayDeque<>();
		workingList.add(image.getPixel(row, col));
		while(!workingList.isEmpty()){
			Pixel p = workingList.poll();
			if(p.hasInk() && !p.visited()){
				p.setVisited(true);
				blobList.addLast(p);
				for(int i = 0; i < image.rows ; i++){
					for(int j = 0; j < image.cols; j++){
						Pixel q = image.getPixel(i, j);
						if(q == p) {
							if(q.getCol() - 1 >= 0){
								workingList.addLast(image.getPixel(i, j-1));
							}
							if(q.getRow() + 1 < image.rows){
								workingList.addLast(image.getPixel(i+1, j));
							}
							if(q.getCol() + 1 < image.cols){
								workingList.addLast(image.getPixel(i, j+1));
							}
							if(q.getRow() - 1 >= 0){
								workingList.addLast(image.getPixel(i-1, j));
							}
						}
					}
				}
			}
		}
		return blobList;
	}
		
}



