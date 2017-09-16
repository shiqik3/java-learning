package dataStruct_java;

import java.util.Iterator;

public class MyLinkedList<AnyType> implements Iterable<AnyType>{
	private int theSize;
	private int modCount=0;
	private Node<AnyType> beginMarker;
	private Node<AnyType> endMarker;
	
	private static class Node<AnyType>{
		public Node(AnyType d,Node<AnyType> p,Node<AnyType> n){
			data=d;
			prev=p;
			next=n;
		}
		public AnyType data;
		public Node<AnyType> prev;
		public Node<AnyType> next;
	}
	private void doClear(){
		beginMarker=new Node<AnyType>(null,null,null);
		endMarker=new Node<AnyType>(null,beginMarker,null);
		beginMarker.next=endMarker;
		theSize=0;
		modCount++;
	}
	public MyLinkedList(){
		doClear();
	}
	public void clear(){
		doClear();
	}
	public int size(){
		return theSize;
	}
	public boolean isEmpty(){
		return size()==0;
	}
	public boolean add(AnyType x){
		add(size(),x);
		return true;
	}
	public void add(int idx,AnyType x){
		addBefore(getNode(idx,0,size()),x);
	}
	public AnyType set(int idx,AnyType newVal){
		Node<AnyType> p=getNode(idx);
		AnyType oldVal=p.data;
		p.data=newVal;
		return oldVal;
	}
	public AnyType remove(int idx){
		return remove(getNode(idx));
	}
	private void addBefore(Node<AnyType> p,AnyType x){
		Node<AnyType> newNode=new Node(x,p.prev,p);
		p.prev.next=newNode;
		p.prev=newNode;
		theSize++;
		modCount++;
	}
	private AnyType remove(Node<AnyType> p){
		p.prev.next=p.next;
		p.next.prev=p.prev;
		theSize--;
		modCount++;
		return p.data;
	}
	private Node<AnyType> getNode(int idx){
		return getNode(idx,0,size()-1);
	}
	private Node<AnyType> getNode(int idx,int lower,int upper){
		/*
		 * 不完善的寻找第几个节点的函数
		 * lower与upper并没有起作用
		 */
		Node<AnyType> p;
		if(idx<lower||idx>upper){
			throw new IndexOutOfBoundsException();
		}
		if(idx<size()/2){
			p=beginMarker.next;
			for(int i=0;i<idx;i++){
				p=p.next;
			}
		}
		else{
			p=endMarker;
			for(int i=size();i>idx;i--){
				p=p.prev;
			}
		}
		return p;
	}
	private void exChange(Node<AnyType> x,Node<AnyType> y){
		Node<AnyType> p;
		p=x;
		x=y;
		y=p;
	}
	public java.util.Iterator<AnyType> iterator(){
		return new LindedListIterator();
	}
	private class LindedListIterator implements java.util.Iterator<AnyType>{
		private Node<AnyType> current=beginMarker.next;
		private int expectedModCount=modCount;
		private boolean okToRemove=false;
		
		public boolean hasNext(){
			return current!=endMarker;
		}
		public AnyType next(){
			if(modCount!=expectedModCount){
				throw new java.util.ConcurrentModificationException();
			}
			if(!hasNext()){
				throw new java.util.ConcurrentModificationException();
			}
			AnyType nextItem=current.data;
			current=current.next;
			okToRemove=true;
			return nextItem;
		}
		public void remove(){
			if(modCount!=expectedModCount){
				throw new java.util.ConcurrentModificationException();
			}
			if(!okToRemove){
				throw new IllegalStateException();
			}
			MyLinkedList.this.remove(current.prev);
			expectedModCount++;
			okToRemove=false;
		}
	}
	
	
	public void display(){
		for(int i=0;i<size();i++){
			System.out.print(getNode(i).data+" ");
		}
	}
	
	
	
	public static void main(String[]args){
		//java程序主入口
		MyLinkedList list=new MyLinkedList();
		for(int i=0;i<50;i++){
			list.add((int)(Math.random()*100));
		}
		list.display();
		System.out.println();
		Iterator iterator=list.iterator();
		System.out.println(iterator.next());
		iterator.remove();
		System.out.println(iterator.hasNext());
		list.display();
	}
}












