/*
 * ��Ϊ�������飬��ǰ����ȼۻ��������Ǩ�Ƶ����⣻�Ӻ���ǰ�ȼۼ��ɱ��������
 */
public class MergeSortedArray88 {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int index = nums1.length - 1; 
		while(m > 0 || n > 0){
			if(m == 0){ // ֱ�Ӹ���nums2��nums1
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
