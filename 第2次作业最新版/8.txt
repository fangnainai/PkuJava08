// 写atoi函数的时候需要注意一下几点

// 1. 字符串前的空白

// 2. 字符串所表示数值的正负号

// 3. 结束条件，遇到非数字或者字符'\0'结束

// 4. 考虑溢出，分别与int值所能表示的最大(0x7fffffff)和最小值(0x8000000)进行比较

// 5. 考虑异常输入情况下，用全局变量valid来标识，对于"+/-"  "0" "+abc"需要进行区分
public class Solution {
   public  static int myAtoi(String str) {
	        if(str==null||str.length()==0)return 0;
	        //char[] arr=str.toCharArray();
	        str=str.trim();
	        boolean positive=true;
	        long sum=0;
	        
	        for(int i=0;i<str.length();i++){
//	            if(i==0 && arr[i]=='+'||arr[i]=='-'){
//	            	if(arr[i]=='-'){
//	            	   positive=false;	
//	            	}else{
//	            	   // return 0;
//	            		continue;
//	            	}
//	                //continue;
//	            }
//	              
//	            if(arr[i]<'0'|| arr[i]>'9'){    
//	            	break;
//	            }
//	            else{
//	            	sum=10*sum+arr[i]-'0';
//	            }
	        if(i==0&&str.charAt(i)=='-'){
	        	positive=false;
	            continue;
	           }else if(i==0 && str.charAt(i)=='+'){
	        	   continue;
	           }
	        if('0'<=str.charAt(i)&&str.charAt(i)<='9'){
	        	sum=sum*10+str.charAt(i)-'0';
	        	if(sum>2147483647) //如果不在循环里面判断的话，一但超出sum所表示的范围,这个数的正负号可能就反了这样就会导致判断上界和下界时出错
	        	break;
	        }else{
	        	break;
	        }
	    }
	    if(positive==false)
	    	sum=0-sum;
	    if(sum<-2147483648){
	    	return -2147483648;
	    }else if(sum>2147483647){
	    	return 2147483647;
	    }else{
	    	return (int) sum;
	    }
	 
	 }

}