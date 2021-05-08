class Solution {
    public int findRepeatNumber(int[] nums) {
    //遍历数组,可以借助set集合来确定数组中的某个元素是否发生重复
    Set set = new HashSet();
    for(int num : nums) {
     if( set.contains(num)) {
         return num;
     }else{
         set.add(num);
     }
    }
    return -1;
    }
}