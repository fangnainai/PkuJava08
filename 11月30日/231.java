
public class PowerofTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=8;
		System.out.println(isPowerOfTwo(n));

	}
	/**
	 * 判断一个数是否是由2的幂次得来的
	 * 连续除以2，直至得到的数是否为1
	 * @param n
	 * @return
	 */
   public static boolean isPowerOfTwo(int n) {
	   if(n<=0) return false;
       while(n>0)
       {
           if(n%2==1&&n!=1) return false;
           n/=2;
       }
       return true;
       
    }

}
