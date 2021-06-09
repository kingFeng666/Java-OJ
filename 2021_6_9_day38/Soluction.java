给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…

你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

示例 1:

给定链表 1->2->3->4, 重新排列为 1->4->2->3.

示例 2:

给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reorder-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


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
    public void reorderList(ListNode head) {
        if(head == null) return ;
    //根据题目描述,是将链表后半段的节点插入到前半段的缝隙中,但是链表无法根据下标定所以可以使用线性的结构存储,然后进行插入操作
    List<ListNode> list = new ArrayList<ListNode>();
    ListNode temp = head;
    while(temp != null) {
    list.add(temp);
    temp = temp.next;
    }

    int i = 0, j = list.size() - 1;
        while(i < j) {
        list.get(i).next = list.get(j);
        i++;
        if(i == j) {
         break;
        }
        list.get(j).next = list.get(i);
        j--;
        }
      list.get(i).next = null;
    }
}