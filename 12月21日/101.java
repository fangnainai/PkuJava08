import java.util.ArrayList;


public class SymmetricTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
//	/**
//	 *  二叉树对称的问题其实就是中序遍历是否对称的问题
//	 *  所以可以可以将二叉树中序遍历的顺序放进list中
//	 *  然后对比list是否为对称的
//	 * @param root
//	 * @return
//	 */
//	public boolean isSymmetric(TreeNode root) {
//     
//        if(root == null) return true;
//        
//        ArrayList<Integer> ret = new ArrayList<Integer>();
//        list(root, ret);
//        for(int i=0, j=ret.size()-1; i<j; i++, j--){
//            if(ret.get(i) != ret.get(j))
//                return false;
//        }
//        return true;
//    }
//    
//    public void list(TreeNode root, ArrayList<Integer> ret){
//        if(root == null) return;
//        if(root.left!=null) {
//        	list(root.left, ret);
//        }else{
//        	ret.add(null);
//        }
//        ret.add(root.val);
//        if(root.right!=null){
//        	list(root.right, ret);
//        }else{
//        	ret.add(null);
//        }
//           
//    }
	public boolean isSymmetric(TreeNode root) {  
        // Start typing your Java solution below  
        // DO NOT write main() function  
        if(root==null) {  
            return true;  
        }  
          
        return isSysRec(root.left, root.right);  
    }  
      
    private boolean isSysRec(TreeNode left, TreeNode right){  
        if(left==null && right==null) {  
            return true;  
        } else if( left==null || right==null) {  
            return false;  
        }  
          
        return (left.val==right.val) && isSysRec(left.left, right.right) && isSysRec(left.right, right.left);  
    }  

}
