
public class ExcelSheetColumnTitle {
	 public static void main(String[] args) {
	        int titleToNumber = new ExcelSheetColumnTitle().titleToNumber("AAA");
	        System.out.println(titleToNumber);
	    }
     /**
      * 26进制转换成10进制度
      * @param s
      * @return
      */
	 public int titleToNumber(String s) {
	        if (null == s || 0 == s.length()) {
	            return 0;
	        }
	        char[] charArray = s.toCharArray();//将字符串传专程字符数组
//	        System.out.println(charArray);
	        int sum = 0;  
	        int tmp = 0;  
	        for (int i = 0; i < charArray.length; ++i) {  
	            tmp = charArray[i] - 'A' + 1; //将ASC值转换成题目要求的
//	            System.out.println(tmp);
	            sum = 26 * sum + tmp; // 
	        }  
	        return sum; 
	    }

	   
}
