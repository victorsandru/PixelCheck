import java.util.Deque;
public class SampleQuiz{

   public static int[][] qi = {
		{0,0}, {0,1}, {0,2}, {0,3}, {0,4},
		{1,2},                                             {1,11}, {1,12}, {1,13}, {1,14},   {1,18},
		{2,2},                                             {2,11},                           {2,18},
		{3,2},  {3,4}, {3,5}, {3,6}, {3,7}, {3,8},         {3,11},           {3,16}, {3,17}, {3,18}, {3,19}, {3,20},
		{4,2},  {4,4}, {4,5}, {4,6}, {4,7}, {4,8}, {4,9},  {4,11}, {4,12}, {4,13}, {4,14},   {4,18},
		{5,2},  {5,4}, {5,5},               {5,8}, {5,9},                          {5,14},   {5,18},
		        {6,4}, {6,5}, {6,6}, {6,7}, {6,8}, {6,9},                          {6,14},   {6,18},
		        {7,4}, {7,5}, {7,6}, {7,7}, {7,8},         {7,11}, {7,12}, {7,13} ,{7,14},   {7,18},  {7,20},
		        {8,4}, {8,5},
		        {9,4}, {9,5 }, {9,6 }, {9,7 }, {9,8 }, {9,9 }, {9 ,10}, { 9,11},   {9,14}, {9,15}, {9,16}, {9,17},
		        {10,4},{10,5}, {10,6}, {10,7}, {10,8}, {10,9}, {10,10}, {10,11},   {10,14}, {10,15}, {10,16}, {10,17},
			 	  {11,4},{11,5}, {11,6}, {11,7}, {11,8}, {11,9}, {11,10}, {11,11},   {11,14}, {11,15}, {11,16}, {11,17},
	  	                                                                           {12,14}, {12,15}, {12,16}, {12,17}
	};
	public static Image makeQuizImage(){
		int rows=14, cols=21;
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
		int[][] start = {{1,2}, {7,20}, {11,15}, {11,2}};
		System.out.println(img);
		for(int[] rc : start){
			Blobs b = new MyBlobs();
			img.clearExtra();
			b.setImage(img);
			Deque<Pixel> blob = b.blobRecursive(rc[0], rc[1]);
			System.out.println("RECURSIVE start at : " + rc[0] + "," + rc[1]);
			System.out.println(blob);
			//System.out.println(img.show_walk(blob));
		}

      img = makeQuizImage();
		System.out.println("\n##############################################\n");
		for(int[] rc : start){
			Blobs b = new MyBlobs();
			img.clearExtra();
			b.setImage(img);
			Deque<Pixel> blob = b.blobIterative(rc[0], rc[1]);
			System.out.println("ITERATIVE start at : " + rc[0] + "," + rc[1]);
			System.out.println(blob);
			//System.out.println(img.show_walk(blob));
		}


	}

}
