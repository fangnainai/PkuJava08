package com.zhuanzhuan;

public class TwoSum {
	 public static int[] twoSum(int[] nums, int target) {
	     int[] index=new int[2] ;
		 for(int i=0;i<=nums.length-1;i++){
	    	 for(int j=i+1;j<=nums.length-1;j++){
	    		if(nums[i]+nums[j]==target){
	    			index[0]=i+1;
	    		   index[1]=j+1;
	    		   break;
	    	 }
	     }
		 if(index[1]!=0)
			 break;
		 
	    }
		 return index;
	 }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    int[] num={1,2,3,4,5};
		int target = 6;
		 int[] a = twoSum(num,target);
		System.out.println("index1="+a[0]+",index2="+a[1]);
	}

}
