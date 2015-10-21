/*
 * 先整体翻转，再分别翻转前k个和余下部分
 * 空间复杂度为O(1)
 */
public class Solution {
	public void rotate(int[] nums, int k) {	
		k %= nums.length;	
		reverse(nums,0,nums.length-1);
		reverse(nums,0,k-1);
		reverse(nums,k,nums.length-1);
		
//		int index = 0;
//		int temp = nums[index];
//		for(int i = 0; i<nums.length; i++){
//			if(index == k){
//				nums[index] = temp;
//			}else if(index<k){
//				nums[index] = nums[index+nums.length-k];
//				index += nums.length-k;
//			}else{
//				nums[index] = nums[index-k];
//				index -= k;
//			}
//		}
//
//		for(int i = 0; i<nums.length; i++){
//			System.out.print(nums[i]+",");
//		}
	}

	public void reverse(int[] nums, int start, int end){
		for(int i = start; i<(end+start+1)/2; i++){
			nums[i] += nums[end+start-i];
			nums[end+start-i] = nums[i] - nums[end+start-i];
			nums[i] -= nums[end+start-i];
		}
	}
}
