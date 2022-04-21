import java.util.Deque;
public class Quiz{
	static boolean verb = !true;

   public static int[][] qi = {
		{1,1}, {1,2}, {1,3}, {1,4}, {1,5},           {1,10},
		                                             {2,10},
		                                             {3,10},
		              {4,3},                         {4,10},
		              {5,3},                         {5,10},
             {6,2}, {6,3}, {6,4}, {6,5}, 
                    {7,3},                  {7,9},
                    {8,3},                         {8,10},
                                                          {9,11}, 
													    		                  {10,12},
		//									
		{11,1}, {11,2}, {11,3}, {11,4}, {11,5}, {11,6},
		{12,1},         {12,3}, {12,4},         {12,6},
		{13,1}, {13,2}, {13,3}, {13,4},         {13,6},
		{14,1}, {14,2}, {14,3}, {14,4}, {14,5}, {14,6},
		{15,1}, {15,2},                 {15,5}, {15,6},
		{16,1}, {16,2},                 {16,5}, {16,6},
		{17,1}, {17,2}, {17,3}, {17,4}, {17,5}, {17,6},
		        {18,2}, {18,3}, {18,4}, {18,5}, {18,6}	
	};
	public static Image makeQuizImage(){

		int rows=20, cols=15;
		Image img = new Image(rows, cols);
		for(int row=0; row<rows; row+=1){
			for(int col=0; col<cols; col+=1){
            img.setPixel(row, col, new Pixel(row, col, false));
			}
		}
		for(int[] rc : qi){
         img.setPixel(rc[0], rc[1], new Pixel(rc[0],rc[1], true));
		}
		return img;
	}
	public static void main(String[] args){
		
		Image img = makeQuizImage();
		//
		//
		int[][] start = {{1,2}, {2,10}, {6,4}, {9,11}, {13,2}};
		//
		//
		System.out.println(img);
		for(int[] rc : start){
			Blobs b = new MyBlobs();
			if(!verb)img.clearExtra();
			b.setImage(img);
			Deque<Pixel> blob = b.blobRecursive(rc[0], rc[1]);
			System.out.println("RECURSIVE start at : " + rc[0] + "," + rc[1]);
			System.out.println(blob);
			if(verb)System.out.println(img.show_walk(blob));
		}

      img = makeQuizImage();
		System.out.println("\n##############################################\n");
		for(int[] rc : start){
			Blobs b = new MyBlobs();
			if(!verb)img.clearExtra();
			b.setImage(img);
			Deque<Pixel> blob = b.blobIterative(rc[0], rc[1]);
			System.out.println("ITERATIVE start at : " + rc[0] + "," + rc[1]);
			System.out.println(blob);
			if(verb)System.out.println(img.show_walk(blob));
		}

		System.out.println();
	}

}
