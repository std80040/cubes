import java.util.ArrayList;
import java.util.List;

public class Node {
    
	int noOfCubes;
    boolean isMaxPlayer;
    int score;
    List<Node> children;
    
  
    
    public Node(int noOfCubes, boolean isMaxPlayer) {
		super();
		this.noOfCubes = noOfCubes;
		this.isMaxPlayer = isMaxPlayer;
		this.children=new ArrayList<Node>();
		this.score=0;
		
		
	}
    
	public Node() {
		
	}

	public int getNoOfCubes() {
		return noOfCubes;
	}
	public void setNoOfCubes(int noOfCubes) {
		this.noOfCubes = noOfCubes;
	}
	public boolean isMaxPlayer() {
		return isMaxPlayer;
	}
	public void setMaxPlayer(boolean isMaxPlayer) {
		this.isMaxPlayer = isMaxPlayer;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public List<Node> getChildren() {
		return children;
	}
	public void setChildren(List<Node> children) {
		this.children = children;
	}
    
	public void addChild(Node child) {
		this.children.add(child);
	}
    
    
}