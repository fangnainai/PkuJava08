package com.zhuanzhuan;

public class ReverseInteger {
	 public static int reverse(int x) {
		
		 int negative=1;
	        if(x<0){
	        	negative=-1;
	        	x=-x;
	        }
	       long temp=0;
	       long y=0;
	        while(x>0)
	        {
	        	temp=x%10;
	        	x=x/10;
	        	y=y*10+temp;
	        	 
	        }
	        if(y>Integer.MAX_VALUE)
	        	return 0;
	        else{
	        	return (int )(y*negative);
	        }
	    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println("result="+reverse+("-123"));
		System.out.println("result= "+ reverse(1534236469));

	}

}
