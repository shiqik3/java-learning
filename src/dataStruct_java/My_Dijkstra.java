package dataStruct_java;

import java.util.ArrayList;
import java.util.LinkedList;

public class My_Dijkstra {
	public static int DEFAULT_SIZE=8;
	public static final int INFINITY=-1;
	public ArrayList<Vertex> list;
	/**
	 * Vertex 节点
	 * @author shiqik3
	 *
	 */
	private static class Vertex{
		public String pID;
		public ArrayList<Aslength> adj;  //存储到下一个节点的距离
		public boolean known;
		public int dist;
		public Vertex path;
		
		public Vertex(){
			clear();
		}
		private void clear(){
			pID="0";
			adj=new ArrayList();
			known=false;
			dist=INFINITY;
			path=null;
		}
		private String getpID(){
			return pID;
		}
		private String getPathID(){
			String ret;
			if(null==path){
				ret=null;
			}else{
				ret=path.pID;
			}
			return ret;
		}
		private void putpID(String cc){
			this.pID=cc;
		}
		public void link(Vertex vx,int distance){
			adj.add(new Aslength(vx,distance));
		}
		/**
		 * Aslength 到各节点距离的邻接表
		 * @author shiqik3
		 *
		 */
		public static class Aslength{
			public Vertex vx;
			public int distance;
			public Aslength(Vertex vx,int distance){
				this.vx=vx;
				this.distance=distance;
			}
		}
	}
	
	public My_Dijkstra(){
		list=new ArrayList();
		clear();
	}
	
	private void clear(){
		list.clear();
	}
	
	public void init(){
		Vertex[]vlist = new Vertex[DEFAULT_SIZE];
		vlist[1]=new Vertex();
		vlist[2]=new Vertex();
		vlist[3]=new Vertex();
		vlist[4]=new Vertex();
		vlist[5]=new Vertex();
		vlist[6]=new Vertex();
		vlist[7]=new Vertex();
		vlist[1].link(vlist[2], 2);
		vlist[1].link(vlist[4], 1);
		vlist[2].link(vlist[5], 10);
		vlist[2].link(vlist[4], 3);
		vlist[3].link(vlist[1], 4);
		vlist[3].link(vlist[1], 5);
		vlist[4].link(vlist[3], 2);
		vlist[4].link(vlist[5], 2);
		vlist[4].link(vlist[6], 8);
		vlist[4].link(vlist[7], 4);
		vlist[5].link(vlist[7], 6);
		vlist[7].link(vlist[6], 1);
		for(int i=1 ;i<8 ;i++){
			vlist[i].putpID("vlist["+i+"]");
			list.add(vlist[i]);
		}
	}
	
	private void print(){
		System.out.println("v            known    dv    pv");
		for(int i=0;i<list.size();i++){
			System.out.print(list.get(i).pID+"     ");
			System.out.print(list.get(i).known+"     ");
			System.out.print(list.get(i).dist+"     ");
			System.out.print(list.get(i).getPathID()+"     ");
			System.out.println();
		}
	}
	
	private void printPath(Vertex vx){
		if(null!=vx.path){
			printPath(vx.path);
			System.out.println("to");
		}
		System.out.println(vx.pID);
	}
	
	private void dijkstra(Vertex s){
		for(Vertex v:list){
			v.dist=INFINITY;
			v.known=false;
		}
		s.dist=0;
		while(exunknown()){
			Vertex v=findmin();
			v.known=true;
			Vertex w;
			int ds;
			int cv;
			for(int i=0;i<v.adj.size();i++){
				w=v.adj.get(i).vx;
				ds=w.dist;
				cv=v.dist+v.adj.get(i).distance;
				if(!w.known){
					//if v is known , dont do it
					if(w.dist!=INFINITY){
						w.dist=(w.dist<cv?w.dist:cv);
					}
					else{
						w.dist=cv;
					}
					
					if(ds!=w.dist){
						//if ds!=w.dist,w.dist has been change ,change path
						w.path=v;
					}
				}
			}
		}
	}
	/**
	 * to know exist unknown slot or not
	 * @return boolean
	 */
	private boolean exunknown(){
		boolean ret=false;
		for(int i=0;i<list.size();i++){
			if(!list.get(i).known){
				ret=true;
				break;
			}
		}
		return ret;
	}
	/**
	 * find min Vertex v
	 * @param s
	 * @return Vertex v
	 */
	private Vertex findmin(){
		Vertex ret=null;
		Vertex s;
		for(int i=0;i<list.size();i++){
			s=list.get(i);
			if((!s.known)&&(s.dist!=INFINITY)){
				if(ret==null){
					ret=s;
				}
				else{
					ret=ret.dist<s.dist?ret:s;
				}
			}
			
		}
//		System.out.println(ret.pID); to debug print
//		System.out.println(ret.dist);
		return ret;
	}
	public static void main(String[]args){
		My_Dijkstra md=new My_Dijkstra();
		md.init();
		md.dijkstra(md.list.get(0));
		md.print();
	}
}
