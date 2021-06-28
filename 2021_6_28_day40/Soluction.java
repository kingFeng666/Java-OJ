剑指 Offer 20. 表示数值的字符串

请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。

数值（按顺序）可以分成以下几个部分：

    若干空格
    一个 小数 或者 整数
    （可选）一个 'e' 或 'E' ，后面跟着一个 整数
    若干空格

小数（按顺序）可以分成以下几个部分：

    （可选）一个符号字符（'+' 或 '-'）
    下述格式之一：
        至少一位数字，后面跟着一个点 '.'
        至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字
        一个点 '.' ，后面跟着至少一位数字

整数（按顺序）可以分成以下几个部分：

    （可选）一个符号字符（'+' 或 '-'）
    至少一位数字

部分数值列举如下：

    ["+100", "5e2", "-123", "3.1416", "-1E-16", "0123"]

部分非数值列举如下：

    ["12e", "1a3.14", "1.2.3", "+-5", "12e+5.4"]


class Solution {
    public boolean isNumber(String s) {
    //根据题目,抽象出条件满足是数值的字符串的条件
    //+ - 0-9.(.只能出现一次)0-9 +-eE(eE只能出现一次),顺序可以不一样
    if(s.length() == 0 || s == " ") return false;
   // 使用boolean的标记位,标记是否遇到数位、小数点、‘e’或'E',后面根据boolean值判断是否再次出现
    boolean isNum = false, isDot = false, ise_or_E = false; 
    //去除字符串前后的空格
    char[] str = s.trim().toCharArray();
   for(int i = 0 ; i < str.length; i++) {
   //判断是不是0 - 9 的数字
   if(str[i] >= '0' && str[i] <= '9') {
    isNum = true;
   //判断是不是小数点,小数点后只能出现0 - 9和Ee ,且Ee和.只能出现一次
   }else if(str[i] == '.'){
    if(isDot || ise_or_E) return false;
    isDot = true;
    //判断是否遇到了E e,并且e E 的前面必须有整数,且E e 只能出现一次 
   }else if(str[i] == 'E' || str[i] == 'e'){
   if(!isNum || ise_or_E) return false;
   ise_or_E = true;
   isNum = false;
   //出现+ - 号的情况 ,且+ - 号只能出现在开头,或者E e 的后面
   }else if (str[i] == '+' || str[i] == '-') {
   if(i != 0 && str[i -1] !='E' && str[i-1] != 'e' )return false;
   }else {
    return false;
   } 
}
     return isNum;
    }
}

