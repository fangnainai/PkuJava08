
public class IntegerToRoman {

	public static void main(String[] args) {
		int num=199;
		System.out.println(intToRoman(num));

	}
	/**
	 * 相同的数字连写，所表示的数等于这些数字相加得到的数，如：Ⅲ = 3；
	 *  小的数字在大的数字的右边，所表示的数等于这些数字相加得到的数， 如：Ⅷ = 8；Ⅻ = 12；
	 *  小的数字，（限于Ⅰ、X 和C）在大的数字的左边，所表示的数等于大数减小数得到的数，如：Ⅳ= 4；Ⅸ= 9；
	 *   正常使用时，连写的数字重复不得超过三次。
	 *   1=I,V=5,X=10,L=50,C=100,D=500,M=1000.
     * @param num
	 * @return
	 */
	 public static String intToRoman(int num) {
		 int t = (num / 1000) % 10, h = (num / 100) % 10, d = (num / 10) % 10, n = num % 10;
		 StringBuffer res = new StringBuffer();
	     setDigit(res, t, 'M', '?', '?');
		 setDigit(res, h, 'C', 'D', 'M');
		 setDigit(res, d, 'X', 'L', 'C');
		 setDigit(res, n, 'I', 'V', 'X');
		 return res.toString();
		 
	 }
	 static void setDigit(StringBuffer res, int n, char a, char b, char c) {
		 if (n<4){
			 for(int i=0;i<n;++i){
				 res.append(a);
			 }
		 }
		 if(n==4){
			 res.append(a).append(b);
			

		 }
		 if(n==5) res.append(b);
		 if(n>5&&n<9){
			 res.append(b);
			 for(int i=5;i<n;++i){
				 res.append(a);
			 }
		 }
		 if(n==9){
			 res.append(a).append(c);
		
		 }
             
	 }
	
//	
//	 /**
//	  * 网上有较为简洁的答案
//	  * @param num
//	  * @return
//	  */
//	 public static String intToRoman(int num) {
//        String[] str = new String[] { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
//        int[] val = new int[] { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
// 
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; num > 0; i++) {
//             
//            while (num >= val[i]) {
//                num -= val[i];
//                sb.append(str[i]);
//            }
// 
//        }
//        return sb.toString();
// 
//    }
   
		 

	        
 }

