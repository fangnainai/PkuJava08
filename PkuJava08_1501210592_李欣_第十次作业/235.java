	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		// p q��root����һ����������
		if(p.val > root.val && q.val > root.val)
			return lowestCommonAncestor(root.right, p, q);
		// p q��rootС����һ����������
		else if(p.val < root.val && q.val < root.val)
			return lowestCommonAncestor(root.left, p, q);
		// һ��һС�������root
		else return root;
		
	}