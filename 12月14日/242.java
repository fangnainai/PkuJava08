import java.util.Arrays;


public class ValidAnagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="cada";
		String t="daac";
		System.out.println(isAnagram(s, t));

	}
	/**
	 *可以先将字符串转换成数组，然后将数组进行排序
	 *对比两个数组是否相等
	 * @param s
	 * @param t
	 * @return
	 */
	 public static boolean isAnagram(String s, String t) {
		 //字符串转换成数组
		 char[] sArr = s.toCharArray();  
	     char[] tArr = t.toCharArray();  
	    //对数组进行排序    
	     Arrays.sort(sArr);  
	     Arrays.sort(tArr);  
	     return Arrays.equals(sArr,tArr);       
//	     return String.valueOf(sArr).equals(String.valueOf(tArr)); 
		 
		 
	
	        
	    }

}
