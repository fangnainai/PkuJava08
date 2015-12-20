	// 递归判断两棵子树是否为平衡二叉树，并判断二者的深度差是否不超过1
	public boolean isBalanced(TreeNode root) {
		if(root == null) return true;
		if(Math.abs(getDepth(root.left) - getDepth(root.right)) > 1 ){
			return false;
		}else return isBalanced(root.left) && isBalanced(root.right);
		/*if(isBalanced(root.left) && isBalanced(root.right)){
			if(Math.abs(getDepth(root.left) - getDepth(root.right)) <=1 ){
				return true;
			}
		}*/
	}
	public int getDepth(TreeNode root){
		if(root == null) return 0;
		return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
	}