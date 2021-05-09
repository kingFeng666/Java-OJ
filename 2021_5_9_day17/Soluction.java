class Solution {
    public int minArray(int[] numbers) {
    //原数组是递增排序的数字,,经过旋转后的数组有序,,所以可以使用二分来做
    int len = numbers.length;
    int left = 0 , right = len - 1;
    while(left < right) {
    int mid = left + (right - left)/2;
    if(numbers[mid] > numbers[right] ) {
    left = mid + 1;
    }else if(numbers[mid] < numbers[left]) {
    right = mid;
    }else{
        right = right - 1;
    }
    }
    return numbers[left];
    }
}