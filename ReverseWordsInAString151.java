import java.util.Stack;

public class Solution {
    public String reverseWords(String s) {
		String[] str = s.trim().split("\\s+"); //������ʽ����ʾ����ո�		
		Stack<String> sk = new Stack<String>();
		for(int i = 0; i<str.length-1; i++){
			sk.push(" "+str[i]);
		}
		sk.push(str[str.length-1]);
		s = "";
		while(!sk.empty()){
			s += sk.pop();
		}
		return s;
	}
}