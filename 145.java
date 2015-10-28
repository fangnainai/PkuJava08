import java.util.ArrayList;
import java.util.Stack;


public class BinaryTreePostorderTraversal {
	/**
	 *参考网上的非递归方法：那么一个结点需要两种情况下才能够输出：第一，它已经是叶子结点；第二，它不是叶子结点，但是它的子结点已经输出过。
	 *那么基于此我们只需要记录一下当前输出的结点即可。对于一个新的结点，如果它不是叶子结点，左右子树也没有访问，那么就需要将它的右子树，
	 *左子树压入。如果它满足输出条件，则输出它，并记录下当前输出结点。输出在stack为空时结束。 
	 * 每次记录一个pre和cur，cur表示当前节点，pre表示上次输出的节点(是上次输出的节点，不是上次访问的节点)，
	 * 如果pre正好是cur的左子树或者右子树，那么就可以输出cur，否则，说明还有cur的左子树或者右子树等待输出，
	 * 也就是还没到cur输出的时候。这是第一个可以让cur输出的条件。另外可以可以让cur输出的条件是，cur是叶子节。
	 * @param root
	 * @return
	 */
	public ArrayList<Integer> postorderTraversal(TreeNode root) {
		ArrayList<Integer> lst = new ArrayList<Integer>();
        if(root == null)
            return lst; 
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        TreeNode pre = null;
        while(!stack.empty()){
            TreeNode cur = stack.peek();
            if(pre == null || pre.left == cur || pre.right == cur){
                if(cur.left != null){
                    stack.push(cur.left);
                }else if(cur.right != null){
                    stack.push(cur.right);
                }else{
                    stack.pop();
                    lst.add(cur.val);
                }
  
            }else if(cur.left == pre){
                if(cur.right != null){
                    stack.push(cur.right);
                }else{
                    stack.pop();
                    lst.add(cur.val);
                }
 
            }else if(cur.right == pre){
                stack.pop();
                lst.add(cur.val);
            }
 
            pre = cur;
        }
 
        return lst;
    }
	}

