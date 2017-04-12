package dataStruct_java;

public class ExpressionTree<AnyType>{
	private int theSize;
	private int theLength;
	private AnyType[]theItems;
	
	private static class TreeNode<AnyType>{
		private AnyType element;
		private TreeNode<AnyType> left;
		private TreeNode<AnyType> right;
		TreeNode(AnyType x){
			this(x,null,null);
		}
		TreeNode(AnyType e,TreeNode<AnyType> lt,TreeNode<AnyType> rt){
			element=e;
			left=lt;
			right=rt;
		}
	}
	
	private TreeNode<AnyType> root;
	
	public ExpressionTree(){
		root=null;
	}
	public void makeEmpty(){
		root=null;
	}
	public boolean isEmpty(){
		return root==null;
	}
	public void printTree(){
		printTree(root);
	}
	
	private void printTree(TreeNode<AnyType> t){
		if(t!=null){
			printTree(t.left);
			System.out.print(t.element+" ");
			printTree(t.right);
		}
	}
	
	
	
}





