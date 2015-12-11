	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		// p q比root大，则一定在右子树
		if(p.val > root.val && q.val > root.val)
			return lowestCommonAncestor(root.right, p, q);
		// p q比root小，则一定在左子树
		else if(p.val < root.val && q.val < root.val)
			return lowestCommonAncestor(root.left, p, q);
		// 一大一小，则就是root
		else return root;
		
	}