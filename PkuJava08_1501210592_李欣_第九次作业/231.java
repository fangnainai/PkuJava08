	// 2�����ڶ�������ֻ�����λΪ1��������֮ǰѧ����(n&(n-1))==0���ж�
    public boolean isPowerOfTwo(int n) {
    	if(n>0) return (n&(n-1)) == 0;
        return false;
    }