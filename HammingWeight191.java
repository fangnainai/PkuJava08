
public class Solution{
	// you need to treat n as an unsigned value
    public int hammingWeight(int n) {
    	int count = 0;
    	while(n!=0){   //不能写n>0....不是很清楚
    		n &= (n-1);
    		count++;
    	}
        return count;
    }
}
