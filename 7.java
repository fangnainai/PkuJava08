public class Solution {
    public int reverse(int x) {
        int result = 0;		
		while(x != 0){
			if(result < -214748364 || (result == -214748364 && x%10 < -8) || result > 214748364 || (result == 214748364 && x%10 > 7))
				return 0;
			result = x%10 + result*10;
			x /= 10;			
		}
		return result;
    }
}