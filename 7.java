


public class ReverseInteger {
	public static void main(String[] args){
		int x=153423693;
		System.out.println(reverse(x));
	}
	/**
	 *这道题需要考虑两个问题
	 * 一个数字如果结尾为0，怎么办,
	 * 如果reverse后溢出，怎么办
	 * @param x
	 * @return
	 */
    public static int reverse(int x) {
    	long sum=0;//原先一直将sum为int类型，所以一直不对，但是方法上不是很好，明明可以用int类型就可以解决，非要浪费空间
    	
    	while(x!=0){
    		
    		sum=sum*10+x%10;
    		if(x> Integer.MAX_VALUE || sum > Integer.MAX_VALUE ||x< Integer.MIN_VALUE
    				||sum < Integer.MIN_VALUE)
       		return 0;
        	     
    		
    		x=x/10;
    	
    		
    	}
		return (int)sum;
        
    }
}
