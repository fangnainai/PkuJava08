/*
 * Count the number of prime numbers less than a non-negative number, n.
 */
public class CountPrimes204 {
	public int countPrimes(int n) {
		// 用一个表格进行素数标记，减少重复运算
		boolean[] isPrimes = new boolean[n];
		// 初始化表格,从数字2开始
		for(int i = 2; i<isPrimes.length; i++){
			isPrimes[i] = true;
		}
		// 只需要判断sqr(n)的数，就可以将<n的非素数标记出来
		for(int i = 2; i*i<n; i++){
			if(isPrimes[i]){
				// 从i*i开始标记，减少重复标记
				for(int j = i*i; j<n; j += i){
					isPrimes[j] = false;					
				}
			}
		}
		int count = 0;
		for(int i = 0; i<isPrimes.length; i++){
			if(isPrimes[i])
				count++;
		}
        return count;
    }
}
