import java.util.Deque;
public class SampleRun{


	public static void main(String[] args){
		int r=10,c=15;
		double p = 0.5;
		if(args.length > 0){
			try{
				r = Integer.parseInt(args[0]);
				c = Integer.parseInt(args[1]);
				p = Double.parseDouble(args[2]);
			}catch(Exception e){
				
			}
		}

		/* random image
		Image img = Image.makeRandomImage(r,c,p);
		System.out.println(img);
		Blobs b = new MyBlobs();
		b.setImage(img);
		Deque<Pixel> blob00 = b.blobRecursive(0, 0);
		System.out.println(blob00);
		*/

		Image img = Image.makeTestImage();
		int[][] start = {{1,2}, {7,5}, {4,13}, {5,18}, {7,20}, {11,15}, {11,2}};
		System.out.println(img);
		for(int[] rc : start){
			Blobs b = new MyBlobs();
			img.clearExtra();
			b.setImage(img);
			Deque<Pixel> blob = b.blobIterative(rc[0], rc[1]);
			System.out.println("start at : " + rc[0] + "," + rc[1]);
			System.out.println(blob);
			System.out.println(img.show_walk(blob));
		}

	}


}
