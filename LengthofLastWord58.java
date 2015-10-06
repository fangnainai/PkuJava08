
public class Solution {
	public int lengthOfLastWord(String s) {
		int count = 0;
		if(s == null){
			return 0;
		}else{
			int index = s.length()-1;
			while(index>=0 && s.charAt(index)==' '){
				index--;
			}
			while(index>=0 && s.charAt(index)!=' '){
				count++;
				index--;
			}			
		}
		return count;		
	}
}
