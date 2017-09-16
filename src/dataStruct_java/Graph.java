package dataStruct_java;
public class Graph{
	private Node[]arr;
	private static int DEFAULT_SIZE=8;
	private static int INFINITY=-1;
	private static class Node{
		//public int id;
		//under type is used for simple sort
		public int linknum;
		public boolean exist;
		public int[]list;
		//under type is used for breakth first search
		public boolean known;
		public int dv;
		public String pv;
		// private AnyType data;
		
		Node(){
			linknum=0;
			exist=true;
			known=false;
			list=null;
			dv=INFINITY;
			pv=new String("");
		}
		Node(int... args){
			for(int i=0;i<args.length;i++){
				if(args[i]<0||args[i]>DEFAULT_SIZE){
					assert(true);
				}
			}
			//id=x;
			linknum=args.length;
			exist=true;
			known=false;
			list=args;
			dv=INFINITY;
			pv=new String("");
		}
		public int findNodeListnum(int fd){
			for(int i=0;i<list.length;i++){
				if(list[i]==fd){
					return i+1;
				}
			}
			return 0;
		}
	}
	
	
	Graph(){
//		arr=new Node[8];
//		arr[1]=new Node(2,4,3);
//		arr[2]=new Node(4,5);
//		arr[3]=new Node(6);
//		arr[4]=new Node(6,7,3);
//		arr[5]=new Node(4,7);
//		arr[6]=new Node();
//		arr[7]=new Node(6);
		
		arr=new Node[8];
		arr[1]=new Node(2,4);
		arr[2]=new Node(4,5);
		arr[3]=new Node(1,6);
		arr[4]=new Node(3,5,6,7);
		arr[5]=new Node(7);
		arr[6]=new Node();
		arr[7]=new Node(6);
	}
	
	public int findNewVertexOfIndegreeZero(int start,int end){
		for(int i=start;i<=end;i++){
			if(arr[i].linknum==0&&arr[i].exist==true){
				return i;
			}
		}
		return 0;	//没有找到入度为0的节点，返回0代表not found;
	}
	public void deleteVertex(int de){
		arr[de].exist=false;
		for(int i=1;i<DEFAULT_SIZE;i++){
			if(arr[i].exist==true&&arr[i].findNodeListnum(de)!=0){
				arr[i].linknum--;
			}
		}
	}
	
	public class CycleFoundexception extends Exception{
		CycleFoundexception(){
			System.out.println("此图有环");
		}
	}
	public void topsort()throws CycleFoundexception{
		for(int counter=0;counter<DEFAULT_SIZE-1;counter++){
			int v=findNewVertexOfIndegreeZero(1,DEFAULT_SIZE-1);
			if(v==0){
				throw new CycleFoundexception();
			}else{
				System.out.print(v);
				deleteVertex(v);
			}
		}
	}
	
	void unweighted(int start){
		arr[start].dv=0;
		arr[start].pv+=start;
		for(int currDist=0;currDist<DEFAULT_SIZE-1;currDist++){
			for(int i=1;i<DEFAULT_SIZE;i++){
				if(!arr[i].known&&arr[i].dv==currDist&&arr[i].linknum>0){
					arr[i].known=true;
					for(int j:arr[i].list){
						if(arr[j].dv==INFINITY){
							arr[j].dv=currDist+1;
							arr[j].pv=arr[i].pv+j;
						}
					}
				}
			}
		}
	}
	void printfunweighted(){
		for(int i=1;i<DEFAULT_SIZE;i++){
			System.out.println(arr[i].pv);
		}
	}
	
	
	
	
	
	
	public static void main(String[]args){
		Graph gh=new Graph();
//		try {
//			gh.topsort();
//		} catch (CycleFoundexception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		gh.unweighted(3);
		gh.printfunweighted();
	}
}