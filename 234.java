/*
 * �������������
 * Ҫ��O(n)��ʱ�临�Ӷȣ�O(1)�Ŀռ临�Ӷ�
 * ���ҵ��м�Ԫ�أ����������ת����ǰ���������αȽϣ�����Ϊ����ʱ����ĩԪ�ز��ñȽϣ�
 * �����ÿ���ָ����㷨��Ѱ���м�Ԫ��
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