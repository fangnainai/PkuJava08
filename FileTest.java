import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

import java.util.Set;


public class FileTest {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Set<String> result = new HashSet<String>();
		Set<String> set1 = new HashSet<String>();
		Set<String> set2 = new HashSet<String>();
		String path1 = "D://t.txt";//文件路径
		String path2 = "D://q.txt";//文件路径
		BufferedReader br1=new BufferedReader(new FileReader(path1));//文本文件作为命令行传递
		BufferedReader br2=new BufferedReader(new FileReader(path2));//文本文件作为命令行传递
	    String t="";
	    String q="";
	    while((t=br1.readLine())!=null){
	    	 String[] words = t.split("\\W");
	         for(int i=0;i<words.length;i++){ set1.add(words[i]);}
	     }
	    while((q=br2.readLine())!=null){
	    	 String[] words = q.split("\\W");
	         for(int i=0;i<words.length;i++){ set2.add(words[i]);}
	     }
	  

		//交集
		result.clear();
		result.addAll(set1);
		result.retainAll(set2);
		System.out.println("交集："+result);
		
	    //并集
		result.clear();
		result.addAll(set1);
		result.addAll(set2);
		System.out.println("并集："+result);
		
		//差集text1减去text2
		result.clear();
		result.addAll(set1);
		result.removeAll(set2);
		double a=(double)result.size()/(double)set1.size()*100;
		set1.size();
		System.out.println("差集text1减去text2："+a+"%");
//		System.out.println("差集text1减去text2："+set1.size());
		
		//差集text2减去text1
		result.clear();
		result.addAll(set2);
	    result.removeAll(set1);
		double b=(double)result.size()/(double)set2.size()*100;
	    result.size();
		System.out.println("差集text2减去text1："+b+"%");
		
		
		 

	}
	
}
