
public class DeleteNode {
  
   /**
    * 因为没有给出前结点，所以我们可以采用先将要删除结点后面的结点的值覆盖要删除的结点
    * 然后将后面的结点给删除
    * @param node
    */
    public void deleteNode(ListNode node) {
         
        node.val = node.next.val;
        node.next = node.next.next;

        
    }
}
