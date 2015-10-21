public class Solution {
    public boolean isPalindrome(String s) {
		if(s.length() == 0) return true;
		int start = 0;
		int end = s.length()-1;
		s = s.toLowerCase();
		while(start < end){
			if(!isAlphanumeric(s.charAt(start))){
				start++;
			}else if(!isAlphanumeric(s.charAt(end))){
				end--;
			}else{
				if(s.charAt(start) == s.charAt(end)){
					start++;
					end--;
				}else return false;
			}
		}
		return true;
	}
	
	public boolean isAlphanumeric(char a){
		if((a >= 'a' && a <= 'z') || (a >= '0' && a <= '9')) return true;
		else return false;
	}
}