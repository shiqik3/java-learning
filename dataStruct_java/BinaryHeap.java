package dataStruct_java;

import java.util.ArrayList;

public class BinaryHeap<AnyType extends Comparable<? super AnyType>>{
	public BinaryHeap(){
		this(DEFAULT_CAPACITY);
	}
	public BinaryHeap(int capacity){
		array=(AnyType[]) new ArrayList[capacity];
		for(int i=0;i<capacity;i++){
		}
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
		if(currentSize==array.length-1){
			enlargeArray(array.length*2+1);
		}
		
		int hole=++currentSize;
		for(array[0]=x;x.compareTo(array[hole/2])<0;hole/=2){
			array[hole]=array[hole/2];
		}
		array[hole]=x;
	}
	public AnyType findMin(){
		return array[1];
	}
	public AnyType deleteMin(){
		if(isEmpty()){
			throw new UnderflowException();
		}
		AnyType minItem=findMin();
		array[1]=array[currentSize--];
		percolateDown(1);
		
		return minItem;
	}
	public boolean isEmpty(){
		return currentSize==0;
	}
	public void makeEmpty(){
		currentSize=0;
	}
	
	private static final int DEFAULT_CAPACITY=10;
	
	private int currentSize;
	private AnyType[]array;
	
	private void percolateUp()
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
			percolateDown(i);
		}
	}
	private void enlargeArray(int newSize){
		
	}
}