14. 最长公共前缀

编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。

示例 1：

输入：strs = ["flower","flow","flight"]
输出："fl"

示例 2：

输入：strs = ["dog","racecar","car"]
输出：""
解释：输入不存在公共前缀。

 

提示：

    0 <= strs.length <= 200
    0 <= strs[i].length <= 200
    strs[i] 仅由小写英文字母组成

class Solution {
    public String longestCommonPrefix(String[] strs) {
    //字符串数组的最长公共前缀 纵向扫描
    if(strs.length == 0 || strs == null ) return " ";
    int length = strs[0].length();
    int count = strs.length;
    for(int i = 0; i < length ; i++ ) {
    char c = strs[0].charAt(i);
    for(int j = 1; j < count ; j++) {
    //最长公共前缀的长度一定小于等于字符串数组中长度最短的那个字符串的长度 
    if(i == strs[j].length() || strs[j].charAt(i) != c){
        return strs[0].substring(0,i);
    }
    }
    }
    return strs[0];
    
    }
}

/**纵向扫描
时间复杂度：O(mn)，其中 m 是字符串数组中的字符串的平均长度，n 是字符串的数量。最坏情况下，字符串数组中的每个字符串的每个字符都会被扫描一次.
空间复杂度O(1)
*/