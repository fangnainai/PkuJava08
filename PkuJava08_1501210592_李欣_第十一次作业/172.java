/*
 * Given an integer n, return the number of trailing zeroes in n!.
 * ֻ�е������г���һ��2,5ʱ��n!ĩβ�����һ��0��
 * ��5������С��2�����Լ���5�ĸ�������
 * ����5�ķ����ǣ�sum{n/5,n/25,n/125......}
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
