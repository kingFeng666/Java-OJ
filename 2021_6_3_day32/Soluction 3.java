给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。

你应当 保留 两个分区中每个节点的初始相对位置。

 

示例 1：

输入：head = [1,4,3,2,5,2], x = 3
输出：[1,2,2,4,3,5]

示例 2：

输入：head = [2,1], x = 2
输出：[1,2]

 

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/partition-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


class Solution {
    public ListNode partition(ListNode head, int x) {
        //维护两个链表，遍历一遍链表 ，分别存储大于x和小于x 的节点,遍历结束将两个链表连接
    
        ListNode small = new ListNode(0);
        //返回链表使用
        ListNode smallHead = small;
        ListNode large = new ListNode(0);
        //合并的时候使用
        ListNode largeHead = large;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        large.next = null;
        small.next = largeHead.next;
        return smallHead.next;
    }
}