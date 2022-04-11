import java.util.List;


public class ViewTreeOfStates {

	public static void main(String[] args) {
		MinMax playerMax=new MinMax();
		playerMax.constructTree(4,3);	
		Tree allPosibleMoves=playerMax.tree;
		playerMax.checkWin(allPosibleMoves);
		viewState(allPosibleMoves.getRoot());
		}

	static void viewState(Node node) {
	        System.out.println("State No."+node.getNoOfCubes());
            List<Node> childrens=node.getChildren();
	        viewChildrens(childrens);
	            childrens.forEach(child->{
	            	if(child.getChildren().isEmpty()) {
	            	   return;
	            	}
	            System.out.println();
	            viewState(child);
	            });
           }

	static void  viewChildrens(List<Node> childrens) {
		             childrens.forEach(child->{
		             System.out.print(child.getNoOfCubes()+"->"+child.getScore()+"  ");
		             });
                 }

}





