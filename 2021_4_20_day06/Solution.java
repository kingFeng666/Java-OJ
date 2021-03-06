//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
class Solution {
    public int lengthOfLongestSubstring(String s) {
    //使用滑动窗口的思路来
    if(s.length() == 0 ) return 0 ; 
    int start = 0 , max = 0;
   Map<Character, Integer> map = new HashMap<>();

   for (int i = 0; i < s.length() ;i++) {
    if(map.containsKey(s.charAt(i))) {
        //将开始位置移动到出现之后的位置  
        start = Math.max(start,map.get(s.charAt(i)) + 1);   
    }
    map.put(s.charAt(i),i);
    //max的值在一直更新
    max = Math.max(max,i-start+1);
   }
   return max;
}
}