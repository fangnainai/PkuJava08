public class Solution {
    public String addBinary(String a, String b) {
		String ssum = "";
		int flag = 0;
		if(a.length()>b.length()){
			while(a.length()>b.length()){
				b = "0"+b;
			}
		}else{
			while(a.length()<b.length()){
				a = "0"+a;
			}
		}
		for(int i = a.length()-1; i>=0; i--){
			int sum = flag + Integer.parseInt(String.valueOf(a.charAt(i)))+Integer.parseInt(String.valueOf(b.charAt(i)));
			if(sum < 2){
				flag = 0;				
			}else{
				flag = 1;				
			}
			ssum = sum%2 + ssum;
		}
		if(flag==1) ssum = flag+ssum;
		return ssum;
    }
}