
public class AddDigits {
	public static void main(String[] args){
		int num=38;
		System.out.println(addDigits( num) );
		
	}
    public static int addDigits(int num) {
    	int sum=num;
    	while(sum/10!=0){
    		num=sum;
    		sum=0;
    		while(num!=0){
    			sum=sum+num%10;;
    			num=num/10;
    			
    		}
    	}
    	
		return sum;
        
    }

}
