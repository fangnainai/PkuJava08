/*
 * Count the number of prime numbers less than a non-negative number, n.
 */
public class CountPrimes204 {
	public int countPrimes(int n) {
		// ��һ��������������ǣ������ظ�����
		boolean[] isPrimes = new boolean[n];
		// ��ʼ�����,������2��ʼ
		for(int i = 2; i<isPrimes.length; i++){
			isPrimes[i] = true;
		}
		// ֻ��Ҫ�ж�sqr(n)�������Ϳ��Խ�<n�ķ�������ǳ���
		for(int i = 2; i*i<n; i++){
			if(isPrimes[i]){
				// ��i*i��ʼ��ǣ������ظ����
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
