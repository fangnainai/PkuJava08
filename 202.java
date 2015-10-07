import java.util.HashSet;//直接引用java自身的函数
//import java.util.*;
public class Solution {
    public static boolean isHappy(int n) {
	   //int num;
    	
	   int result=n;
	   HashSet<Integer> set = new HashSet<>(32);//建立哈希表   
	    while(n!=1&&!set.contains(n)){
                 set.add(n);//把n放到哈希表里
	             result=0;
	             while(n>0){//循环相加结的每一位的平方
	             int num=n%10;
		         result=result+num*num;
		         n=n/10;  
	             }
	             n=result;
	     }
//	   if(result==1)
//		   return true;
//	   else
//	   { n=result;
//	       result=0;
//	   }
    return n == 1;
    }
}
//	   n=result;
//	   if(n==1)
//		   return true;
//	   else
//		  // n=result;
//	      
//		   return false;
	   