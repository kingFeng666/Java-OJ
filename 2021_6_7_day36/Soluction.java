给定一个二叉树，检查它是否是镜像对称的。

例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

    1
   / \
  2   2
 / \ / \
3  4 4  3

 
但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

    1
   / \
  2   2
   \   \
   3    3

进阶：

你可以运用递归和迭代两种方法解决这个问题吗？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/symmetric-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

//递归
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
    //递归 
    return check(root , root);
    }
    //初始化两个指针指向root ,然后一个一个指针向左一个指针想要,然后比较两个是否相等
    public boolean check(TreeNode p , TreeNode q ) {
    if (p == null && q == null) {
     return true;
    } 
    if (p == null || q == null) {
     return false;
    }
    return p.val == q.val && check(p.left , q.right) && check(p.right , q.left) ;

    }
}





//迭代
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
         //迭代 
     return check(root , root );
    
    }
    public boolean check (TreeNode p , TreeNode q) {
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
     //将节点入队列
    queue.offer(p);
    queue.offer(q);
    //当队列为空,或者左右不相等的时候结束.
    while(!queue.isEmpty()){
        p = queue.poll();
        q = queue.poll();
        if(p == null && q == null){
        continue;
        }
        if (p == null || q == null || p.val != q.val) {
        return false;
        }

        queue.offer(p.left);
        queue.offer(q.right);
        queue.offer(p.right);
        queue.offer(q.left);
    }
    return true;
    }
}