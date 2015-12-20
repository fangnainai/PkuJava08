/*
 * 因为这是数组，从前往后比价会产生数据迁移的问题；从后往前比价即可避免此问题
 */
public class MergeSortedArray88 {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int index = nums1.length - 1; 
		while(m > 0 || n > 0){
			if(m == 0){ // 直接复制nums2到nums1
				for(;n>0;n--,index--){
					nums1[index] = nums2[n-1];
				}
				break;
			}else if(n == 0){
				for(;m>0;m--,index--){
					nums1[index] = nums1[m-1];
				}
				break;
			}
			if(nums2[n-1] > nums1[m-1]){
				nums1[index] = nums2[n-1];
				n--;
				index--;
			}else{
				nums1[index] = nums1[m-1];
				m--;
				index--;
			}
		}
	}
}
