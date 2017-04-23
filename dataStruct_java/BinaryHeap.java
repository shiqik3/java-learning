package dataStruct_java;

public class BinaryHeap<AnyType extends Comparable<? super AnyType>>{
	public BinaryHeap(){
		this(DEFAULT_CAPACITY);
	}
	public BinaryHeap(int capacity){
		array=(AnyType[])new Comparable[DEFAULT_CAPACITY];
	}
	public BinaryHeap(AnyType[]items){
		currentSize=items.length;
		array=(AnyType[])new Comparable[(currentSize+2)*11/10];
		
		int i=1;
		for(AnyType item:items){
			array[i++]=item;
		}
		buildHeap();
	}
	
	/**
	 * Insert into the priority queue,maintaining heap order.
	 * Duplicate are allowed
	 * @param x the item to insert.
	 */
	public void insert(AnyType x){
		if(isFull()){
			enlargeArray(array.length*2+1);
		}
		array[++currentSize]=x;
		percolateUp(currentSize);
	}
	public AnyType findMin(){
		return array[1];
	}
	public AnyType deleteMin(){
		if(isEmpty()){
			System.out.println("Êý×éÏÂÒç");
		}
		AnyType minItem=findMin();
		array[1]=array[currentSize--];
		percolateDown(1);
		
		return minItem;
	}
	public boolean isEmpty(){
		return currentSize==0;
	}
	public boolean isFull(){
		return currentSize==array.length-1;
	}
	public void makeEmpty(){
		currentSize=0;
	}
	
	private static final int DEFAULT_CAPACITY=10;
	
	private int currentSize;
	private AnyType[]array;
	
	private void percolateUp(int hole){
		int parent;
		AnyType tmp=array[hole];
		for(;hole/2>0;hole=parent){
			parent=hole/2;
			if(array[parent].compareTo(tmp)>0){
				array[hole]=array[parent];
			}else{
				break;
			}
		}
		array[hole]=tmp;
	}
	private void percolateDown(int hole){
		int child;
		AnyType tmp=array[hole];
		for(;hole*2<=currentSize;hole=child){
			child=hole*2;
			if(child!=currentSize&&
					array[child+1].compareTo(array[child])<0){
				child++;
			}
			if(array[child].compareTo(tmp)<0){
				array[hole]=array[child];
			}else{
				break;
			}
		}
		array[hole]=tmp;
	}
	private void buildHeap(){
		for(int i=currentSize/2;i>0;i--){
			percolateUp(i);
		}
	}
	private void enlargeArray(int newSize){
		AnyType[] oldlist=array;
		array=(AnyType[])new Comparable[array.length*2];
		for(int i=1;i<oldlist.length;i++){
			array[i]=oldlist[i];
		}
	}
	private void BinaryPrint(){
		for(int i=1;i<=currentSize;i++){
			System.out.print(array[i]+" ");
		}
	}
	
	public static void main(String[]args){
		BinaryHeap heap=new BinaryHeap();
		for(int i=0;i<10;i++){
			heap.insert((int)(Math.random()*100));
		}
		heap.BinaryPrint();
	}
}