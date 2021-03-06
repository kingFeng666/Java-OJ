/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 class Solution{
     public ListNode mergeTwoLists(ListNode l1,ListNode l2){
         ListNode dummyHead=new ListNode(0);
         //申请了一个临时变量来保存
         ListNode cur=dummyHead;
         while(l1!=null&&l2!=null){
             if(l1.val<l2.val){
                 cur.next=l1;
                 cur=cur.next;
                 l1=l1.next;
             }else{
                 cur.next=l2;
                 cur=cur.next;
                 l2=l2.next;
             }
         }
         if(l1==null){
             cur.next=l2;
         }else{
             cur.next=l1;
         }
         return dummyHead.next;
     }
 }
     


 