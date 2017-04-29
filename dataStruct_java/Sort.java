package dataStruct_java;

public class Sort<AnyType extends Comparable<? super AnyType>>{
	private AnyType[]list;
	private int currentSize;
	private static final int DEFAULT_SIZE=11;
	
	public Sort(){
		this(DEFAULT_SIZE);
	}
	private Sort(int size){
		doclear(size);
	}
	private void doclear(int size){
		list=(AnyType[])new Comparable[size];
		currentSize=0;
	}
	private void add(AnyType t){
		list[currentSize+1]=t;
		currentSize++;
	}
	public void Sort(){
		mergeSort(list,1,currentSize);
	}
	private void insertionSort(AnyType[] _list,int left,int right){
		int j;
		for(int i=left;i<right;i++){
			AnyType tmp=_list[i];
			for(j=i;j>left&&tmp.compareTo(_list[j-1])<0;j--){
				_list[j]=_list[j-1];
			}
			_list[j]=tmp;
		}
	}
	private void shellSort(AnyType[] _list,int left,int right){
		int j;
		for(int gap=(right-left+1)/2;gap>0;gap/=2){
			for(int i=left;i<right;i++){
				AnyType tmp=_list[i];
				for(j=i;j>gap&&tmp.compareTo(_list[j-gap])<0;j-=gap){
					_list[j]=_list[j-gap];
				}
				_list[j]=tmp;
			}
		}
	}
	private void mergeSort(AnyType[] _list,int left,int right){
		if(left<right){
			AnyType[] newlist=(AnyType[])new Comparable[right-left+1];
			int center=(left+right)/2;
			mergeSort(_list,left,center);
			mergeSort(_list,center+1,right);
			for(int i=left,j=center+1,k=0;k<newlist.length;k++){
				if(i>center){
					for(;j<=right;k++){
						newlist[k]=_list[j];
						j++;
					}
				}else if(j>right){
					for(;i<=center;k++){
						newlist[k]=_list[i];
						i++;
					}
				}else if(_list[i].compareTo(_list[j])<0){
					newlist[k]=_list[i];
					i++;
				}else{
					newlist[k]=_list[j];
					j++;
				}
			}
			for(int i=left,k=0;k<newlist.length;i++,k++){
				_list[i]=newlist[k];
			}
		}
	}
	private void heapSort(AnyType[] _list,int left,int right){
		for(int j=currentSize;j>1;j--){
			//首先对数组内的元素进行调整
			heapPercDown(j);
			//第一步deleteMax
			if(_list.length==0){
				System.out.println("数组为空");
				System.exit(0);
			}else{
				_list[0]=_list[1];
				_list[1]=null;
			}
			//第二步percolateDown空位下滤,之后补位
			int i;
			for(i=left;2*i<j+1;){
				if(i*2==j){
					_list[i]= _list[2*i];
					i*=2;
				}else if(_list[2*i].compareTo(_list[2*i+1])>0){
					_list[i]= _list[2*i];
					i*=2;
				}else{
					_list[i]= _list[2*i+1];
					i=2*i+1;
				}
			}
			if(i<j){
				for(int k=i+1;k<=j;k++){
					_list[k-1]=_list[k];
				}
			}
			list[j]=_list[0];
		}
		list[0]=null;
	}
	private void heapPercDown(int nowSize){
		for(int i=nowSize;i>0;i--){
			percDown(list,i);
		}
	}
	private void percDown(AnyType[]_list,int hole){
		int i;
		int j;
		for(j=hole;j>1;j--){
			i=j;
			AnyType tmp=list[i];
			while(i/2>0 && _list[i].compareTo(_list[i/2])>0){
				_list[i]= _list[i/2];
				i/=2;
			}
			list[i]=tmp;
		}
	}
	/*
	private static int leftChild(int i){
		return 2*i+1;
	}
	private void percDown(AnyType[]a,int i,int n){
		int child;
		AnyType tmp;
		for(tmp=a[i];leftChild(i)<n;i=child){
			child=leftChild(i);
			if(child!=n-1&&a[child].compareTo(a[child+1])<0){
				child++;
			}
			if(tmp.compareTo(a[child])<0){
				a[i]=a[child];
			}else{
				break;
			}
		}
		a[i]=tmp;
	}
	private void heapsort(AnyType[]a){
		for(int i=a.length/2-1;i>=0;i--){
			percDown(a,i,a.length);
		}
		for(int i=a.length-1;i>0;i--){
			swapReferences(a,0,i);
			percDown(a,0,i);
		}
	}
	*/
	private void print(){
		for(int i=0;i<currentSize;i++){
			System.out.print(list[i+1]+" ");
		}
	}
	
	
	public static void main(String[]args){
		Sort m=new Sort();
		for(int i=1;i<11;i++){
			m.add((int)(Math.random()*100));
		}
		m.Sort();
		m.print();
	}
}