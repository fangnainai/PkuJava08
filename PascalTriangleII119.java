import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<Integer> getRow(int rowIndex) {
		List<Integer> pascal2 = new ArrayList<Integer>();
		for(int i = 0; i<=rowIndex; i++){
			pascal2.add(0, 1);
			for(int j = 1; j<i; j++){
				pascal2.set(j,pascal2.get(j+1)+pascal2.get(j));
			}
		}
		return pascal2;
	}
}
