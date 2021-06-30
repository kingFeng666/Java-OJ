125. 验证回文串

给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

说明：本题中，我们将空字符串定义为有效的回文串。

示例 1:

输入: "A man, a plan, a canal: Panama"
输出: true

示例 2:

输入: "race a car"
输出: false

class Solution {
    public boolean isPalindrome(String s) {
    //先对字符串进行处理,去掉不是字母或数字的部分 ,然后再采用双指针的方法判断是不是回文串
    StringBuffer stringBuffer = new StringBuffer();
    //如果不是字母或者数字,添加到StringBuffer中
    for(int i = 0 ; i < s.length() ; i++ ){
        if(Character.isLetterOrDigit(s.charAt(i))){
            char ch = Character.toLowerCase(s.charAt(i)); 
            stringBuffer.append(ch);
        }
    }
    //双指针判断是否为回文串
    int left = 0 ; 
    int rigth = stringBuffer.length() - 1;
    while(left < rigth){
        //如果左边的字符不等于右边的字符,return false;
        if(stringBuffer.charAt(left) != stringBuffer.charAt(rigth)){
        return false;
        }
        left++;
        rigth--;
    }
    return true;
    }
}

class Solution {
    public boolean isPalindrome(String s) {
    //双指针判断一个指针指向字符串的左端,一个指针指向字符串的右端
    //然后判断两个指针指向的内容是否相同 
    String str = s.toLowerCase();
    int left = 0 ;
    int right = str.length() - 1;

    while(left < right){
    //题目只考虑数字,或者字母,忽略大小写和符号,如果字符串开始不是数字或者字母左指针向右移动,同理右指针向左移动
    //isLetterOrDigit(char ch) Character的方法,判断字符是不是一个数组或者字母
    while(left < right && !Character.isLetterOrDigit(str.charAt(left))){
        left++;
    }
    while(left < right && !Character.isLetterOrDigit(str.charAt(right))){
        right--;
    }
    //如果不相等就返回false
    if ( str.charAt(left) != str.charAt(right)) {
    return false;
    }
    left++;
    right--;
    }
    return true;
}
}
空间复杂度O(1)