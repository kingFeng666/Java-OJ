class Solution {
    public String replaceSpace(String s) {
    //使用StringBuffer完成字符串的拼接
     StringBuffer stringBuffer = new  StringBuffer();
     for(int i = 0 ; i < s.length() ; i++ ) {
     char c = s.charAt(i);
     if(c == ' ') {
     stringBuffer.append("%20");
     }else{
         stringBuffer.append(c);
     }
     }
     return stringBuffer.toString();
    }
}
//解法2 
class Solution {
    public String replaceSpace(String s) {
        char[] array = new char[s.length() * 3];
        int size = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                array[size++] = '%';
                array[size++] = '2';
                array[size++] = '0';
            } else {
                array[size++] = c;    
            }
        }
        String res = new String(array, 0, size);
        return res;
    }
}