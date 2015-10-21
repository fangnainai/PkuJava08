/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        int len = 0;
		if(root != null){
			int llen = maxDepth(root.left);
			int rlen = maxDepth(root.right);
			len = llen > rlen ? llen+1 : rlen+1;
		}
		return len;
        
    }
}