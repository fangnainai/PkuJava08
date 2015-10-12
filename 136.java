

public class SingleNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums={1,1,2,2,3,4,4,5,5};
		System.out.println(singleNumber(nums));
	}
 /**
  * 可以通过一个数跟后面的数进行一一比较，若一样则使这两个flag＝1，不相等flag＝0，
  * 然后输出flag=0的值。
  * @param nums
  * @return
  */
//	public static int singleNumber(int nums[]) {
//		int i;
//		int j;
//		int len=nums.length;
//		int[] flag=new int[len];
//		 for(i = 0; i < len; i++)  {
//		     if(flag[i] == 1)
//		         continue;
//		      else  {
//		               for(j = i + 1; j < len; j++)  {
//		                   if(nums[i] == nums[j])    {
//		                     flag[i] = 1; 
//		                     flag[j] = 1;
//		                     }
//		                 }
//		             }
//		         }
//		         
//		         for( i = 0; i < len; i++)  {
//		             if(flag[i] == 0)
//		                 return nums[i];
//		         }
//		         return nums[i];
//		     }
	/**
	 * 由于上述方法虽然AC里，但是运行速度过于慢，所以在网上查到这种方法
	 * 和大家分享学习一下：这个是通过利用异或操作。异或的性：交换律a ^ b = b ^ a，
	 * 0 ^ a = a。于是利用交换律可以将数组假想成相同元素全部相邻，于是将所有元素依次做异或操作，
	 * 相同元素异或为0，最终剩下的元素就为Single Number。
	 * @param nums
	 * @return
	 */
	public static  int singleNumber(int nums[]) {
		int len=nums.length;      
		          //异或
		        int elem = 0;
		          for(int i = 0; i < len ; i++) {
		              elem = elem ^ nums[i];
		          }
		         
		         return elem;
		     }
}

   
   
   
  
