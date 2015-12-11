/*
 * 先序遍历
 */
public class InvertBinaryTree226 {
    public TreeNode invertTree(TreeNode root) {
    	if(root == null) return null;
    	// 交换左右子树
    	TreeNode temp = root.left;
    	root.left = root.right;
    	root.right = temp;
    	// 递归
    	root.left = invertTree(root.left);
    	root.right = invertTree(root.right);
        return root;
    }
}