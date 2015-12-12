import java.util.Stack;


public class InvertTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * 通过观察可以看出，每个节点的左右子节点都进行了互换
	 * 所以我们可以利用栈，分别对每个节点进行左右子树的互换
	 * @param root
	 * @return
	 */
	 public TreeNode invertTree(TreeNode root) {
	       if(root == null) return null;  
	        Stack<TreeNode> s = new Stack<TreeNode>();  
	        s.push(root);  
	        while(!s.isEmpty()){  
	            TreeNode cur = s.pop();  
	            TreeNode temp = cur.left;  
	            cur.left = cur.right;  
	            cur.right = temp;  
	            if(cur.left != null) s.push(cur.left);  
	            if(cur.right != null) s.push(cur.right);  
	        }  
	        return root;   
	    }
}
