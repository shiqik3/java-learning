package dataStruct_java;

public class SplayTree <AnyType extends Comparable<? super AnyType>>{
	public static class Node<AnyType>{
		public AnyType element;
		public Node left;
		public Node right;
		public int height;
		Node(AnyType theElement){
			this(theElement,null,null,0);
		}
		Node(AnyType theElement,Node<AnyType> lt,Node<AnyType> rt,int h){
			element=theElement;
			left=lt;
			right=rt;
			height=h;
		}
	}
	
	private Node root;
	public void insert(AnyType x){
		insert(x,root);
	}
	private void insert(AnyType x,Node<AnyType> t){
		if(t==null){
			t=new Node(x,null,null,0);
		}
		int compareResult=x.compareTo(t.element);
		if(compareResult<0){
			insert(x,t.left);
		}else if(compareResult>0){
			insert(x,t.right);
		}else{
			System.out.println("插入失败，数值相同");
		}
	}
	
	
}
