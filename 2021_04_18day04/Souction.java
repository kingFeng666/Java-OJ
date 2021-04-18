import java.util.*;
/**
*/ 输入一个链表，输出该链表中倒数第k个结点。
如果该链表长度小于k，请返回空。 
/*
 * public class ListNode {
 *   int val;
 *   ListNode next = null;
 *   public ListNode(int val) {
 *     this.val = val;
 *   }
 * }
 */ 
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * @param pHead ListNode类 
     * @param k int整型 
     * @return ListNode类
     */
    public ListNode FindKthToTail (ListNode pHead, int k) {
        // write code here
         if(pHead == null || k == 0) {return null;}
        ListNode p1 = pHead;
        ListNode p2 = pHead;
        //定义一个变量count用用来纪录当前节点的下标  同时也防止了k超出了链表的size()
        int count = 1;
        while(p1.next != null) {
            p1 = p1.next;
            count++;
            //count > k 就说明了前面p1 已经走过了k次, 所以 p2 开始从头走,
            //p1继续向后移动,一直到p1.next= null结束
            if(count > k) {
                p2 = p2.next;
            }
        }
        //判断k是否越界 如果越界就返回null
        if(k > count){return null;}
        return p2;
    }
}