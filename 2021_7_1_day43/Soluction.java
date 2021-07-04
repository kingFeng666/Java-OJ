剑指 Offer 32 - II. 从上到下打印二叉树 II

从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。

 

例如:
给定二叉树: [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7

返回其层次遍历结果：

[
  [3],
  [9,20],
  [15,7]
]
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
     //二叉树的层序遍历,一般借助队列来完成
     Queue<TreeNode>  queue = new  LinkedList();
     List<List<Integer>>  list = new ArrayList();
     
     if(root != null) queue.add(root);

     while(!queue.isEmpty()) {
      List<Integer> list1 = new ArrayList();
      for(int i = queue.size(); i > 0 ; i --) {
      TreeNode node = queue.poll();
      list1.add(node.val);
      //把下一层元素加入到栈中
      if(node.left != null ) queue.add(node.left);
      if(node.right != null)  queue.add(node.right);
      }
      list.add(list1);
     }
     return list;
    }
}