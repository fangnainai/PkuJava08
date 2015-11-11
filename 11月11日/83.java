
public class RemoveDuplicatesFromSortedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * 由于有序，所以p结点是否重复只需要和它的前一节点比较是否相等就可以了，
	 * @param head
	 * @return
	 */
	public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;
 
        ListNode prev = head;   //前一节点 
        ListNode p = head.next;  
 
        while(p != null){
            if(p.val == prev.val){  //若p节点的值相等和前一个节点的值相等，则删除当前p所指的节点
                prev.next = p.next;
                p = p.next;
                //no change prev
            }else{               //若不相等，则将俩指针向后移动一位
                prev = p;
                p = p.next; 
            }
        }
 
        return head;
    }
}
