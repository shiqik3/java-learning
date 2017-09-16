package dataStruct_java;

public class test {
	public ddf df;
	public static class ddf{
		public int a=0;
		ddf(int b){
			a=b;
		}
	}
	public void cc(){
		ddf ac=new ddf(9);
		df=ac;
	}
	public void print(){
		System.out.println(df.a);
	}
	public test(){
		df=new ddf(4);
		
	}
	
	public static void main(String[]args){
		test s=new test();
		s.print();
	}
}
