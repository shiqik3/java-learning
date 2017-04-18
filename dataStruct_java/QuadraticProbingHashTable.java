package dataStruct_java;

import java.util.LinkedList;
import java.util.List;

public class QuadraticProbingHashTable<AnyType>{
	/**
	 * construct the hash table
	 */
	public QuadraticProbingHashTable(){
		this(DEFAULT_TABLE_SIZE);
	}
	/**
	 * construct the hash table
	 * @param size the approximate initial size
	 */
	public QuadraticProbingHashTable(int size){
		allocateArray(size);
		makeEmpty();
	}
	/**
	 * make the hash table logically empty
	 */
	public void makeEmpty(){
		currentSize=0;
		for(int i=0;i<array.length;i++){
			array[i]=null;
		}
	}
	
	/**
	 * find an item in the hash table
	 * @param x the item to search for
	 * @return the matching item
	 */
	public boolean contains(AnyType x){
		int currentPos=findPos(x);
		return isActive(currentPos);
	}
	/**
	 * insert into the hash table.if the item is
	 * already present,do nothing
	 * @param x the item to insert
	 */
	public void insert(AnyType x){
		int currentPos=findPos(x);
		if(isActive(currentPos)){
			return ;
		}
		array[currentPos]=new HashEntry<>(x,true);
		if(currentSize>array.length/2){
			rehash();
		}
	}
	/**
	 * remove from the hash table
	 * @param x the item to remove
	 */
	public void remove(AnyType x){
		int currentPos=findPos(x);
		array[currentPos].isActive=false;
	}
	
	private static class HashEntry<AnyType>{
		public AnyType element;    //the element
		public boolean isActive;    //false if marked deleted
		
		public HashEntry(AnyType e){
			this(e,true);
		}
		public HashEntry(AnyType e,boolean i){
			element=e;
			isActive=i;
		}
	}
	
	private static final int DEFAULT_TABLE_SIZE=11;
	
	private HashEntry<AnyType>[]array;    //the array of element
	private int currentSize;    //the number of occupied cells
	
	/**
	 * internal method to allocate array
	 * @param arraySize the size of the array.
	 */
	private void allocateArray(int arraySize){
		array=new HashEntry[nextPrime(arraySize)];
	}
	/**
	 * return true if currentPos exists and is active
	 * @param currentPos the result of a call to findPos
	 * @return true if currentPos is active
	 */
	private boolean isActive(int currentPos){
		return array[currentPos]!=null&&array[currentPos].isActive;
	}
	/**
	 * method that performs quadratic probing resolution in half-empty table
	 * @param x the item ot search for
	 * @return the position where the search terminates.
	 */
	private int findPos(AnyType x){
		int offset=1;
		int currentPos=myhash(x);
		
		while(array[currentPos]!=null&&
				!array[currentPos].element.equals(x)){
			currentPos+=offset;    //compute ith probe
			offset+=2;
			if(currentPos>=array.length){
				currentPos-=array.length;
			}
		}
		return currentPos;
	}
	private void rehash(){
		HashEntry<AnyType>[]oldlists=array;
		//List<AnyType>[] oldlists=thelists;
		
		array=new HashEntry[nextPrime(2*array.length)];
		currentSize=0;
		for(int i=0;i<oldlists.length;i++){
			insert(oldlists[i].element);
		}
	}
	private int myhash(AnyType x){
		int hashVal=x.hashCode();
		hashVal%=array.length;
		if(hashVal<0){
			hashVal+=array.length;
		}
		return hashVal;
	}
	private static int nextPrime(int n){
		for(int i=n;i>0;i++){
			if(isPrime(i)==true){
				return i;
			}
		}
		return 0;
	}
	private static boolean isPrime(int n){
		if(n==1||n==2){
			return true;
		}
		for(int i=2;i<(n/2);i++){
			if(n%i==0){
				return false;
			}
		}
		return true;
	}
	private void printfTable(){
		for(int i=0;i<array.length;i++){
			if(array[i]!=null){
				System.out.print(array[i].element+" ");
			}
		}
		System.out.println();
	}
	
	
	public static void main(String[]args){
		//java程序主入口
		QuadraticProbingHashTable qpht=new QuadraticProbingHashTable();
		for(int i=0;i<10;i++){
			qpht.insert((int)(Math.random()*100));
		}
		qpht.printfTable();
		
	}
}


