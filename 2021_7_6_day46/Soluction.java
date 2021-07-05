给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。

初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。

 

示例 1：

输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
输出：[1,2,2,3,5,6]

示例 2：

输入：nums1 = [1], m = 1, nums2 = [], n = 0
输出：[1]

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
     //合并,排序 
     for(int i= 0 ; i< n; i++ ){
         nums1[m] = nums2[i];
         m++;
     }
      Arrays.sort(nums1);
    }
}
//双指针
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0, p2 = 0;
        int[] sorted = new int[m + n];
        int cur;
        while (p1 < m || p2 < n) {
            if (p1 == m) {
                cur = nums2[p2++];
            } else if (p2 == n) {
                cur = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                cur = nums1[p1++];
            } else {
                cur = nums2[p2++];
            }
            sorted[p1 + p2 - 1] = cur;
        }
        for (int i = 0; i != m + n; ++i) {
            nums1[i] = sorted[i];
        }
    }
}
//双指针的优化
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //双指针,不借助额外的空间,在原数组1上进行操作,从后面进行插入,他不会影响到前面值的覆盖
        int p1 = m - 1,p2 = n - 1, temp ;
        int totol = m + n - 1;
        while(p1 >= 0 || p2 >= 0) {
        if(p1 == -1){
            temp = nums2[p2--];
        }else if(p2 == -1){
            temp = nums1[p1--];
        }else if (nums1[p1] > nums2[p2]) {
            temp = nums1[p1--];
        }else{
            temp = nums2[p2--];
        }
        nums1[totol--] = temp;
        }
        
    }
}




