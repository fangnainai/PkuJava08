/*
 * �ж�һ�����Ƿ�Գ�
 * ʹ������ջ�������������������б��������������ұ������ұ����Һ������
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
/*		// ��α������������⣬ĳЩ���޷��ж��Ƿ�Գ�
  		if(root == null) return true;
		ArrayList<TreeNode> treeList = new ArrayList<TreeNode>();		
		treeList.add(root);
		int start = 0;
		int end = 1;
		while(start != end){
			start = end;
			end = treeList.size();   //��start��end��¼��ǰ��ڵ��λ��
			// �Ƚϵ�ǰ��Ľ���Ƿ�Գ�
			if((end-start)%2 != 0) return false;
			for(int i = start, j = end - 1; i<j; i++, j--){				
				if(treeList.get(i).val != treeList.get(j).val){
					return false;
				}			
			}
			// ����һ��Ľ����뵽�б���
			for(int i = start; i<end; i++){
				if(treeList.get(i).left != null) treeList.add(treeList.get(i).left);
				if(treeList.get(i).right != null) treeList.add(treeList.get(i).right);
			}
		}
		return true;
*/		
	}