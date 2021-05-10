class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
    //暴力解法,,遍历挣个二维数组,,逐一与目标值进行比较
    if(matrix.length == 0 || matrix == null || matrix[0].length == 0 ) return false;
    for(int i  = 0 ; i < matrix.length ; i++) {
        for (int j = 0 ; j < matrix[0].length ; j++) {
       if(matrix[i][j] == target) {
           return true;
       }
    }
 }
       return false;  
}
}