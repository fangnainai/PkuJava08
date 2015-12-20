
public class MergeSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	  int[] nums1={1,3,5,7,9,0,0,0,0};
	  int m=5;
	  int[] nums2={2,4,6,8};
	  int n=nums2.length;
	  System.out.println(merge(nums1, m, nums2, n));
	  
	  

	}
    public static boolean merge(int[] nums1, int m, int[] nums2, int n) {
    	
      int index = m+n-1;
      int index1 = m-1;
      int index2 = n-1;
      while(index1>=0&&index2>=0){
    	  if(nums2[index2]>nums1[index1]){
    		  nums1[index--]=nums2[index2--];
    	  }else{
    		  nums1[index--]=nums1[index1--];
    	  }
    	 
      }
      while(index1>=0){
    	  nums1[index--]=nums1[index1--];
    	  
      }
      while(index2>=0){
    	  nums1[index--]=nums2[index2--];
    	  
      }
      
      for(int i=0;i<index;i++){
    	  System.out.println(nums1[i]);
      }
	return false;
      
    	
	
        
    }

}
