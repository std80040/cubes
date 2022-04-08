import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class CUBES {
  
	static int maxMove=0;
	
	public static void main(String[] args) {
	
	
	Scanner scanner= new Scanner(System.in);   
	System.out.println("Number of cubes:");	
	
	int cubesNo=scanner.nextInt();
	
	
	System.out.println("Choose Ê cubes to reset:");
	int kCubes=scanner.nextInt();
	int [] resCubes={1,2,kCubes};
	
	List<CUBE> board = createBoard(cubesNo);
	printBoard(board);
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
	
	
	
	System.out.println("PC take "+maxMove+" Cubes from the table");
	playerMove(board,maxMove);
	if(board.size()==0) {
	System.out.println("THE WINNER IS PC !!!");
	break;
	}
	else {
	     printBoard(board);
	     System.out.println();
	     }
	
	System.out.println("You can take (1 or 2 or "+ kCubes+") cubes from the table :");
	int resCubesNo=scanner.nextInt();
	
	while ((resCubesNo !=1 && resCubesNo !=2 && resCubesNo !=kCubes)){ 
		
		if(resCubesNo !=1 && resCubesNo !=2 && resCubesNo !=kCubes) {
		  System.out.println("You are not allowed to take "+resCubesNo+" Cubes from the table !");
		  printBoard(board);
		  
		}
		if(resCubesNo > board.size()) {
		 System.out.println();
		 System.out.println("You try to take more Cybes than the board !");
		 printBoard(board);
		}
		System.out.println();
		System.out.println("Take (1 or 2 or "+ kCubes+") cubes :");
		resCubesNo=scanner.nextInt();
		
	}
	while(resCubesNo > board.size()) {
		 System.out.println();
		 System.out.println("You try to take more Cybes than the board have !");
		 printBoard(board);
		 resCubesNo=scanner.nextInt();
		}
	
	
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
	}
	
	public static void playerMove(List<CUBE> board, int resetCubes) {
		for(int i=0;i<resetCubes;i++) {
		board.remove(0);
		}
	}
	
	public static int getRandomElement(int[] arr){
	    return arr[ThreadLocalRandom.current().nextInt(arr.length)];
	}
	
}
