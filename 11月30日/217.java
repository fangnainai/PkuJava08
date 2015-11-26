import java.util.HashSet;
import java.util.Set;


public class ContainsDuplicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums={1,2,3,4,4};
		System.out.println(containsDuplicate(nums));
	}
	/**
	 * 可以用一个hashset来遍历数组，用contains（value）来判断是否有重复的数
	 * @param nums
	 * @return
	 */
    public static boolean containsDuplicate(int[] nums) {
    	Set<Integer> set = new HashSet<Integer>();  
        for(int i = 0; i < nums.length; i++){  
            if(!set.contains(nums[i])){  
                set.add(nums[i]);  
            } else return true;  
        }  
        return false; 
    }
}
