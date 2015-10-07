public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
     int a=0;
     while(n!=0){
         if((n&1)==1){
         a=a+1;
         }
         n=n>>>1;
      }
         return a;
    }
}