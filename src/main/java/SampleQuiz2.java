import java.util.Deque;
public class SampleQuiz2{
	static boolean verb = !true;

   public static int[][] qi = {
	          {0,2}, {0,3}, {0,4},
		{1,1}, {1,2},        {1,4},
		{2,1}, {2,2}, {2,3}, {2,4},
		{3,1}, {3,2}, {3,3}, {3,4},
		{4,1},        {4,3},
		{5,1}, {5,2}, {5,3}, {5,4},
		{6,1}, {6,2}, {6,3}, {6,4},
		{7,1}, {7,2},        {7,4},
		{8,1}, {8,2}, {8,3}, {8,4},
		{9,1}, {9,2}, {9,3}, {9,4}
	};

	public static Image makeQuizImage(){
		int rows=12, cols=6;
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
		int start_row = 0;
      int start_col = 0;
      if(args.length != 2){
         System.out.println("\n-------------------------");
         System.out.println("usage: java SampleQuiz2 r c");
         System.out.println("       where r and c are integers provided in Brightspace");
         System.out.println("-------------------------");
         return;
      }
      start_row = Integer.parseInt(args[0]);
      start_col = Integer.parseInt(args[1]);

		//
		//
		int[][] start = {{start_row,start_col}};
		//
		//

      Image img = makeQuizImage();
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


	}

}
