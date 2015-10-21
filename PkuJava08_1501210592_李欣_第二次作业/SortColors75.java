/*
 * 空间复杂度满足O(1),用两个int记录下标用于分割三种颜色
 */
public class Solution {
	public void sortColors(int[] nums) {
//		int red = 0;
		int addColor = 0;
		int white = nums.length-1;
		int blue = nums.length-1;
		for(int i=0; i<nums.length; i++){
			if(i<=white){			
				addColor = 0;		//没有叠加颜色
			}else if(i<=blue){
				addColor = 1;		//叠加了1个度的色差
			}else{
				addColor = 2;		//叠加了2个度的色差
			}
			
			if(nums[i]-addColor == 1){   //原本是白色，添加到白色下标指向的位置
				nums[i]--;			  
				nums[white]++;		  
				white--;
			}else if(nums[i]-addColor == 2){   //原本是蓝色
				nums[i] -= 2;
				if(white<blue){				   //如果已经有白球出现，添加到白色下标和蓝色下标指向的位置（各+1）
					nums[blue]++;
					nums[white]++;
				}else nums[blue] += 2;		   //如果尚未有白球出现，添加到蓝色下标指向的位置（+2）
				blue--;
				white--;
			}
//			if(nums[i]==0){
//				red++;
//			}else if(nums[i]==1){
//				if(i<=white){
//					nums[i]--;
//					nums[white]++;
//					white++;	
//				}else{
//					
//				}
//				
//			}else{
//				
//			}
//			if(i<=white){
////				if(nums[i] == 0){
////					red++;
////				}else 
//				if(nums[i] == 1){
//					nums[i]--;
//					nums[white]++;
//					white--;
//				}else if(nums[i] == 2){
//					nums[i] -= 2;
//					if(white<blue){
//						nums[blue]++;
//						nums[white]++;
//					}else nums[blue] += 2;
//					blue--;
//					white--;
//				}
//			}else if(i<=blue){
////				if(nums[i]-1 == 0){
////					red++;
////				}else 
//				if(nums[i]-1 == 1){
//					nums[i]--;
//					nums[white]++;
//					white--;
//				}else if(nums[i]-1 == 2){
//					nums[i] -= 2;
//					if(white<blue){
//						nums[blue]++;
//						nums[white]++;
//					}else nums[blue] += 2;
//					blue--;
//					white--;
//				}
//			}else{
////				if(nums[i]-2 == 0){
////					red++;
////				}else 
//				if(nums[i]-2 == 1){
//					nums[i]--;
//					nums[white]++;
//					white--;
//				}else if(nums[i]-2 == 2){
//					nums[i] -= 2;
//					nums[blue] ++;					
//					nums[white]++;
//					blue--;
//					white--;					
//				}
//			}
		}

//		for(int i = 0; i<nums.length; i++){
//			System.out.print(nums[i]+",");
//		}
	}

}
