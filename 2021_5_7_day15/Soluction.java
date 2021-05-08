import java.util.Arrays;
class Solution {
 public List<List<Integer>> threeSum(int[] nums) {
     //暴力解法,,使用3层for循环来解决问题,会超出时间限制
    if (nums == null || nums.length < 3)
        return new ArrayList<>();
    //因为结果中存在重复的元素,,所以使用set来去除重复
    Set<List<Integer>> res = new HashSet<>();
    //排序
    Arrays.sort(nums); // O(nlogn)
    // O(n^3)
    for (int i = 0; i < nums.length; i++) {
        for (int j = i + 1; j < nums.length; j++) {
            for (int k = j + 1; k < nums.length; k++) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                }
            }
        }
    } 
    return new ArrayList(res);
    }
}