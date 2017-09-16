package dataStruct_java;

public class LeftistHeap<AnyType extends Comparable<? super AnyType>>{
	public LeftistHeap(){
		root=null;
	}
	/**
	 * Merge rhs into the priority queue
	 * rhs becomes empty. rhs must be different from this
	 * @param rhs the other leftist heap
	 */
	public void merge(LeftistHeap<AnyType> rhs){
		if(this==rhs){
			return;
		}
		root=merge(root,rhs.root);
		rhs.root=null;
	}
	/**
	 * Insert into the priority queue,maintaining heap order
	 * @param x the item to insert
	 */
	public void insert(AnyType x){
		root=merge(new Node<>(x),root);
	}
	public AnyType findMin(){
		return root.element;
	}
	/**
	 * Remove the smallest item from the priority queue.
	 * @return the smallest item,or throw UnderflowException if empty
	 * @throws Exception 
	 */
	public AnyType deleteMin(){
		if(isEmpty()){
			System.out.println("数组下溢异常");
			System.exit(0);
		}
		AnyType minItem=root.element;
		root=merge(root.left,root.right);
		
		return minItem;
	}
	
	public boolean isEmpty(){
		return root==null;
	}
	public void makeEmpty(){
		root=null;
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
		if(h1==null){
			return h2;
		}else if(h2==null){
			return h1;
		}else if(h1.element.compareTo(h2.element)<0){
			return merge1(h1,h2);
		}else{
			return merge(h2,h1);
		}
	}
	/**
	 * Internal method to merge two roots.
	 * Assumes trees are not empty,and h1's root contains smallest item.
	 * @param h1
	 * @param h2
	 * @return
	 */
	private Node<AnyType> merge1(Node<AnyType> h1,Node<AnyType> h2){
		if(h1.left==null){
			h1.left=h2;
		}else{
			h1.right=merge(h1.right,h2);
			if(h1.left.npl<h1.right.npl){
				swapChildren(h1);
				h1.npl=h1.right.npl+1;
			}
		}
		return h1;
	}
	private void swapChildren(Node<AnyType> t){
		Node<AnyType> tmp=t.left;
		t.left=t.right;
		t.right=tmp;
	}
}