/删除链表的倒数第n个节点 
//暴力解法
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
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

    //暴力解法  先获取链表的长度 倒数第N个节点就是链表的长度减去N 个节点 
    int count = 1 ;
    ListNode temp = head;
    while (temp.next != null ) {
      count ++;
      temp = temp.next;
    }
    temp = head;
    if (n == count ) {
     return head.next;
    }else{
    for (int i = 1 ; i < count - n; i++ ) {
    temp = temp.next;
    }
    temp.next = temp.next.next;
    }
     return head;
    }
}

//递归的方法
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
class Solution {
    int cnt = 0;
    public ListNode removeNthFromEnd(ListNode head, int n) {
         if(head == null){
            return  null;
        }
        //递归
        head.next = removeNthFromEnd(head.next,n);
        //返回回来再加
        cnt ++;
        if (cnt == n){
            return  head.next;
        }
        return head;
    }
}

//快慢指针
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
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
    //使用快慢指针的思想来找到要删除的节点的位置,,快指针先走n步 然后慢指针开始偶组 
    //当快指针走到了链表的尾部,慢指针所在的位置为要删除节点的前一个位置 
     ListNode quick = head;
     ListNode slow = head ;
     //让快指针先走n步
     while (n > 0) {
      quick= quick.next;
      n--;
     }
    if(quick==null)//特判：如果删除的是头节点，则n为链表长度，此时cur为空
    {
            return head.next;
    }
    while (quick.next != null) {
        quick = quick.next;
        slow =slow.next;
    }
    slow.next = slow.next.next;
    return head;
    }

}
