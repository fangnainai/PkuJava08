﻿public class Solution {
    public String addBinary(String a, String b) {
    int m = a.length();
    int n = b.length();
    int carry = 0;
    String res = "";
    int maxLen = Math.max(m, n);
    for (int i = 0; i < maxLen; i++) {
        int p=0,q=0;
        if(i<m)
            p = a.charAt(m-1-i) - '0';
        else
            p = 0;
        
        if(i<n)
            q = b.charAt(n-1-i)-'0';
        else
            q = 0;
            
        int tmp = p + q + carry;
        carry = tmp / 2;
        res = tmp % 2 + res;
    }
    return (carry == 0) ? res : "1" + res;
   
    }
}