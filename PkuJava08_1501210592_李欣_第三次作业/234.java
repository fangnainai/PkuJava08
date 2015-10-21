/*
 * 单向链表求回文
 * 要求O(n)的时间复杂度；O(1)的空间复杂度
 * 先找到中间元素，将其后链表反转，与前半链表依次比较（长度为奇数时，最末元素不用比较）
 * 可以用快慢指针的算法来寻找中间元素
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
		ListNode middle = findMiddle(head);
		ListNode end = reverseList(middle);
		while(end != middle){
			if(head.val != end.val) return false;
			head = head.next;
			end = end.next;
		}
		return true;
	}
	
	public ListNode reverseList(ListNode node){
		ListNode head = node;
		while(node.next != null){
			ListNode next = node.next;
			node.next = next.next;
			next.next = head;
			head = next;
		}
//		System.out.println(head.val);
		return head;
	}

	public ListNode findMiddle(ListNode head){
		ListNode slow = head;
		ListNode fast = head;
		while(fast.next != null && fast.next.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
//		System.out.println(slow.val);
		return slow;
	}
}