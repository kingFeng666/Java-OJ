class Solution {
    public int[] exchange(int[] nums) {
    //双指针,一个指向数组的头部,一个指向数组的尾部,当前面的指针指向的是偶数后面的指针指向的是奇数,交换位置
    int pre = 0, cur = nums.length - 1;
    while(pre < cur) {
        while(pre < cur && nums[pre] % 2 == 1) pre++;
        while(pre < cur && nums[cur] % 2 == 0) cur--;
        int temp = nums[cur];
        nums[cur] = nums[pre];
        nums[pre] = temp;
    }
    return nums;
    }
}
//方法二
class Solution {
    public int[] exchange(int[] nums) {
    //声明一个空数组,,从前往后遍历,,如果当前元素是偶数,从后向前,,如果是奇数从前向后
    int len = nums.length;
    int pre = 0;
    int cur = len - 1;
    int[] array = new int[len];
    for(int i = 0 ; i < len ; i++) {
        if (nums[i] % 2 == 0) {
        array[cur] = nums[i];
        cur--;
        }else{
            array[pre] = nums[i];
            pre++;
        }
    }
    return array;
    }
}

/**
输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。

 

示例：

输入：nums = [1,2,3,4]
输出：[1,3,2,4] 
注：[3,1,2,4] 也是正确的答案之一。

 

提示：

    0 <= nums.length <= 50000
    1 <= nums[i] <= 10000

*/