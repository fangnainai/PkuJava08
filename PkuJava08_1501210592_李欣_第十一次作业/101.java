/*
 * 判断一棵树是否对称
 * 使用两个栈，对左右两棵子树进行遍历，左边先左后右遍历，右边先右后左遍历
 */
public boolean isSymmetric(TreeNode root) {
		if(root == null) return true;
		Stack<TreeNode> leftStack = new Stack<TreeNode>();
		Stack<TreeNode> rightStack = new Stack<TreeNode>();
		leftStack.push(root.left);
		rightStack.push(root.right);
		while(!leftStack.isEmpty() && !rightStack.isEmpty()){
			TreeNode leftNode = leftStack.pop();
			TreeNode rightNode = rightStack.pop();
			if(leftNode == null && rightNode == null){
				continue;
			}else if(leftNode == null || rightNode == null){
				return false;
			}else if(leftNode.val == rightNode.val){
				leftStack.push(leftNode.left);
				leftStack.push(leftNode.right);
				rightStack.push(rightNode.right);
				rightStack.push(rightNode.left);
			}else{
				return false;
			}
		}
		return true;
/*		// 层次遍历法，有问题，某些层无法判断是否对称
  		if(root == null) return true;
		ArrayList<TreeNode> treeList = new ArrayList<TreeNode>();		
		treeList.add(root);
		int start = 0;
		int end = 1;
		while(start != end){
			start = end;
			end = treeList.size();   //用start和end记录当前层节点的位置
			// 比较当前层的结点是否对称
			if((end-start)%2 != 0) return false;
			for(int i = start, j = end - 1; i<j; i++, j--){				
				if(treeList.get(i).val != treeList.get(j).val){
					return false;
				}			
			}
			// 将下一层的结点加入到列表中
			for(int i = start; i<end; i++){
				if(treeList.get(i).left != null) treeList.add(treeList.get(i).left);
				if(treeList.get(i).right != null) treeList.add(treeList.get(i).right);
			}
		}
		return true;
*/		
	}