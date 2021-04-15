public class Solution01 {
    public int FirstNotRepeatingChar(String str) {
        if (str.length() == 0 || str == " ") {
            return -1;
        }
        char[] chars = str.toCharArray();
        char[] temp = new char[256];
        for(int i = 0 ; i < chars.length; i++) {
            //字符的ASCLL 作为数组的下标  出现的次数作为小标对应的值
            temp[chars[i]]++;
        }
        for (int i = 0 ; i < temp.length; i++ ) {
            //要按照字符串的字符顺序进行遍历 这里是个坑 需要注意
            if(temp[chars[i]] == 1 ) {
                return i;
            }
        }
        return -1;
    }
}