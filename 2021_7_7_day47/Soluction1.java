662. 二叉树最大宽度

给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。这个二叉树与满二叉树（full binary tree）结构相同，但一些节点为空。

每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。

示例 1:

输入: 

           1
         /   \
        3     2
       / \     \  
      5   3     9 

输出: 4
解释: 最大值出现在树的第 3 层，宽度为 4 (5,3,null,9)。

示例 2:

输入: 

          1
         /  
        3    
       / \       
      5   3     

输出: 2
解释: 最大值出现在树的第 3 层，宽度为 2 (5,3)。

示例 3:

输入: 

          1
         / \
        3   2 
       /        
      5      

输出: 2
解释: 最大值出现在树的第 2 层，宽度为 2 (3,2)。

示例 4:

输入: 

          1
         / \
        3   2
       /     \  
      5       9 
     /         \
    6           7
输出: 8
解释: 最大值出现在树的第 4 层，宽度为 8 (6,null,null,null,null,null,null,7)。
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
    public int widthOfBinaryTree(TreeNode root) {
    //二叉树的最大宽度,修改二叉树节点的值,然后每一层的最大宽度就是最左边子树的序号减去最右边子树的序号
    //每一层每一层的进行处理,所以需要借助二叉树的层序遍历来完成
    if (root == null ) return 0 ;
    //对树的每一个节点进行编号,首先根节点编号为0
    root.val = 0;
    Deque<TreeNode> queue = new LinkedList();
    queue.add(root);
    //sum表示队列的大小
    int sum = 0;
    //ans 最大宽度
    int  ans = 0;
    while(!queue.isEmpty()) {
    sum = queue.size();
    //根据队头和队尾的vald的差来更新最大宽度
    ans = Math.max(ans , queue.getLast().val - queue.getFirst().val + 1);
    while(sum-- >0 ){
    TreeNode temp = queue.remove();
    if(temp.left != null){
        queue.add(temp.left);
        temp.left.val = temp.val*2 + 1;
    }
    if(temp.right != null ){
        queue.add( temp.right);
        temp.right.val = temp.val*2 + 2;
    }
    }
 }
   return ans;
}
}