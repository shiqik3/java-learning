package dataStruct_java;

public class ExpressionTree<AnyType>{
	
	private TreeNode<AnyType> root;
	private Adt_ArrayList2 stack=new Adt_ArrayList2();
	
	private static class TreeNode<AnyType>{
		//树节点
		private AnyType element;    //树的值
		private TreeNode<AnyType> left;    //左孩子
		private TreeNode<AnyType> right;    //右孩子
		TreeNode(AnyType x){
			this(x,null,null);    //构造函数
		}
		public TreeNode(AnyType e,TreeNode<AnyType> lt,TreeNode<AnyType> rt){
			//重载构造函数
			element=e;
			left=lt;
			right=rt;
		}
	}
	/*
	 * 以下是有关树的操作
	 */
	public ExpressionTree(){
		root=null;
	}
	public void makeEmpty(){
		root=null;
	}
	public boolean isEmpty(){
		return root==null;
	}
	public TreeNode getNode(AnyType x,TreeNode n){
		if(n==x){
			return n;
		}else if(n!=null){
			getNode(x,n.left);
		}else if(n!=null){
			getNode(x,n.right);
		}
		return null;
	}
	public void printTree(){
		printTree(root);
	}
	
	private void printTree(TreeNode<AnyType> t){
		if(t!=null){
			printTree(t.left);
			System.out.print(t.element+" ");
			printTree(t.right);
		}
	}
	
	/*
	 * 封装栈类，用于存放后缀表达式
	 */
	private class Adt_ArrayList2<AnyType>{
		
		private static final int DEFAULT_CAPACITY=10;
		private int aPointer;
		private AnyType[]theItems;
		
		public Adt_ArrayList2(){
			doClear();
		}
		public void clear(){
			doClear();
		}
		private void doClear(){
			aPointer=-1;
			ensureCapacity(DEFAULT_CAPACITY);
		}
		public int size(){
			return aPointer+1;
		}
		public boolean isEmpty(){
			return size()==0;
		}
		public void trimToSize(){
			ensureCapacity(size());
		}
		public void ensureCapacity(int newCapacity){
			if(newCapacity<aPointer){
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
			for(int i=aPointer;i>idx;i--){
				theItems[i]=theItems[i-1];
			}
			theItems[idx]=x;
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
			aPointer--;
			return removedItem;
		}
	}
	
	public void comTree(AnyType x){
		compileTree(x);
	}
	private void compileTree (AnyType x){
		String str=x.toString();
		//System.out.println(str);
		if(x.equals("+")||x.equals("-")||x.equals("*")||x.equals("/")){
			TreeNode<AnyType> b=new TreeNode(stack.pop());
			TreeNode<AnyType> a=new TreeNode(stack.pop());
			TreeNode c=new TreeNode(x,a,b);
			stack.push(c.element);
			root=c;
			printTree();
		}else{
			stack.push(x);
		}
	}
	
	
	public static void main(String[]args){
		ExpressionTree tree=new ExpressionTree();
		String a=new String("a b + c d e + * *");
		String str[]=a.split(" ");
		for(int i=0;i<str.length;i++){
			tree.comTree(str[i]);
		}
		tree.printTree();
	}
}





