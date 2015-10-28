public class Solution {
    public int singleNumber(int[] nums) {
         int i;
	       for( i=0;i<nums.length-1;i++){
	    	   int a=nums[i]^nums[i+1];
	    	   nums[i+1]=a;//以2进制数异或的，比如{1,2,1,2,5}a的值为3,2,0,5
	       }
	       return nums[i];
		 
    }
}