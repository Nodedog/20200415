import java.util.Stack;
/*
*
*
*       用两个栈实现队列
*
*
* */
public class Test3 {
    //stack1用来入队列
    //stack2用来出队列
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    //入队列
    public void offer(int n) {
        while (!stack2.isEmpty()){
            int tmp = stack2.pop();
            stack1.push(tmp);
        }
        stack1.push(n);
    }

    //出队列
    public Integer pull() {
        //先判空 如果为空直接返回null
        if (empty()){
            return null;
        }
        while (!stack1.isEmpty()){
            int tmp = stack1.pop();
            stack2.push(tmp);
        }
        return stack2.pop();
    }


    //取队首元素
    public Integer peek(){
        if (empty()){
            return null;
        }
        while (!stack1.isEmpty()){
            int tmp = stack1.pop();
            stack2.push(tmp);
        }
        return stack2.peek();
    }



    private boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
