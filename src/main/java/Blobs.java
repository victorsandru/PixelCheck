import java.util.Deque;
import java.util.ArrayDeque;

public abstract class Blobs{

	public Image image;

	public Blobs(){}
	public Blobs(Image image){
		this.image = image;
	}
	public final void setImage(Image image){
		this.image = image;
	}

	public final Deque<Pixel> blobRecursive(int row, int col){
		// wrapper for the recursive helper function
		Deque<Pixel> blobSoFar = new ArrayDeque<Pixel>();
		blobRecursiveHelper(row, col, blobSoFar);
        return blobSoFar;
	}


	public abstract void blobRecursiveHelper(int row, int col, Deque<Pixel> blobSoFar);

	public abstract Deque<Pixel> blobIterative(int row, int col);
	


}
