/*
 * �ռ临�Ӷ�����O(1),������int��¼�±����ڷָ�������ɫ
 */
public class Solution {
	public void sortColors(int[] nums) {
//		int red = 0;
		int addColor = 0;
		int white = nums.length-1;
		int blue = nums.length-1;
		for(int i=0; i<nums.length; i++){
			if(i<=white){			
				addColor = 0;		//û�е�����ɫ
			}else if(i<=blue){
				addColor = 1;		//������1���ȵ�ɫ��
			}else{
				addColor = 2;		//������2���ȵ�ɫ��
			}
			
			if(nums[i]-addColor == 1){   //ԭ���ǰ�ɫ����ӵ���ɫ�±�ָ���λ��
				nums[i]--;			  
				nums[white]++;		  
				white--;
			}else if(nums[i]-addColor == 2){   //ԭ������ɫ
				nums[i] -= 2;
				if(white<blue){				   //����Ѿ��а�����֣���ӵ���ɫ�±����ɫ�±�ָ���λ�ã���+1��
					nums[blue]++;
					nums[white]++;
				}else nums[blue] += 2;		   //�����δ�а�����֣���ӵ���ɫ�±�ָ���λ�ã�+2��
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
