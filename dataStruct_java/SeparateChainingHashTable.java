package dataStruct_java;

import java.util.LinkedList;
import java.util.List;

public class SeparateChainingHashTable<AnyType>{
	/**
	 * construct the hash table
	 */
	public SeparateChainingHashTable(){
		this(DEFAULT_TABLE_SIZE);
	}
	
	/**
	 * Construct the hash table
	 * @param size approximate table size
	 */
	public SeparateChainingHashTable(int size){
		thelists=new LinkedList[nextPrime(size)];
		for(int i=0;i<thelists.length;i++){
			thelists[i]=new LinkedList<>();
		}
	}
	
	/**
	 * Insert into the hash table.If the item is
	 * already present,then do nothing;
	 * @param x the item to insert
	 */
	public void insert(AnyType x){
		List<AnyType> whichList=thelists[myhash(x)];
		if(!whichList.contains(x)){
			whichList.add(x);
			if(++currentSize>thelists.length){
				rehash();
			}
		}
	}
	
	/**
	 * Remove from the hash table
	 * @param x the item to remove
	 */
	public void remove(AnyType x){
		List<AnyType> whichList=thelists[myhash(x)];
		if(whichList.contains(x)){
			whichList.remove(x);
			currentSize--;
		}
	}
	
	/**
	 * Find an item in the hash table
	 * @param x the item to search for
	 * @return true if x is not found
	 */
	public boolean contains(AnyType x){
		List<AnyType> whichList=thelists[myhash(x)];
		return whichList.contains(x);
	}
	
	/**
	 * Make the hash table logically empty
	 */
	public void makeEmpty(){
		for(int i=0;i<thelists.length;i++){
			thelists[i].clear();
			currentSize=0;
		}
	}
	
	private static final int DEFAULT_TABLE_SIZE=100;
	private List<AnyType>[] thelists;
	private int currentSize;
	
	/**
	 * Rehashing for separate chaining hsh table
	 */
	private void rehash(){
		List<AnyType>[] oldlists=thelists;
		
		thelists=new List[nextPrime(2*thelists.length)];
		for(int j=0;j<thelists.length;j++){
			thelists[j]=new LinkedList<>();
		}
		currentSize=0;
		for(int i=0;i<oldlists.length;i++){
			for(AnyType item:oldlists[i]){
				insert(item);
			}
		}
	}
	private int myhash(AnyType x){
		int hashVal=x.hashCode();
		hashVal%=thelists.length;
		if(hashVal<0){
			hashVal+=thelists.length;
		}
		return hashVal;
	}
	
	private static void nextPrime(int n){
		int list[]=new int[250];
		for(int i=0;i<n;i++){
			list[i]=1;
		}
		list[0]=0;
		for(int j=0;j<n;j++){
			if(list[j]==1){
				for(int k=2;k<j;k++){
					if(((2*j+1)%k==0)&&(list[k]==1)){
						list[j]=0;
					}
				}
			}
		}
		for(int i=0;i<n;i++){
			if(list[i]==1){
				System.out.println(2*i+1);
			}
		}
		
		
	}
//	private static boolean isPrime(int n){
//		
//	}
	
	public static void main(String[]args){
		nextPrime(250);
	}
}