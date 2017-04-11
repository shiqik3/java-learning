package dataStruct_java;

public class MyQueueAdt<AnyType> implements Iterable<AnyType>{
	//循环数组adt队列
	private int theSize;    //队列预分配空间
	private int front;    //队列位置参数front
	private int nowSize;    //目前队列空间
	private int currentSize;    //队列长度（队列实际存在元素个数）
	private int modCount;    //队列操作次数数（每执行一次入队或出队操作+1）
	private int back;    //队列位置参数back
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
		front=0;
		back=-1;
		theSize=10;
		currentSize=0;
		nowSize=0;
		modCount=0;
	}
	private void init(){
		for(int i=0;i<theSize;i++){
			push(null);
		}
	}
	public MyQueueAdt(){
		doClear();
		init();
	}
	public void clear(){
		doClear();
		init();
	}
	public int currentSize(){
		return currentSize;
	}
	public int nowSize(){
		return nowSize;
	}
	public boolean isEmpty(){
		return currentSize()==0;
	}
	public boolean isFull(){
		return currentSize()==theSize;
	}
	public void enqueue(AnyType x){
		if((back+1)==10){
			back=-1;
		}
		enqueue(getNode(back+1),x);    //封装入队操作
	}
	private void enqueue(Node<AnyType> p,AnyType x){
		if(isFull()){
			System.out.println("队列已经满了");
		}else{
			p.data=x;    //入队操作
			modCount++;
			currentSize++;
			back++;
		}
	}
	public void dequeue(){
		dequeue(getNode(front));    //封装出队操作
	}
	private void dequeue(Node<AnyType> p){
		if(!isEmpty()){
			p.data=null;    //出队操作
			front++;
			modCount++;
			currentSize--;
			if(front==10){
				front=0;
			}
		}else{
			System.out.println("队列已经空了");
		}
	}
	private boolean push(AnyType x){
		add(nowSize(),x);
		return true;
	}
	private void add(int idx,AnyType x){
		addBefore(getNode(idx,0,nowSize()),x);
	}
	private void addBefore(Node<AnyType> p,AnyType x){
		Node<AnyType> newNode=new Node(x,p.prev,p);
		p.prev.next=newNode;
		p.prev=newNode;
		nowSize++;
	}
	private AnyType pop(){
		return pop(getNode(nowSize()-1));
	}
	private AnyType pop(Node<AnyType> p){
		p.prev.next=p.next;
		p.next.prev=p.prev;
		nowSize--;
		return p.data;
	}
	private Node<AnyType> getNode(int idx){
		return getNode(idx,0,nowSize()-1);
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
		if(idx<nowSize()/2){
			p=beginMarker.next;
			for(int i=0;i<idx;i++){
				p=p.next;
			}
		}
		else{
			p=endMarker;
			for(int i=nowSize();i>idx;i--){
				p=p.prev;
			}
		}
		return p;
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
			MyQueueAdt.this.pop(current.prev);
			expectedModCount++;
			okToRemove=false;
		}
	}
	
	
	public void display(MyQueueAdt adt){
		for(int i=0,j=front;i<currentSize;i++,j++){
			System.out.print(getNode(j).data+" ");
			if(j==10){
				j=0;
			}
			if(i%10==9){
				System.out.println();
			}
		}
	}
	
	
	
	public static void main(String[]args){
		//java程序主入口
		MyQueueAdt list=new MyQueueAdt();
		for(int i=0;i<10;i++){
			list.enqueue((int)(Math.random()*100));
		}
		list.display(list);
		list.enqueue(8);
		for(int i=0;i<11;i++){
			list.dequeue();
		}
		list.display(list);
	}
}

