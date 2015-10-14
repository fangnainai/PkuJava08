import java.util.ArrayList;


public class RemoveElement {
	public static void main(String[] args){
		int[] nums={4,5};
		int val=5;
		System.out.println(removeElement(nums, val));
		
	}
	/**
	 * 新认识了arrycopy总想用用，一开始觉得可以用arraycopy来复制从而获得新的数组，但是由于数组长度问题，则方法未果
	 */
//	 public static int removeElement(int[] nums, int val) {
//		 int len=nums.length;
//		 int n;
//		 int[] ary = new int[n];
//		 for(int i=0;i<len;i++){
//			 if(nums[i]==val){
//				 System.arraycopy(nums, 0,ary, 0, i);
//				 System.arraycopy(nums, i+1,ary, i,ary.length-i-1);
//				 
//			 }
//			 
//		 }
//		 
//		
//		return ary.length;
//	        
//	    }
	/**
	 * 还是list比较好用动态数组呢,但是一直ac不了，好奇怪，明明好简单的一道题啊
	 * @param nums
	 * @param val
	 * @return
	 */
//	public static int removeElement(int[] nums, int val) {
//		
//		int len=nums.length;
//		ArrayList L = new ArrayList();
//		for(int i=0;i<len;i++){
//			 if(nums[i]==val)
//				 continue;
//		         L.add(nums[i]);
//		  }
////		for (int i = 0; i < L.size(); i++)
////		      nums[i] =(int) L.get(i);
//		return L.size();
//		
//		
//		
//	}
	public static int removeElement(int[] nums, int val) {
	int len = 0;  
    for (int i = 0; i < nums.length; ++i)  
    {  
        if (nums[i] != val)  
            nums[len++] = nums[i];  
    }  
    return len;  
}  


}
