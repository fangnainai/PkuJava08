/*
 * 注意各种测试情况
 */
public class Solution {
	public int myAtoi(String str) {
		int n = 0;
		int isPos = 0; //1为正；-1为负；0表示数字尚未开始
//		String numStr = "";
		char[] chars = str.toCharArray();
//		boolean flag = false;
		for(int i = 0; i<chars.length; i++){
			if(chars[i] != ' '){
				if(chars[i]>='0' && chars[i]<='9'){
					if(isPos==0) isPos = 1;
					if(n > 214748364 || (n == 214748364)&&(chars[i] - '0')>7){
						n = Integer.MAX_VALUE;
						break;
					}else if(n < -214748364 || (n == -214748364)&&(chars[i] - '0')>7){
						n = Integer.MIN_VALUE;
						break;
					}else{
						n = isPos*(chars[i] - '0') + n*10;
					}
				}else if(chars[i]=='-' && isPos==0){
					isPos = -1;
				}else if(chars[i]=='+' && isPos==0){
					isPos = 1;
				}else{
					break;
				}
			}
		}
		System.out.println(n);
		return n;
//		for(int i = 0; i<chars.length; i++){
//			if(flag==true || chars[i] != ' '){	
//				if(((int)chars[i]>=48 && (int)chars[i]<=57) || (chars[i]=='-' && flag==false)){
//					numStr += chars[i];
//				}else if(chars[i]=='+' && flag==false);
//				 else break;
//				flag = true;
//			}			
//		}
//		if(numStr.length()>0 && !numStr.equals("-")){
//			try {
//				n = Integer.parseInt(numStr);
//			} catch (NumberFormatException e) {
//				// TODO Auto-generated catch block
//				if(numStr.startsWith("-")){
//					n = Integer.MIN_VALUE;
//				}else{
//					n = Integer.MAX_VALUE;
//				}
////				e.printStackTrace();
//			}
//		}
//		System.out.println(n);
//		return n;
	}
}
