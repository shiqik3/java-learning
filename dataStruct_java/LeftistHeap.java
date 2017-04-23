package dataStruct_java;

public class LeftistHeap<AnyType extends Comparable<? super AnyType>>{
	public LeftistHeap(){
		root=null;
	}
	public void merge(LeftistHeap<AnyType> rhs){
		
	}
	public void insert(AnyType x){
		
	}
	public AnyType findMin(){
		
	}
	public AnyType deleteMin(){
		
	}
	
	public boolean isEmpty(){
		
	}
	public void makeEmpty(){
		
	}
	
	private static class Node<AnyType>{
		Node(AnyType theElement){
			this(theElement,null,null);
		}
		Node(AnyType theElement,Node<AnyType> lt,Node<AnyType> rt){
			element=theElement;
			left=lt;
			right=rt;
			npl=0;
		}
		AnyType element;
		Node<AnyType> left;
		Node<AnyType> right;
		int npl;
	}
	
	private Node<AnyType> root;
	
	private Node<AnyType> merge(Node<AnyType> h1,Node<AnyType> h2){
		
	}
	private Node<AnyType> merge1(Node<AnyType> h1,Node<AnyType> h2){
		
	}
	private void swapChildren(Node<AnyType> t){
		
	}
}