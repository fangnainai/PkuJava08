	// 2的幂在二进制中只有最高位为1，可以用之前学过的(n&(n-1))==0来判断
    public boolean isPowerOfTwo(int n) {
    	if(n>0) return (n&(n-1)) == 0;
        return false;
    }