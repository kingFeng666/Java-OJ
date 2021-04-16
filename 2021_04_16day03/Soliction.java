//二进制中1的个数
public class Solution {
    public int NumberOf1(int n) {
        int count = 0;
        while(n != 0) {
            count++;
            //利用& 运算符  n&(n-1) 其实就是让n的二进制中的1的个数减去一个1,然后通过这种方法巧妙的计算出
            //一个数的二进制数中的1的个数
            n &= n - 1;
        }
        return count;
    }
}
//方法二
public class Solution {
    public int NumberOf1(int n) {
        int count = 0;
        for(int i = 0; i < 32; i++) {
            if(((n >> i) & 1) == 1) {
                count++;
            }
        }
        return count;
    }
}