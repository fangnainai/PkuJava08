import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class PascalsTriangle {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		Integer numRows=in.nextInt();
		 System.out.println(generate(numRows));
	
		
	}
	 public static List<List<Integer>> generate(int numRows) {
		 List<List<Integer>> ListSet= new ArrayList<List<Integer>>();
		 if(numRows<=0)  
		        return ListSet; //需要考虑到输入值小于等于0，不然输出结果都是［1］
		 int i;
		 int j;
		 List<Integer> List1=new ArrayList<Integer>();
		 List1.add(1);//创建第一行的list将1添加进去
		 ListSet.add(List1);
		 for(i=2;i<=numRows;i++){
			 List<Integer> List=new ArrayList<Integer>();
			 List.add(1);
			 List<Integer> pre = ListSet.get(ListSet.size()-1);//前一行
			 for(j=1;j<i-1;j++){
				 List.add(pre.get(j)+pre.get(j-1));//前一行的第j个和第j－1个数的相加
				// List.add(1); 
			 } 
			 List.add(1);//每行的最后一个数1
			 ListSet.add(List);
		 }
		 
	    //ListSet.addAll(ListSet);
		return ListSet;
	        
	    }

}
