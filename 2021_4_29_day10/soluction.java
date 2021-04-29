class Solution {
    public String multiply(String num1, String num2) {
     if(num1.equals("0")||num2.equals("0")) 
     return "0";
     int len1=num1.length();
     int len2=num2.length();
     int len=len1+len2;
     int[] res=new int[len];
     //然后处理两个数字符相乘 
     for(int i=0;i<len1;i++){
        for(int j=0;j<len2;j++){
            int temp=(num1.charAt(i)-'0')*(num2.charAt(j)-'0');
            //然后将计算结构保存在数组中
            res[i+j+1]+=temp;;
        }
     }
     //然后做进位处理
     for(int i=len-1;i>=1;i--){
        int temp=res[i]/10;
        res[i-1]+=temp;
        res[i]-=temp*10;
     }
     //将结构保存转换为字符串
     StringBuilder path = new StringBuilder();
        for(int i = 0 ; i < len; i++)
        {
            //如果首尾是0, 不添加
            if(i == 0 && res[i] == 0)  continue;
            path.append(res[i]);
        }
        return path.toString();
        }
}