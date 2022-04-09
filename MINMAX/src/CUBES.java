import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
//GAME OF CUBES
public class CUBES {
  
	static int maxMove=0;
	
	public static void main(String[] args) {
	
	
	Scanner scanner= new Scanner(System.in);  
	System.out.println("Set number of cubes on the table:");	
	
	int cubesNo=scanner.nextInt();
	
	
	System.out.println("Set number of cubes to take from the table except 1 or 2 :");
	int kCubes=scanner.nextInt();
	//int [] resCubes={1,2,kCubes};
	
	List<CUBE> board = createBoard(cubesNo);
	System.out.println();
	
	System.out.println("GAME START !!!");
	System.out.println();
	
	printBoard(board);
	System.out.println();
	System.out.println();
	
	
		MinMax playerMax=new MinMax();
    
		while (board.size()>0) {
		
	playerMax.constructTree(board.size(),kCubes);	
	Tree allPosibleMoves=playerMax.tree;
	playerMax.checkWin(allPosibleMoves);
	List<Node> nextMoves=new ArrayList<Node>();
	nextMoves=allPosibleMoves.getRoot().getChildren();
	
	nextMoves.forEach(child -> {
	
		if(child.getScore()==1) {
			maxMove=board.size()-child.getNoOfBones();
		}
	});
	if (maxMove==0) {
		maxMove=board.size()-nextMoves.get(0).getNoOfBones();
	}
	
	
	System.out.print("PC PLAYS");
	for(int i=1;i<=3;i++) {
		System.out.print(".");
		delay(1);
	}
	
	System.out.println();
	System.out.println("PC take "+maxMove+" Cubes from the table");
	System.out.println();
	
	playerMove(board,maxMove);
	if(board.size()==0) {
	System.out.println("THE WINNER IS PC !!!");
	break;
	}
	else {
	     printBoard(board);
	     System.out.println();
	     }
	System.out.println();
	System.out.println("You can take (1 or 2 or "+ kCubes+") cubes from the table :");
	int resCubesNo=scanner.nextInt();
	
	//¸ëåã÷ïò åéóáãùãÞò ìç áðïäåêôþí ôéìþí (1,2,Ê)
	while ((resCubesNo !=1 && resCubesNo !=2 && resCubesNo !=kCubes)){ 
		
		  System.out.println("You are not allowed to take "+resCubesNo+" Cubes from the table !");
		  System.out.println();
		  printBoard(board);
		  System.out.println();
		  System.out.println("Take (1 or 2 or "+ kCubes+") cubes :");
	      resCubesNo=scanner.nextInt();
	}
		
		//Åëåã÷ïò åéóáãùãÞò ôéìÞò>áñéèìüò êýâùí óôï ôñáðÝæé
		while(resCubesNo > board.size()) {
		 System.out.println();
		 System.out.println("You try to take more Cybes than the board !");
		 System.out.println();
		 printBoard(board);
		 System.out.println();
		 System.out.println("Take (1 or 2 or "+ kCubes+") cubes :");
		 resCubesNo=scanner.nextInt();
		}
		

	
	System.out.println();
	playerMove(board,resCubesNo);
	if(board.size()==0) {
		System.out.println("THE WINNER IS THE PLAYER !!!");
		break;
		}
		else {
		     printBoard(board);
	         System.out.println();
	         }		
	
	}
	
		scanner.close();
		
	}//main-----------------------------------------

	
	public static List<CUBE> createBoard(int cubesNumber) {
		CUBE cube=new CUBE();
		List<CUBE> board=new ArrayList<>();
		for(int i=0;i<cubesNumber;i++) {
			board.add(i, cube);
			}
	return board;
	}
	
	public static void printBoard(List<CUBE> board) {
		for(int i=0;i<=board.size()-1;i++) {
		System.out.print(board.get(i).getCube());
		}
		System.out.println();
		    for(int i=1;i<=board.size()*4;i++) {
			System.out.print("=");
			}
	
	}
	
	public static void playerMove(List<CUBE> board, int resetCubes) {
		for(int i=0;i<resetCubes;i++) {
		board.remove(0);
		}
	}
	
	public static int getRandomElement(int[] arr){
	    return arr[ThreadLocalRandom.current().nextInt(arr.length)];
	}
	
	public static void delay(int sec) {
		try {
		    TimeUnit.SECONDS.sleep(sec);
	        } catch (InterruptedException e) {
		            e.printStackTrace();
	                }
	}
	
	
}
