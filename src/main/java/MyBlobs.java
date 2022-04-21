import java.util.Deque;
import java.util.ArrayDeque;


public class MyBlobs extends Blobs{

	public MyBlobs(){}

	/** Helper method for the blobRecursive method. Recursively identifies all pixels in a given blob of ink.
	 *
	 * @param row row that pixel is in
	 * @param col column that pixel is in
	 * @param blobSoFar  A deque of pixels that the algorithm has visited already. Start with empty first.
	 * @return
	 */
	@Override
	public void blobRecursiveHelper(int row, int col, Deque<Pixel> blobSoFar){

		Pixel current = image.getPixel(row,col);

		if(!current.visited() && current.hasInk){
			current.setVisited(true);
			blobSoFar.addLast(current);

			if(current.getRow() - 1 >= 0){
				blobRecursiveHelper(row - 1, col, blobSoFar);
			}
			if(current.getCol() + 1 < image.cols){
				blobRecursiveHelper(row, col + 1, blobSoFar);
			}
			if(current.getRow() + 1 < image.rows){
				blobRecursiveHelper(row + 1, col, blobSoFar);
			}
			if(current.getCol() - 1 >= 0){
				blobRecursiveHelper(row, col - 1, blobSoFar);
			}

		} else return;
	}

	/** Iteratively identifies all pixels in a given blob of ink.
	 *
	 * @param row row that pixel is in.
	 * @param col column that pixel is in.
	 * @return A deque with Pixel objects. Pixel objects are all the pixels in the given blob of ink.
	 */
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



