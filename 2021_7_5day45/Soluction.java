输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。

例如：

给定二叉树 [3,9,20,null,null,15,7]，

    3
   / \
  9  20
    /  \
   15   7

返回它的最大深度 3 。


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
    // 广度优先遍历,借助队列来完成,结束条件当队列为空结束
    Queue<TreeNode> queue = new LinkedList();
    int count = 0;
    if (root != null ) queue.add(root);
    while(!queue.isEmpty()) {
    int size = queue.size();
    while(size-- > 0) {
    TreeNode cur = queue.poll();
    if(cur.left != null ) {queue.add(cur.left);}
    if(cur.right != null ) {queue.add(cur.right);}
    } 
    count++;
    } 
    return count;
    }
}

//深度优先
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
    //二叉树的深度 深度优先遍历
    if( root == null ) return 0 ;
    return  Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;

    }
}
