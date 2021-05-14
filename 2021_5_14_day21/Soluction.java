/**在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。

示例:

s = "abaccdeff"
返回 "b"

s = "" 
返回 " "*/
import java.util.*;
class Solution {
    public char firstUniqChar(String s) {
    //使用LinkedHashMap来保证顺序存储 
    char cs = ' ';
    HashMap<Character, Integer> map = new LinkedHashMap();
    for(int i = 0 ; i < s.length() ; i++){
    char c = s.charAt(i);
    if(map.containsKey(c)) {
    map.put(c , map.get(c) + 1);
    }else{
        map.put(c , 1);
    }
    }
    for(char key : map.keySet()) {
    if(map.get(key) == 1 )  {
     return key;
    }
   
    }
     return cs;
    }
}
//方法二
class Solution {
    public char firstUniqChar(String s) {
        if(s == null || s.length() == 0) return ' ';
        HashMap<Character, Integer> map = new HashMap<>(); 
        //将字符串中的单个字符保存在map中,字符作为key 出现的次数作为出现的次数
        for(int i = 0;i < s.length();i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                map.put(c, map.get(c) + 1);
            }
            else
                map.put(c, 1);
        }
        //遍历字符串 通过key 取出value 如果value = 1 就是第一次出现的字符
        for(int i = 0;i < s.length();i++){
            if(map.get(s.charAt(i)) == 1){
                return s.charAt(i);
            }
        }
        return ' ';
    }
}

