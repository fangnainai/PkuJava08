﻿public class Solution {
    public int addDigits(int num) {
       int result=num;
        while(true){
            if(result<10){
                return result;
            }
            num=result;
            result=0;
            while(num!=0){
              result=result+num%10;
              num=num/10;
            }
        }
    }
}