	// �ݹ��ж����������Ƿ�Ϊƽ������������ж϶��ߵ���Ȳ��Ƿ񲻳���1
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