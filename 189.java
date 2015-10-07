
public class RotateArray {
	
	    /**
		 * 以n-k为界限，之前的和之后的都reverse，然后再整体reverse一次
		 * @param nums
		 * @param k
		 */
		public void rotate(int[] nums, int k) {
			int len = nums.length;
	        k %= len;//K可能会大于总长度len,所以取余
	        reverse(nums, 0, len-k-1);
	        reverse(nums,len-k , len-1);
	        reverse(nums, 0, len-1);
	    }
		/**
		 * reverse方法
		 * @param nums
		 * @param begin
		 * @param end
		 */
		public void reverse(int[] nums, int begin, int end) {
	        while (begin <= end) {
	              int temp = nums[begin];
	              nums[begin] = nums[end];
	              nums[end] = temp;
	              begin++;
	              end--;
		       }
	      }
	}
