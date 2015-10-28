public class Solution {
        int max(int a ,int b){
           return a>b?a:b;
        }
         public int maxDepth(TreeNode root) {
             if(root==null){
                 return 0;
             }
             return max(maxDepth(root.left),maxDepth(root.right))+1;
         }
  }
 