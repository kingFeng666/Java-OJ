给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。

请你将两个数相加，并以相同形式返回一个表示和的链表。

你可以假设除了数字 0 之外，这两个数都不会以 0 开头。

 

示例 1：

输入：l1 = [2,4,3], l2 = [5,6,4]
输出：[7,0,8]
解释：342 + 465 = 807.

示例 2：

输入：l1 = [0], l2 = [0]
输出：[0]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/add-two-numbers
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    //初始化一个哑结点
    ListNode  temp = new ListNode(0);
    ListNode cur = temp;
    //两数相加后的进位
    int carry = 0;
    while(l1 != null || l2 != null) {
    //计算两个数的和,如果一个链表到达了尾部，就将这节点后面的节点初始化为0 
    int l1Val = l1 == null ? 0 : l1.val;
    int l2Val = l2 == null ? 0 : l2.val;
    //计算两数的和并且产生进位
    int sumNumber = l1Val +l2Val + carry;
    //和
    int  resNUmber = sumNumber % 10 ;
    //进位
    carry = sumNumber / 10;
    cur.next = new ListNode(resNUmber);
    cur = cur.next;
     if(l1 != null)
         l1 = l1.next;
    if(l2 != null)
        l2 = l2.next;
    }
   //如果最后的进位不等于0还要加上以为
   if(carry == 1) {
    cur.next = new ListNode(carry);
    }
    return temp.next;
    }
}