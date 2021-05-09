class CQueue {
    //题目要求使用两个栈实现队列
     Stack<Integer> stack1;
     Stack<Integer> stack2;
    
    public CQueue() {
        //初始化两个空栈
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    } 
    public void appendTail(int value) {
    //在队尾部插入整数
    stack1.push(value);
    }
    
    public int deleteHead() {
     //在队列头部删除整数
     if(stack2.isEmpty()) {
     while(!stack1.isEmpty()) {
     stack2.push(stack1.pop());
     }
 }
     if(stack2.isEmpty()) {
         return -1;
     }else{
         int res = stack2.pop();
         return res;
     }  
    }
}
