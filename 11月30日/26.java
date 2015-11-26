
public class RemoveDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums={1,1,2,2,3,4,4,5,5};
		System.out.println(removeDuplicates(nums));
	}
   /**
    * 使后面的数和前面的数进行比较，如果不一样就使count＋1，
    * 最终结果返回count，即为无重复的个数
    * @param nums
    * @return
    */
   public static int removeDuplicates(int[] nums) {
	   int len = nums.length;
	    if (len == 0)
	        return 0;
	    int count = 1;
	    for (int i = 1; i < len; i++) {
	        if (nums[i] == nums[i - 1]) {
	            continue;
	        }else{
	            nums[count] = nums[i];//因为数组不能删除元素，则可以将非重复的数覆盖重复的数
	            count++;
	        }
	    }
	    return count;
	
	 
       
    }

}
