public class MoveZeroes283 {
	public void moveZeroes(int[] nums) {
		/*int last = nums.length - 1;
		for(int i = 0; i < last; i++){
			if(nums[i] == 0){
				while(nums[last] == 0 && last > i){
					last--;
				}
				nums[i] = nums[last];
				nums[last] = 0;
			}
		}*/
		int index = 0;
		for(int i = 0; i< nums.length; i++){
			if(nums[i] != 0){
				nums[index] = nums[i];				
				if(i > index) nums[i] = 0;
				index++;
			}
		}
	}
}