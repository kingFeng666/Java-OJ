class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
    //题目中的二维数组中的每一行都是从左到右递增的,从上到下递增的
    //可以从二维数组的右上角开始进行线性查找如果目标值比当前元素大,就下移动,,如果目标值比当前元素小就向前移动
     if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
         return false;
         }
    //找出二维数组右上角的元素
    //一直找到二维数组的边界为止,如果没有找到就返回false
      int rows = matrix.length, columns = matrix[0].length;
      int row = 0, column = columns -1;
      while(row < rows && column >= 0) {
        int temp = matrix[row][column];
        if(temp == target) {
         return true;
        }else if(temp > target){
         column--;
        }else{
            row++;
        }
      }
      return false;
    }
}