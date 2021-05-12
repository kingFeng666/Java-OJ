/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
     ListNode newNode = new ListNode();
     ListNode temp = newNode;
     while(l1 != null && l2 != null){
       if(l1.val <l2 .val) {
           temp.next = l1;
           temp = temp.next;
           l1 = l1.next;
       }else{
           temp.next = l2;
           temp = temp.next;
           l2 = l2.next;
       }
     }
       if(l1 == null) {
       temp.next = l2;
       }
       if(l2 == null) {
       temp.next = l1;
       }
       return newNode.next;     
    }
}
/**
输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
示例1：
输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
限制：
0 <= 链表长度 <= 1000
*/
