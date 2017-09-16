package educat_java;
public class BasicSyntax {
    public static void main(String[] args) {
    	int count=0;
    	int num=0;
        for(int i=1;i<100;i++){
        	for(int j=1;j<=i;j++){
        		if(i%j==0){
        			count++;
        		}
        	}
        	if(count==8){
        		num++;
        	}else{
        		count=0;
        	}
        }
        System.out.println(num);
    }
}

