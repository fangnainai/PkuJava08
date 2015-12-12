
public class MoveZeroes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums={0,1,2,0,3};
		System.out.println(moveZeroes(nums));

	}
   
	
	
	public static int[]  moveZeroes(int[] nums) {
		int l=nums.length;
		
		int sum=0;
		for(int i=0;i<l-1;i++){
			
			if(nums[i]==0){ 
				sum=sum+1;
				
			}else{
				nums[i-sum]=nums[i];
			}
		}
		for(int j=0;j<sum;j++){
			nums[l-sum+j]=0;
		}
			
	    System.out.println("result:"+nums);
		return nums;
	

	
        
    }

}
