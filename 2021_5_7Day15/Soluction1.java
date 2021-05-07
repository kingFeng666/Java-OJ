import java.util.Arrays;
class Solution {
 public List<List<Integer>> threeSum(int[] nums) {
     //思路:先对数组进行排序 , 先确定其中的一个元素,然后把问题转换为两数之和,,使用双指针
    if (nums == null || nums.length < 3)
        return new ArrayList<>();
    //因为结果中存在重复的元素,,所以使用set来去除重复
    Set<List<Integer>> res = new HashSet<>();
    //排序
    Arrays.sort(nums); // O(nlogn)
    //转换为另外两个数的和等于我们已经确定的数的相反数
    //O(n平方)
    for(int i = 0 ; i <nums.length; i++ ) {
    //从i+1 到nums.length-1找两个数的和等于numsn[i]]的相反数 
    int target = -nums[i];
    int left = i + 1;
    int right = nums.length-1;
    while(left < right) {
    int sum = nums[left] + nums[right];
    if(sum == target) {
        res.add(Arrays.asList(nums[i] , nums[left] , nums[right]));
        //移动
        left++;
        right--;
    }else if (sum < target) {
    left++;
    }else{
        right--;
    }
 }
}
    return new ArrayList(res);
    }
}