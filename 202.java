import java.util.HashSet;
import java.util.Scanner;


public class HappyNumber {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		Integer n=in.nextInt();
		//boolean result=isHappy(n);
		 System.out.println( isHappy(n));
	
		
	}
	 public static boolean isHappy(int n) {
		 HashSet<Integer> set = new HashSet<>();//创建hash集合，存放int类型的对象
	        int sum = n;
	        while (sum != 1) {
	            n = sum;
	            sum = 0;
	            while (n != 0) {
	                sum =sum+ (n % 10) * (n % 10);
	                n =n/10;
	            }
	            if (set.contains(sum)) {
	                return false;
	            }
	            set.add(sum);
	        }
	        return true;
	    }
}
