/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//前序遍历的第一个元素就是这棵树的根节点 ,然后将中序遍历的结果从根节点开始划分
        //左边的部分为左子树中序遍历的结果
        //右边的部分为右子树中序遍历的结果
public class Solution {
      int findIndex(int[] nums, int start, int end, int target) {
        for (int i = start; i <= end; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }
  
    TreeNode buildTree(int[] preorder, int prestart, int preend, int[] inorder, int instart, int inend) {
        if (prestart == preend) {
            return new TreeNode(preorder[prestart]);
        }
        if (prestart > preend) {
            return null;
        }
        //先序遍历的第一个节点为根
        TreeNode node = new TreeNode(preorder[prestart]);
        //中序遍历 根节点左边的为左子树，右边为右子树 endIndex-instart 为树的节点数量
        int endIndex = findIndex(inorder, instart, inend, preorder[prestart]);
  
        node.left = buildTree(preorder, prestart + 1,
                prestart + endIndex - instart, inorder, instart,
                endIndex - 1);
        node.right = buildTree(preorder, prestart + (endIndex-instart)+1,
                preend, inorder, endIndex + 1, inend);
        return node;
    }
  
    public TreeNode reConstructBinaryTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    
}