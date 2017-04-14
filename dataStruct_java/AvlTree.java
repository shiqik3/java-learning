package dataStruct_java;

public class AvlTree<AnyType extends Comparable <?super AnyType>>{
	
	private AvlNode root;
	private int ht=0;
	private static class AvlNode<AnyType>{
		AvlNode(AnyType theElement){
			this(theElement,null,null,0);
		}
		AvlNode(AnyType theElement,AvlNode<AnyType> lt,AvlNode<AnyType> rt,int h){
			element=theElement;
			left=lt;
			right=rt;
			height=h;
		}
		AnyType element;
		AvlNode left;
		AvlNode right;
		int	height=0;
	}
	private int height(AvlNode<AnyType> t){
		return t==null?-1:t.height;
	}
	public void insert(AnyType t){
		root=insert(t,root);
	}
	private AvlNode<AnyType> insert(AnyType x,AvlNode<AnyType> t){
		if(t==null){
			return new AvlNode(x,null,null,0);
		}
		int compareResult=x.compareTo(t.element);
		if(compareResult<0){
			t.left=insert(x,t.left);
		}else if(compareResult>0){
			t.right=insert(x,t.right);
		}else{
			System.out.println("插入失败，数值相同");;
		}
		return balance(t);
	}
	public void insert2(AnyType t){
		root=insert(t,root);
	}
	private AvlNode<AnyType> insert2(AnyType x,AvlNode<AnyType> t){
		ht=t.height;
		while(t!=null){
			int compareResult=x.compareTo(t.element);
			if(compareResult<0){
				ht++;
				t.left=insert(x,t.left);
			}else if(compareResult>0){
				ht++;
				t.right=insert(x,t.right);
			}else{
				System.out.println("插入失败，数值相同");;
			}
		}
		if(t==null){
			return new AvlNode(x,null,null,ht);
		}
		return balance(t);
	}
	
	public AvlNode findMin(){
		return findMin(root);
	}
	public AvlNode findMax(){
		return findMax(root);
	}
	private AvlNode<AnyType> findMin(AvlNode<AnyType> x){
		if(x==null){
			return null;
		}else if(x.left==null){
			return x;
		}
		return findMin(x.left);
	}
	private AvlNode<AnyType> findMax(AvlNode<AnyType> x){
		if(x!=null){
			while(x.right!=null){
				x=x.right;
			}
		}
		return x;
	}
	
	private static final int ALLOWED_IMBALANCE=1;
	
	private AvlNode<AnyType> balance(AvlNode<AnyType> t){
		if(t==null){
			return t;
		}
		if(height(t.left)-height(t.right)>ALLOWED_IMBALANCE){
			if(height(t.left.left)>=height(t.left.right)){
				t=rotateWithLeftChild(t);
			}else{
				t=doubleWithLeftChild(t);
			}
		}else{
			if(height(t.right)-height(t.left)>ALLOWED_IMBALANCE){
				if(height(t.right.right)>=height(t.right.left)){
					t=rotateWithRightChild(t);
				}else{
					t=doubleWithRightChild(t);
				}
			}
		}
		t.height=Math.max(height(t.left), height(t.right))+1;
		return t;
	}
	
	
	private AvlNode<AnyType> rotateWithLeftChild(AvlNode<AnyType> k2){
		AvlNode<AnyType> k1=k2.left;
		k2.left=k1.right;
		k1.right=k2;
		k2.height=Math.max(height(k2.left), height(k2.right))+1;
		k1.height=Math.max(height(k1.left), k2.height)+1;
		return k1;
	}
	
	private AvlNode<AnyType> rotateWithRightChild(AvlNode<AnyType> k1){
		AvlNode<AnyType> k2=k1.right;
		k1.right=k2.left;
		k2.left=k1;
		k1.height=Math.max(height(k1.left), height(k1.right))+1;
		k2.height=Math.max(height(k2.right), k1.height)+1;
		return k2;
	}
	
	private AvlNode<AnyType> doubleWithLeftChild(AvlNode<AnyType> k3){
		k3.left=rotateWithRightChild(k3.left);
		return rotateWithLeftChild(k3);
	}
	private AvlNode<AnyType> doubleWithRightChild(AvlNode<AnyType> k3){
		k3.right=rotateWithLeftChild(k3);
		return rotateWithRightChild(k3);
	}
	
	private AvlNode<AnyType> remove(AnyType x,AvlNode<AnyType> t){
		if(t==null){
			return t;
		}
		int compareResult=x.compareTo(t.element);
		if(compareResult<0){
			t.left=remove(x,t.left);
		}else if(compareResult>0){
			t.right=remove(x,t.right);
		}else if(t.left!=null&&t.right!=null){
			t.element=(AnyType) findMin(t.right).element;
			t.right=remove(t.element,t.right);
		}else{
			t=(t.left!=null)?t.left:t.right;
		}
		return balance(t);
	}
	public void printTree(){
		printTree(root);
	}
	private void printTree(AvlNode<AnyType> t){
		if(t!=null){
			System.out.println(t.element);
			printTree(t.left);
			printTree(t.right);
		}
	}
	
	public static void main(String[]args){
		AvlTree tree=new AvlTree();
		int t;
		for(int i=0;i<10;i++){
			t=(int)(Math.random()*100);
			tree.insert2(t);
		}
		tree.printTree();
	}
}