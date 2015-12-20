/*
 * Given an integer n, return the number of trailing zeroes in n!.
 * 只有当因子中出现一对2,5时，n!末尾会出现一个0；
 * 而5的数量小于2，所以计算5的个数即可
 * 计算5的方法是，sum{n/5,n/25,n/125......}
 */
public class FactorialTrailingZeroes {
	public int trailingZeroes(int n) {
		int count = 0;
		while(n/5 > 0){
			n /= 5;
			count += n;			
		}
		return count;
	}
}
