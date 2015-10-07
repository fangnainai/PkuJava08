import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class PascalsTriangleTwo{
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		Integer rowIndex=in.nextInt();
		System.out.println(getRow(rowIndex));
	
		
	}
//    public static List<Integer> getRow(int rowIndex) {
//    	 List<List<Integer>> ListSet= new ArrayList<List<Integer>>();
//    	
//		 if(rowIndex<0)  
//		        return null; 
//		 int i;
//		 int j;
//		 
//		 List<Integer> List0=new ArrayList<Integer>();
//		 List0.add(1);//创建第一行的list将1添加进去
//		 ListSet.add(List0);
//		 for(i=1;i<=rowIndex;i++){
//			 List<Integer> List=new ArrayList<Integer>();
//			 List.add(1);
//			 List<Integer> pre = ListSet.get(ListSet.size()-1);//前一行
//			
//			 for(j=1;j<i;j++){
//				 List.add(pre.get(j)+pre.get(j-1));//前一行的第j个和第j－1个数的相加
//				// List.add(1); 
//			 } 
//			 List.add(1);//每行的最后一个数1
//			 ListSet.add(List);
//		 }
//		 
//	    //ListSet.addAll(ListSet);
//		 List<Integer> index = ListSet.get(rowIndex);
//		 return  index;
//	        
//	    }
  /**以上方法是基于118修改的，每一行都需要存储，较费空间，为了节省空间采用以下方法
   * 
   * @param rowIndex
   * @return
   */
	public static List<Integer> getRow(int rowIndex) {  
	    List<Integer> res = new ArrayList<Integer>();  
	    if(rowIndex<0)  
	        return res;  
	    res.add(1);  
	    for(int i=0;i<rowIndex;i++){  
	      
	    	 for(int j=i-1;j>=0;j--){  
	            res.set(j+1,res.get(j)+res.get(j+1)); //将现在的第j个和第j+1个数作为新的第j+1的值
	        }  
	        res.add(1);  
	    }  
	    return res;  
	}  

}
