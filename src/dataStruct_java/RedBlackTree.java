package dataStruct_java;

public class RedBlackTree<AnyType extends Comparable<? super AnyType>> {
	public RedBlackTree(){
		nullNode =new RedBlackNode<>(null);
		nullNode.left=nullNode.right=nullNode;
		header =new RedBlackNode<>(null);
		header.left=header.right=nullNode;
	}
	
	private static class RedBlackNode<AnyType>{
		RedBlackNode(AnyType theElement){
			this(theElement,null,null);
		}
		RedBlackNode(AnyType theElement,RedBlackNode<AnyType> lt,RedBlackNode<AnyType> rt){
			element=theElement;
			left=lt;
			right=rt;
			color=RedBlackTree.BLACK;
		}
		
		AnyType element;
		RedBlackNode<AnyType> left;
		RedBlackNode<AnyType> right;
		int color;
	}
	
	private RedBlackNode<AnyType> header;
	private RedBlackNode<AnyType> nullNode;
	
	private static final int BLACK=1;
	private static final int RED=0;
	
	private RedBlackNode<AnyType> rotate(AnyType item,RedBlackNode<AnyType> parent){
		if(compare(item,parent)<0){
			return parent.left=compare(item,parent.left)<0?
					rotateWithLeftChild(parent.left):    //ll
					rotateWithRightChild(parent.left);    //lr
		}
		else{
			return parent.right=compare(item,parent.right)<0?
					rotateWithLeftChild(parent.right):    //rl
					rotateWithRightChild(parent.right);    //rr
		}
	}
	
	private RedBlackNode<AnyType> rotateWithLeftChild(RedBlackNode<AnyType> k2){
		RedBlackNode<AnyType> k1=k2.left;
		k2.left=k1.right;
		k1.right=k2;
		return k1;
	}
	
	private RedBlackNode<AnyType> rotateWithRightChild(RedBlackNode<AnyType> k2){
		RedBlackNode<AnyType> k1=k2.right;
		k2.right=k1.left;
		k1.left=k2;
		return k1;
	}
	
	private RedBlackNode<AnyType> doubleWithLeftChild(RedBlackNode<AnyType> k3){
		k3.left=rotateWithRightChild(k3.left);
		return rotateWithLeftChild(k3);
	}
	
	private RedBlackNode<AnyType> doubleWithRightChild(RedBlackNode<AnyType> k3){
		k3.right=rotateWithLeftChild(k3.right);
		return rotateWithRightChild(k3);
	}
	
	private final int compare(AnyType item,RedBlackNode<AnyType> t){
		if(t==header){
			return 1;
		}
		return item.compareTo(t.element);
	}
	
	private RedBlackNode<AnyType> current;
	private RedBlackNode<AnyType> parent;
	private RedBlackNode<AnyType> grand;
	private RedBlackNode<AnyType> great;
	private RedBlackNode<AnyType> uncle;
	
	
	private void handleReorient(AnyType item){
		current.color=RED;
		current.left.color=BLACK;
		current.right.color=BLACK;
		
		if(parent.color==RED){
			grand.color=RED;
			if((compare(item,grand)<0)!=(compare(item,parent)<0)){
				parent=rotate(item,grand);
			}
			current=rotate(item,great);
			current.color=BLACK;
		}
		header.right.color=BLACK;
	}
	
	public void insert(AnyType item){
		current=parent=grand=header;
		while(current!=nullNode){
			grand=parent;
			parent=current;
			current=compare(item,current)<0?current.left:current.right;
		}
		current=new RedBlackNode(item,nullNode,nullNode);
		balance(parent);
	}
	
	public RedBlackNode<AnyType> balance(RedBlackNode<AnyType> t){
		if(parent.color==BLACK){
			//如果父节点是黑点，则不做任何操作
		}
		else{
			//红父
		
			
			if(uncle.color==RED){
				//红叔情况
				//进行颜色反转
				grand.color=RED;
				parent.color=BLACK;
				uncle.color=BLACK;
			}
			else{
				//黑叔情况
				if(grand.left==parent){
					if(parent.left==current){
						//左一字型
						t=rotateWithLeftChild(grand);
						
					}
					else{
						//左之字形
						t=doubleWithLeftChild(grand);
					}
				}
				else{
					if(parent.left==current){
						//右之字形
						t=doubleWithRightChild(grand);
					}
					else{
						//右一字型
						t=rotateWithRightChild(grand);
					}
				}
			}
			
			t.color=BLACK;
			grand.color=RED;
		}
		return null;
	}
	public void insert2(AnyType item){
		current=parent=grand=header;
		nullNode.element=item;
		
		while(compare(item,current)!=0){
			great=grand;
			grand=parent;
			parent=current;
			current=compare(item,current)<0?current.left:current.right;
			
			if(current.left.color==RED&&current.right.color==RED){
				handleReorient(item);
			}
		}
		
		if(current!=nullNode){
			return ;
		}
		
		current=new RedBlackNode<>(item,nullNode,nullNode);
		
		if(compare(item,parent)<0){
			parent.left=current;
		}
		else{
			parent.right=current;
		}
		handleReorient(item);
	}
	
	private boolean isEmpty(){
		return header==nullNode;
	}
	
	public void printTree(){
		if(isEmpty()){
			System.out.println("Empty tree");
		}
		printTree(header.right);
	}
	
	private void printTree(RedBlackNode<AnyType> t){
		if(t!=nullNode){
			printTree(t.left);
			System.out.print(t.element+" ");
			printTree(t.right);
		}
	}
	
	public static void main(String[]args){
		RedBlackTree xx=new RedBlackTree();
		xx.insert2(30);
		xx.insert2(15);
		xx.insert2(10);
		xx.insert2(20);
		xx.insert2(5);
		xx.insert2(70);
		xx.insert2(60);
		xx.insert2(50);
		xx.insert2(40);
		xx.insert2(55);
		xx.insert2(65);
		xx.insert2(85);
		xx.insert2(80);
		xx.insert2(90);
		
		xx.printTree();
	}
}
