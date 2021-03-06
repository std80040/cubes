import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class MinMax {

	
	    Tree tree;

	    public void constructTree(int noOfCubes, int kCubes) {
	        tree = new Tree();
	        Node root = new Node(noOfCubes, true);
	        tree.setRoot(root);
	        constructTree(root,kCubes);
	    }

	    private void constructTree(Node parentNode,int kCubes) {
	        List<Integer> listofPossibleHeaps 
	          = GameOfCubes.getPossibleStates(parentNode.getNoOfCubes(),kCubes);
	        boolean isChildMaxPlayer = !parentNode.isMaxPlayer();
	        listofPossibleHeaps.forEach(n -> {
	            Node newNode = new Node(n, isChildMaxPlayer);
	            parentNode.addChild(newNode);
	            if (newNode.getNoOfCubes() > 0) {
	                constructTree(newNode,kCubes);
	            }
	        });
	    }
	    public boolean checkWin(Tree tree) {
	        Node root = tree.getRoot();
	        checkWin(root);
	        return root.getScore() == 1;
	    }

	    private void checkWin(Node node) {
	        List<Node> children = node.getChildren();
	        boolean isMaxPlayer = node.isMaxPlayer();
	        children.forEach(child -> {
	            if (child.getNoOfCubes() == 0) {
	                child.setScore(isMaxPlayer ? 1 : -1);
	            } else {
	                checkWin(child);
	            }
	        });
	        Node bestChild = findBestChild(isMaxPlayer, children);
	        node.setScore(bestChild.getScore());
	    }

	    private Node findBestChild(boolean isMaxPlayer, List<Node> children) {
	        Comparator<Node> byScoreComparator = Comparator.comparing(Node::getScore);
	        return children.stream()
	          .max(isMaxPlayer ? byScoreComparator : byScoreComparator.reversed())
	          .orElseThrow(NoSuchElementException::new);
	    }


}
	
	

