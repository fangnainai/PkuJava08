import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ValidPalindrome {
	public static void main(String[] args){
		String s="a man,a plan,a canal:Panana";
		
	
		System.out.println(isPalindrome( s));
        //System.out.println(m.replaceAll("").trim()); 
     
		
	}
	/**
	 * 正则表达式去掉特殊字符，再进行前后对比，但是在leetcode中当输入值是“”，正则表达式无法通过
	 */
//  public static boolean isPalindrome(String s) {
//	 if(s.length()==0)
//		 return true;
//	
//	 String st= s.toLowerCase();//将字母转换为小写
//	 System.out.println(st);
//	     String   str =st.replaceAll(" ", "");
//    System.out.println(str);
//    
//	 String regEx="[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】'；：”“’。，、？]"; 
//	     Pattern   p   =   Pattern.compile(regEx);          
//	     Matcher   m   =   p.matcher(str);          
//	     String    a   =   m.replaceAll("").trim();
//	     System.out.println(a);
//	    
//
//	  for (int i = 0,  j = a.length()-1; i <= j; ++i, --j)  
// {  
//     if(a.charAt(i) != a.charAt(j) )  
//         return false;  
// }  

	 


   
//}
	/**
	 * 先将字母大小写转换成统一的，用正则表达式去掉特殊字符，然后从第一个最后一个相比较
	 * 但由于存在特殊字符，所以将比较的字符进行判断，只有在a－z之间的才能比较
	 * @param s
	 * @return
	 */
	 public static boolean isValid(char c){
         if(c >= 'a' && c <= 'z') return true;
         if(c >= '0' && c <= '9') return true;
         return false;
     }
     public static boolean isPalindrome(String s) {
         
        if(s.equals("")) return true;
        s = s.toLowerCase();//转换成小写
        int len = s.length();
        int i = 0, j = len - 1;
        while(i< j){
            while(!isValid(s.charAt(i))){
                i++;
                if(i>= j) return true;
            } 
            while(!isValid(s.charAt(j))){
               j--;
                if(i >= j) return true;
            }
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
            }
        return true;
 
	
        
    }

}
