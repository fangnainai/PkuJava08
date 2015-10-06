import java.util.HashSet;

public class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<Integer>();
		int sum = 0;
		while(true){
			sum = 0;
			while(n>0){
				sum += Math.pow(n%10, 2);
				n /= 10;
			}
			if(sum == 1) return true;
			if(set.contains(sum)) return false;
			else set.add(sum);
			n = sum;
		}
    }
}