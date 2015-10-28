package com.zhuanzhuan;

import java.util.Arrays;

public class RemoveElement {
	 public static int removeElement(int[] nums, int val) {
	     int i=0;
	     int j=nums.length-1;
	     
		 if(nums==null||nums.length==0)
	    	 return 0;
//
//		 for (i=0;i<nums.length;i++)
//		 {
//			 if(nums[i]!=val)
//			 {	 
//					 nums[j]=nums[i];
//			          j++;
//			 }
//		 }
//      return j;	
		 while(i<=j){
			 if(nums[i]==val){
				 nums[i]=nums[j];
				 nums[j]=val;
				 j--;
			 }else{
				 i++;
			 }
		 }
		 return i;
	 }
		
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {1,1,1,2,3};
		int elem = 1;
		System.out.println(removeElement(num, elem));
		System.out.println(Arrays.toString(num));
	}

}
