package dataStruct_java;

public class DisjSets{
	
	private int[]s;
	private final static int DEFAULT_SIZE=10;
	
	public DisjSets(){
		this(DEFAULT_SIZE);
	}
	public DisjSets(int numElements){
		s=new int[numElements];
		for(int i=0;i<s.length;i++){
			s[i]=-1;
		}
	}
	private void union(int root1,int root2){
		unionByHeight(root1,root2);
	}
	public void simpleunion(int root1,int root2){
		s[root2]=root1;
	}
	private void unionByHeight(int root2,int root1){
		if(s[root1]<s[root2]){
			s[root2]=root1;
		}else{
			 if(s[root1]==s[root2]){
				s[root2]--;
			 }
			s[root1]=root2;
		}
	}
	public int find(int x){
		if(s[x]<0){
			return x;
		}else{
			return find(s[x]);
		}
	}
	private void print(){
		for(int i=0;i<s.length;i++){
			System.out.print(s[i]+" ");
		}
	}
	
	public static void main(String[]args){
		DisjSets ds=new DisjSets();
		ds.union(4, 5);
		ds.union(6, 7);
		ds.union(4, 6);
		ds.union(4, 3);
		ds.print();
	}
}