package dataStruct_java;

import java.util.ArrayList;

public class CharsSort{
	String[]arr;
	int currentSize;
	public CharsSort(){
		arr=new String[4];
		for(int i=0;i<4;i++){
			arr[i]=new String();
		}
		currentSize=0;
	}
	private void add(String ad){
		arr[currentSize++]=ad;
	}
	public void Sort(){
		radixSort(arr,4);
	}
	
	public static void radixSort(String[]arr,int stringlen){
		final int BUCKETS=4;
		ArrayList<String>[]buckets=new ArrayList[BUCKETS];
		
		for(int i=0;i<BUCKETS;i++){
			buckets[i]=new ArrayList<>();
		}
		for(int pos=stringlen-1;pos>=0;pos--){
			for(String s:arr){
				buckets[(int)(s.charAt(pos))-97].add(s);
			}
			int idx=0;
			for(ArrayList<String>thisBucket:buckets){
				for(String s:thisBucket){
					arr[idx++]=s;
				}
				thisBucket.clear();
			}
		}
	}
	
	public static void main(String[]args){
		CharsSort cs=new CharsSort();
		cs.add("abcd");
		cs.add("bcda");
		cs.add("cdab");
		cs.add("dabc");
		cs.Sort();
	}
}