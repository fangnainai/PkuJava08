import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
	
	 /**
     * 非递归
     * 用迭代的方法实现二叉树的遍历，需要借助一些数据结构，比如list，stack等。
     * 首先在stack中push入当前的root，由于是前序遍历，故root的value是先于左子树和右子树访问的，
     * 故pop取出一个结点，将它的value加入访问序列。之后压入它的右子树和左子树。直到stack为空。
     * @param root
     * @return
     */
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> List = new ArrayList<Integer>();
        if(root == null)
             return List;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.empty()){
           TreeNode n = stack.pop();
           List.add(n.val);
           if(n.right != null){
               stack.push(n.right);
             }
           if(n.left != null){
              stack.push(n.left);
             }
 
         }
         return List;
     }
    //递归方法
    //  vector<int> preorderTraversal(TreeNode *root) {  
    //     vector<int> re;  
    //     preorder(root, path);  
    //     return re;  
    // }
    //  void preorder(TreeNode *root,vector<int> &re)
    // {
    //     if(root == NULL)
    //         return;
    //     re.push_back(root->val);
    //     preorder(root->left,re);
    //     preorder(root->right,re);
    // } 
     
}
