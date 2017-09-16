package dataStruct_java;

import java.util.ArrayList;

public class CharsSort{
	String[]arr;
	int currentSize;
	public CharsSort(){
		arr=new String[22];
		for(int i=0;i<22;i++){
			arr[i]=new String();
		}
		currentSize=0;
	}
	private void add(String ad){
		arr[currentSize++]=ad;
	}
	public void Sort(){
		reRadixSort(arr,5);
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
	
	public void countingRadixSort(String[]arr,int stringLen){
		final int BUCKETS=4;
		int N=arr.length;
		String[]buffer=new String[N];
		String[]in=arr;
		String[]out=buffer;
		for(int pos=stringLen-1;pos>=0;pos--){
			int[]count=new int[BUCKETS+1];
			for(int i=0;i<N;i++){
				count[in[i].charAt(pos)-97+1]++;
			}
			for(int b=1;b<=BUCKETS;b++){
				count[b]+=count[b-1];
			}
			for(int i=0;i<N;i++){
				out[count[in[i].charAt(pos)-97]++]=in[i];
			}
			
			String[]tmp=in;
			in=out;
			out=tmp;
		}
		if(stringLen%2==1){
			for(int i=0;i<arr.length;i++){
				out[i]=in[i];
			}
		}
	}
	public void reRadixSort(String[]arr,int maxLen){
		final int BUCKETS=6;
		
		ArrayList<String>[]wordsByLength=new ArrayList[maxLen+1];
		ArrayList<String>[]buckets=new ArrayList[BUCKETS];
		
		for(int i=0;i<wordsByLength.length;i++){
			wordsByLength[i]=new ArrayList();
		}
		for(int i=0;i<BUCKETS;i++){
			buckets[i]=new ArrayList();
		}
		for(String s:arr){
			wordsByLength[s.length()].add(s);
			//将String以长度分组
		}
		
		int idx=0;
		for(ArrayList<String> wordList:wordsByLength){
			for(String s:wordList){
				arr[idx++]=s;
			}
		}
		int startingIndex=arr.length;
		for(int pos=maxLen-1;pos>=0;pos--){
			startingIndex-=wordsByLength[pos+1].size();
			for(int i=startingIndex;i<arr.length;i++){
				buckets[arr[i].charAt(pos)-97].add(arr[i]);
			}
			idx=startingIndex;
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
		cs.add("a");
		cs.add("b");
		cs.add("c");
		cs.add("d");
		cs.add("e");
		cs.add("ab");
		cs.add("bc");
		cs.add("cd");
		cs.add("cb");
		cs.add("de");
		cs.add("abc");
		cs.add("bcd");
		cs.add("cde");
		cs.add("abcd");
		cs.add("cdea");
		cs.add("deab");
		cs.add("eabc");
		cs.add("abcde");
		cs.add("bcdea");
		cs.add("cdeab");
		cs.add("deabc");
		cs.add("eabcd");
		cs.Sort();
	}
}