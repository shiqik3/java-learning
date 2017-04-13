package dataStruct_java;

public class BinarySearchTree <AnyType extends Comparable <?super AnyType>>{
	private static class BinaryNode<AnyType>{
		//Constructors
		BinaryNode(AnyType theElement){
			this(theElement,null,null);
		}
		BinaryNode(AnyType theElement, BinaryNode<AnyType> lt,BinaryNode<AnyType> rt){
			element=theElement;
			left=lt;
			right=rt;
		}
		AnyType element;    //The data in the node
		BinaryNode<AnyType> left;    //Left child
		BinaryNode<AnyType> right;    //Right child
	}
	private BinaryNode<AnyType> root;
	
	public BinarySearchTree(){
		root=null;
	}
	
	public void makeEmpty(){
		root=null;
	}
	public boolean isEmpty(){
		return root==null;
	}
	
	public boolean contains(AnyType x){
		return contains(x,root);
	}
	public AnyType findMin(){
		if(isEmpty()){
			//throw new UnderflowException();
			System.out.println("搜索失败，树为空");
		}
		return findMin(root).element;
	}
	public AnyType findMax(){
		if(isEmpty()){
			//throw new UnderflowException();
			System.out.println("搜索失败，树为空");
		}
		return findMax(root).element;
	}
	public void insert(AnyType x){
		root=insert(x,root);
	}
	public void remove(AnyType x){
		root=remove(x,root);
	}
	public void printTree(){
		if(isEmpty()){
			System.out.println("Empty tree");
		}else{
			printTree(root);
		}
	}
	
	/**
	 * Internal method to find an item in a subtree.
	 * @param x is item to search for
	 * @param t the node that roots the sutree.
	 * @return true if the item is found;false otherwise.
	 */
	private boolean contains(AnyType x,BinaryNode<AnyType> t){
		if(t==null){
			return false;
		}
		int compareResult=x.compareTo(t.element);
		if(compareResult<0){
			return contains(x,t.left);
		}else if(compareResult>0){
			return contains(x,t.right);
		}else{
			return true;
		}
	}
	private BinaryNode<AnyType> findMin(BinaryNode<AnyType> t){
		if(t==null){
			return null;
		}else if(t.left==null){
			return t;
		}
		return findMin(t.left);
	}
	private BinaryNode<AnyType> findMax(BinaryNode<AnyType> t){
		if(t!=null){
			while(t.right!=null){
				t=t.right;
			}
		}
		return t;
	}
	
	private BinaryNode<AnyType> insert(AnyType x,BinaryNode<AnyType> t){
		if(t==null){
			return new BinaryNode<>(x,null,null);
		}
		int compareResult=x.compareTo(t.element);
		if(compareResult<0){
			t.left=insert(x,t.left);
		}else if(compareResult>0){
			t.right=insert(x,t.right);
		}else{
			System.out.println("插入失败，插入数与节点相等");;
		}
		return t;
	}
	private BinaryNode<AnyType> remove(AnyType x,BinaryNode<AnyType> t){
		if(t==null){
			return t;
		}
		int compareResult=x.compareTo(t.element);
		if(compareResult>0){
			t.left=remove(x,t.left);
		}else if(compareResult<0){
			t.right=remove(x,t.right);
		}else if(t.left!=null&&t.right!=null){
			t.element=findMin(t.right).element;
			t.right=remove(t.element,t.right);
		}else{
			t=(t.left!=null)?t.left:t.right;
		}
		return t;
	}
	private void printTree(BinaryNode<AnyType> t){
		if(t!=null){
			printTree(t.left);
			System.out.print(t.element+" ");
			printTree(t.right);
		}
	}
	private int height(BinaryNode<AnyType> t){
		if(t==null){
			return -1;
		}else{
			return 1+Math.max(height(t.left), height(t.right));
		}
	}
	
	
	
	public static void main(String[]args){
		BinarySearchTree st=new BinarySearchTree();
		for(int i=0;i<20;i++){
			st.insert((int)(Math.random()*100));
		}
		st.printTree();
	}
}














