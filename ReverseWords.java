
public class ReverseWords {
	public static void main(String[] args) {  
        
        String s = " I Love me ";  
        s = reverseWords(s);  
        System.out.println(s);  
    }  
  
    public static String reverseWords(String s) {  
         if(s.length()==0) 
        	return "";  
         String[] strArry = s.split("\\s+"); //在有一个或多个空格的地方进行拆分字符串
         int len = strArry.length;  
         if(len == 0) 
        	return "";  //虽然前面已经做过判断，但是经过split后会把首尾的空格都去掉
         StringBuffer sb = new StringBuffer(); 
         int index = len-1;  
         /**
          * 进行字符串连接,因为首尾不能有空格，则需要先将最后一个字符串先输出,然后将剩下的字符串以空格＋字符串的形式倒序输出
          */
         sb.append(strArry[index]);
         for(int i = index-1; i >= 0; i--) {  
              if(!strArry[i].isEmpty()) {  
                sb.append(" ").append(strArry[i]);  
            }  
        }  
        return sb.toString();  
    }  
}
