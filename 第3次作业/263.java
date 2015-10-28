package com.zhuanzhuan;

public class UglyNumber {
	 public static boolean isUgly(int num) {
//	      if(num==0) return false;
//	      int rem2=num%2;
//	      int rem3=num%3;
//	      int rem5=num%5;
//	      while(rem2==0||rem3==0||rem5==0){
//	    	  if(rem2==0){
//	    		  num=num/2;
//	    	  }else if(rem3==0){
//	    		  num=num/3;
//	    	  }else if(rem5==0){
//	    		  num=num/5;
//	    	  
//	    	  }
//	    	  rem2=num%2;
//	    	  rem3=num%3;
//	    	  rem5=num%5;
//	      }
//	      return num==1;
		 for (int i=2; i<6 && num>0; i++)
			 while (num % i == 0)
			 num /= i;
			return num == 1;
			//return (num == 1) ?  true: false;
	    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num=14;
		  boolean result = isUgly(num);
			System.out.println(result);
	}

}
