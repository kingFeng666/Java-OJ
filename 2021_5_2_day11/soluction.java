public class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        //rightmost 是最大的跳跃距离,,我们动态的维护这个最大跳跃距离
        ////如果rightmost >> 数组的长度就一定可以到结尾
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}