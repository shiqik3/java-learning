package dataStruct_java;

import java.util.Random;

interface HashFamily<AnyType>{
	int hash(AnyType x,int which);
	int getNumberOfFunctions();
	void generateNewFunctions();
}

public class CuckooHashTable<AnyType>{
	
	/**
	 * Construct the table; 
	 * @param hf the hash family
	 */
	public CuckooHashTable(HashFamily<? super AnyType> hf){
		this(hf,DEFAULT_TABLE_SIZE);
	}
	/**
	 * Construct the hash table
	 * @param hf the hash family
	 * @param size the approximate initial size
	 */
	public CuckooHashTable(HashFamily<? super AnyType> hf,int size){
		allocateArray(nextPrime(size));
		doClear();
		hashFunctions=hf;
		numHashFunctions=hf.getNumberOfFunctions();
	}
	public void makeEmpty(){
		doClear();
	}
	/**
	 * Find an item in the hash table
	 * @param x the item to search for
	 * @return true if item is found.
	 */
	public boolean contains(AnyType x){
		return findPos(x)!=-1;
	}
	/**
	 * Compute the hash code for x using specified hash function
	 * @param x the item
	 * @param which the hash function
	 * @return the hash code
	 */
	private int myhash(AnyType x,int which){
		int hashVal=hashFunctions.hash(x, which);
		
		hashVal %=array.length;
		if(hashVal<0){
			hashVal+=array.length;
		}
		
		return hashVal;
	}
	/**
	 * Method that searches all hash function places.
	 * @param x the item to search for;
	 * @return the position where the search terminates, or -1 if not found
	 */
	private int findPos(AnyType x){
		for(int i=0;i<numHashFunctions;i++){
			int pos=myhash(x,i);
			if(array[pos]!=null&&array[pos].equals(x)){
				return pos;
			}
		}
		
		return -1;
	}
	/**
	 * Remove from the hash table.
	 * @param x the item to remove.
	 * @return true if item was found and removed.
	 */
	public boolean remove(AnyType x){
		int pos=findPos(x);
		if(pos!=-1){
			array[pos]=null;
			currentSize--;
		}
		
		return pos!=-1;
	}
	/**
	 * Insert into the hash table.If the item is
	 * already present,return false
	 * @param x the item to insert
	 * @return 
	 */
	public boolean insert(AnyType x){
		if(contains(x)){
			return false;
		}
		if(currentSize>=array.length*MAX_LOAD){
			expand();
		}
		
		return insertHelperl(x);
	}
	private void expand(){
		rehash((int)(array.length/MAX_LOAD));
	}
	private void rehash(){
		hashFunctions.generateNewFunctions();
		rehash(array.length);
	}
	private void rehash(int newLength){
		AnyType[]oldArray=array;
		allocateArray(nextPrime(newLength));
		currentSize=0;
		
		for(AnyType str:oldArray){
			if(str!=null){
				insert(str);
			}
		}
	}
	private void doClear(){
		currentSize=0;
		for(int i=0;i<array.length;i++){
			array[i]=null;
		}
	}
	private void allocateArray(int arraySize){
		array=(AnyType[])new Object[arraySize];
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
	
	private static final double MAX_LOAD=0.4;
	private static final int ALLOWED_REHASHES=1;
	private static final int DEFAULT_TABLE_SIZE=101;
	
	private final HashFamily<? super AnyType> hashFunctions;
	private final int numHashFunctions;
	private AnyType[]array;
	private int currentSize;
	private int rehashes=0;
	private Random r=new Random();
	
	private boolean insertHelperl(AnyType x){
		final int COUNT_LIMIT=100;
		while(true){
			int lastPos=-1;
			int pos;
			for(int count=0;count<COUNT_LIMIT;count++){
				for(int i=0;i<numHashFunctions;i++){
					pos=myhash(x,i);
					if(array[pos]==null){
						array[pos]=x;
						currentSize++;
						return true;
					}
				}
				
				int i=0;
				do{
					pos=myhash(x,r.nextInt(numHashFunctions));
				}while(pos==lastPos&&i++<5);
				
				AnyType tmp=array[lastPos=pos];
				array[pos]=x;
				x=tmp;
			}
			
			if(++rehashes>ALLOWED_REHASHES){
				expand();
				rehashes=0;
			}else{
				rehash();
			}
		}
	}
}






