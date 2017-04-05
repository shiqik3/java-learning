package dataStruct_java;

import java.util.Iterator;

public class MyArrayList<AnyType> implements Iterable<AnyType>
{
	private static final int DEFAULT_CAPACITY=10;
	private int theSize;
	private int theLength;
	private AnyType[]theItems;
	
	public MyArrayList()
	{
		theItems=( AnyType[] )new Object[DEFAULT_CAPACITY];
		this.theSize=10;
		this.theLength=0;
	}
	public MyArrayList(int size)
	{
		theItems=( AnyType[] )new Object[size];
		this.theSize=size;
		this.theLength=0;
	}
	public void insert(AnyType val)
	{
		theItems[theLength]=(AnyType)val;
		theLength++;
	}
	public void ensureCapacity(int newCapacity)
	{
		if(newCapacity<theSize)
		{
			return;
		}
		AnyType[]old=theItems;
		theItems=(AnyType[]) new Object[newCapacity];
		for(int i=0;i<theSize;i++)
		{
			theItems[i]=old[i];
		}
		theSize=newCapacity;
	}
	public AnyType get(int idx)
	{
		if(idx<0||idx>theLength)
		{
			throw new ArrayIndexOutOfBoundsException();
		}
		return theItems[idx];
	}
	public void set(int idx,AnyType newVal)
	{
		if(idx<0||idx>theLength)
		{
			throw new ArrayIndexOutOfBoundsException();
		}
		theItems[idx]=newVal;
	}
	public void add(int idx,AnyType newVal)
	{
		if(idx<0||idx>theLength)
		{
			throw new ArrayIndexOutOfBoundsException();
		}
		if(theLength==theSize)
		{
			ensureCapacity(2*theSize+1);
			theSize=2*theSize+1;
		}
		for(int i=theItems.length ;i>idx-1;i--)
		{
			theItems[i+1]=theItems[i];
		}
		theItems[idx]=newVal;
		theLength++;
	}
	public void remove(int idx)
	{
		if(idx<0||idx>theLength)
		{
			throw new ArrayIndexOutOfBoundsException();
		}
		for(int i=theItems.length ;i>idx;i--)
		{
			theItems[i]=theItems[i-1];
		}
		theLength--;
	}
	public void display()
	{
		for(int i=0;i<theSize;i++)
		{
			System.out.print(theItems[i]+" ");
		}
	}
	
	
	@Override
	public Iterator<AnyType> iterator()
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String[]args)
	{
		MyArrayList aa=new MyArrayList();
		for(int i=0;i<10;i++)
		{
			aa.insert((int)(Math.random()*100));
		}
		aa.display();
	}
}