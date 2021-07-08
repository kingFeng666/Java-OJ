617. 合并二叉树

给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。

你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。

示例 1:

输入: 
	Tree 1                     Tree 2                  
          1                         2                             
         / \                       / \                            
        3   2                     1   3                        
       /                           \   \                      
      5                             4   7                  
输出: 
合并后的树:
	     3
	    / \
	   4   5
	  / \   \ 
	 5   4   7


**
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
//递归
class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
     //合并规则,相同位置如果都有节点就将节点的值进行相加,如果不是同时有值将此节点作为合并后的新树的值
     //递归来实现
     if(root1 == null) return root2;
     if(root2 == null ) return root1;
     root1.val += root2.val;
     root1.left =  mergeTrees(root1.left , root2.left);
     root1.right = mergeTrees(root1.right , root2.right );
     return root1;
    }
}