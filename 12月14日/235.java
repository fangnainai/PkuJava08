
public class LowestCommonAncestor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * 二叉排序树是左边节点的值都小于根节点，右边节点的值都大于根节点
	 * 有三种情况，第一种是输入的两个节点都小于根节点，则这两个节点肯定
	 * 都在根节点的左边，所以递归将根节点的左子树作为新的根节点进行判断，
	 * 第二种是输入的两个节点都大于根节点，则这两个节点肯定都在根节点的右边
	 * 第三种就是两节点都在不同的一边，则root一定为祖先节点
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
	 public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	        TreeNode m = root;
	 
	    if(m.val > p.val && m.val < q.val){
	        return m;  
	    }else if(m.val>p.val && m.val > q.val){
	        return lowestCommonAncestor(root.left, p, q);
	    }else if(m.val<p.val && m.val < q.val){
	        return lowestCommonAncestor(root.right, p, q);
	    }
	 
	    return root;
	        
	    }

}
