给定一个链表，判断链表中是否有环。

如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。

如果链表中存在环，则返回 true 。 否则，返回 false 。

 

进阶：

你能用 O(1)（即，常量）内存解决此问题吗？

 

示例 1：

输入：head = [3,2,0,-4], pos = 1
输出：true
解释：链表中有一个环，其尾部连接到第二个节点。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/linked-list-cycle
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class Solution {
    public boolean hasCycle(ListNode head) {
        //使用hash表存储每个节点，遍历链表，如果hash表中不存在当前节点，加入到链表中，存在说明有环存在
        HashSet<ListNode> set = new HashSet();
        ListNode temp = head;
        while( temp != null) {
            //set.add()方法，返回值是boolean类型，如果集合中包含此元素返回false，不包含返回true；
            if(!set.add(temp)){
             return true;
            }
            temp = temp.next;
        }
        return false;
    }
}



public class Solution {
    public boolean hasCycle(ListNode head) {
        //特判
        if (head == null || head.next == null) return false;
        //O(1)解决问题，可以使用双指针，快慢指针，如果存在环快慢指针会在某时刻相遇 
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
        //如果快指针到达了链表的尾部，说明没有环
       if (fast == null || fast.next == null) {
                return false;
            }


        //为了让慢指针追上快指针，则需要使快指针每次走两步，慢指针每一走一步
        slow = slow.next;
        fast = fast.next.next;
        }
        return true;
    }
}