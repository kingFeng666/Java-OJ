/**
 *给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。你不能只是单纯的改变节点内部的值，而是 *需要实际的进行节点交换。
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ////递归的出口就是当前节点为null或者当前节点的下一个节点为null
        if(head == null || head.next == null) {
    		//若head==null说明head为空，head.next==null说明只剩下一个元素
    		return head;
    	}
        //保存下一个节点
    	ListNode nextOne = head.next;//nextOne指向head后面的一个节点
    	//修改head的指向
    	head.next = swapPairs(nextOne.next);
    	//修改nextOne的指向
    	nextOne.next = head;
    	return nextOne;
    }
}
