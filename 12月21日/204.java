
public class CountPrimes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=16;
		System.out.println(countPrimes(n) );

	}
	/**
	 * 解题方法就在第二个提示埃拉托斯特尼筛法Sieve of Eratosthenes中，
	 * 这个算法的过程如下图所示，我们从2开始遍历到根号n，先找到第一个质数2，
	 * 然后将其所有的倍数全部标记出来，然后到下一个质数3，标记其所有倍数，
	 * 一次类推，直到根号n，此时数组中未被标记的数字就是质数。
	 * @param n
	 * @return
	 */
	 public static int countPrimes(int n) {  
	     //2,3,5,7,11,13,19   

	     boolean[] a = new boolean[n];  
	     for(int i=2; i*i<n; i++) {  
	        if(!a[i]) {  
	            for(int j=i; i*j<n; j++) {  
	                a[i*j] = true;  
	            }  
	        }  
	     }  
	     int c=0;  
	       
	     for(int i=2; i<n; i++) {  
	         if(a[i] == false) ++c;  
	     }  
	     return c;  
	    }  

}
