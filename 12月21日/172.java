
public class FactorialTrailingZeroes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int n=25;
       System.out.println(trailingZeroes (n));
	}
	/**
	 * n = 5, 5!的质因子中 (2 * 2 * 2 * 3 * 5)包含一个5和三个2。因而后缀0的个数是1。
	 * n = 11, 11!的质因子中(2^8 * 3^4 * 5^2 * 7)包含两个5和三个2。于是后缀0的个数就是2。
	 * n!中0的个数＝n！中5的个数
	 * @param n
	 * @return
	 */
	 public static int trailingZeroes(int n) {
	      int res = 0;  
	        while(n!=0)  
	        {  
	            res =res+n/5;  
	            n =n/5;  
	        }  
	        return res;  
	    }    

}
