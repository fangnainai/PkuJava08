﻿public class Solution {
    public int lengthOfLastWord(String s) {
    //int a=strlen(s);
    //char s1 []= s.toString().toCharArray();
    String [] splitStrings = s.split(" ");  //将一个字符串分割为子字符串，然后将结果作为字符串数组返回。 
    //以空格为单位把原字符串分开
            for(int i=splitStrings.length-1;i>=0;i--){  
                if(splitStrings[i].length()>0)  
                    return splitStrings[i].length();  
            }  
            
    //int a=strlen(s1);
    return 0;
    }
}