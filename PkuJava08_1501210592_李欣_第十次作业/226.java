/*
 * �������
 */
public class InvertBinaryTree226 {
    public TreeNode invertTree(TreeNode root) {
    	if(root == null) return null;
    	// ������������
    	TreeNode temp = root.left;
    	root.left = root.right;
    	root.right = temp;
    	// �ݹ�
    	root.left = invertTree(root.left);
    	root.right = invertTree(root.right);
        return root;
    }
}