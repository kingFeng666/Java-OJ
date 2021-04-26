class Solution {
    public int lengthOfLastWord(String s) {
     /*if(s.length()==0||s.isEmpty()){
         return 0;
     }
     s=s.trim();//去除字符串两端的空格 只会去除掉字符串两端的所有空格 中间的不回去除
     String[] str= s.split(" ");
     return str[str.length-1].length();*/
     if(s.length()==0||s.isEmpty()) return 0;
     int length=0;
     
     s=s.trim();
     for(int i=s.length()-1;i>=0;i--){
      if(s.charAt(i)!=' '){
           length++;
      }else{
          return length;
      }
     }
     return length;
    }
}