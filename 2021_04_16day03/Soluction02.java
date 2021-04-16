/**
数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
*/
//题解1
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
    	HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        //将数组中的元素存储在map集合中 key对应数组中元素的值 value对应数组中元素出现的次数
        for(int i=0;i<array.length;i++){
            
            if(!map.containsKey(array[i])){
               map.put(array[i],1); 
            }else{
                int count = map.get(array[i]);
                //将元素出现的次数存储在map集合中的value中去
                map.put(array[i],++count);
            }
        }
        //遍历map集合找到value值大于array.length/2 的那个元素对应的value返回
        Iterator iter = map.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry entry = (Map.Entry)iter.next();
            Integer key =(Integer)entry.getKey();
            Integer val = (Integer)entry.getValue();
            if(val>array.length/2){
                return key;
            }
        }
        return 0;
    }
 }
//题解2
import java.util.Arrays;
public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
    	Arrays.sort(array);
        int count=0;
        for(int i = 0;i < array.length; i++){
            if(array[i] == array[array.length/2]){
                count++;
            }
        }
        if(count > array.length/2){
            return array[array.length/2];
        }else{
            return 0;
        }
        
    }
}