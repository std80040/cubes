import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Game {

	public static void main(String[] args) {
		
	
   Node root=new Node(10,true);
   
   System.out.println(root.getNoOfBones()+" "+root.getScore()+" "+root.isMaxPlayer+" "+root.getChildren());
    
   Node child1=new Node(5,true);
   root.addChild(child1);
   
   Node child2=new Node(3,true);
   root.addChild(child2);
   
   System.out.println(root.getNoOfBones()+" "+root.getScore()+" "+root.isMaxPlayer+" "+root.getChildren());

	
	
	
	}
     



}
