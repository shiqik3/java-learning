package dataStruct_java;

import java.io.IOException;
import java.util.Scanner;

public class Adt_ArrayList2<AnyType>{
	
	private static final int DEFAULT_CAPACITY=10;
	private int theSize;
	private int aPointer;
	private AnyType[]theItems;
	
	public Adt_ArrayList2(){
		doClear();
	}
	public void clear(){
		doClear();
	}
	private void doClear(){
		theSize=0;
		aPointer=-1;
		ensureCapacity(DEFAULT_CAPACITY);
	}
	public int size(){
		return theSize;
	}
	public boolean isEmpty(){
		return size()==0;
	}
	public void trimToSize(){
		ensureCapacity(size());
	}
	public AnyType get(int idx){
		if(idx<0||idx>=size()){
			throw new ArrayIndexOutOfBoundsException();
		}
		return theItems[idx];
	}
	public void ensureCapacity(int newCapacity){
		if(newCapacity<theSize){
			return;
		}
		AnyType[]old=theItems;
		theItems=(AnyType[])new Object[newCapacity];
		for(int i=0;i<size();i++){
			theItems[i]=old[i];
		}
	}
	public boolean push(AnyType x){
		push(size(),x);
		return true;
	}
	private void push(int idx,AnyType x){
		if(theItems.length==size()){
			ensureCapacity(size()*2+1);
		}
		for(int i=theSize;i>idx;i--){
			theItems[i]=theItems[i-1];
		}
		theItems[idx]=x;
		theSize++;
		aPointer++;
	}
	public AnyType pop(){
		return pop(size()-1);
	}
	private AnyType pop(int idx){
		AnyType removedItem=theItems[idx];
		for(int i=idx;i<size();i++){
			theItems[i]=theItems[i+1];
		}
		theSize--;
		aPointer--;
		return removedItem;
	}
	public void display(){
		for(int i=0;i<size();i++){
			System.out.print(theItems[i]+" ");
			if((i+1)%10==0){
				System.out.println();
			}
		}
	}

	
	public static void main(String[]args) throws IOException{
		//java程序主入口
		Adt_ArrayList2 list=new Adt_ArrayList2();
		for(int i=0;i<20;i++){
			list.push((int)(Math.random()*100));
		}
		list.display();
		System.out.println(list.pop());
		System.out.println(list.size());
	}
}