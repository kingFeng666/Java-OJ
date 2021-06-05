给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

 

示例 1：

输入：head = [1,2,3,4]
输出：[2,1,4,3]

示例 2：

输入：head = []
输出：[]

示例 3：

输入：head = [1]
输出：[1]

 

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


//递归
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
    		//若head==null说明head为空，head.next==null说明只剩下一个元素
    		return head;
    		
    	}
    	ListNode nextOne = head.next;//nextOne指向head后面的一个节点
    	//修改head的指向
    	head.next = swapPairs(nextOne.next);

    	//修改nextOne的指向
    	nextOne.next = head;
    	return nextOne;

    }
}

//迭代
class Solution {
    public ListNode swapPairs(ListNode head) {
    if(head == null) return null;
    if (head.next == null) return head; 
    //迭代 ，创建哑结点
    ListNode temp = new ListNode(0);
    ListNode cur = temp;
    cur.next = head;
    //之后剩下一个节点或者一个节点也没有结束
    while(cur.next != null && cur.next.next != null  ){
    ListNode node1 = cur.next;
    ListNode node2 = cur.next.next;
    //交换两个节点
    cur.next = node2;
    node1.next = node2.next;
    node2.next = node1;
    cur = node1;
    }