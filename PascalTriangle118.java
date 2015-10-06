import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> pascal = new ArrayList<List<Integer>>();  //List和ArrayList的区别是？
		for(int i = 0; i<numRows; i++){
			pascal.add(new ArrayList<Integer>(i+1));
			for(int j = 0; j<=i; j++){
				if(j == 0 || j == i){
					pascal.get(i).add(j, 1);//.set(j, 1);
				}else{
					pascal.get(i).add(j, pascal.get(i-1).get(j-1)+pascal.get(i-1).get(j));
				}
			}
		}
		return pascal;
	}
}
