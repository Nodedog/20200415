import java.util.LinkedList;
import java.util.Queue;
/*
*
*
*        用两个队列实现栈
*
*
* */
public class Test2 {
    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();

    //进栈
    public void push(int n){
        //直接用入队列实现进栈操作
        queue1.offer(n);
    }



    //出栈
    public Integer pop(){
        //先判空 如果为空直接返回null
        if (empty()){
            return null;
        }

        //将queue1里的元素出队列 再队列到queue2
        //因为循环条件是size>1所以剩最后一个元素相当于栈顶元素
        while(queue1.size() > 1){
            Integer ret = queue1.poll();
            queue2.offer(ret);
        }
        //循环结束剩的最后一个元素poll取出相当于栈顶元素 直接返回
        Integer B = queue1.poll();
        //用swap交换queue1 queue2 回到原来的状态
        //原来状态:queue1保存数据
        swap();
        return B;
    }


    private void swap() {
        Queue<Integer> A = queue1;
        queue1 = queue2;
        queue2 = A;
    }





    //取栈顶元素
    //取栈顶元素和出栈操作基本一样
    public Integer peek(){
        if (empty()){
            return null;
        }

        while(queue1.size() > 1){
            Integer ret = queue1.poll();
            queue2.offer(ret);
        }
        Integer B = queue1.poll();
        //因为出栈是直接不要栈顶元素 size-1
        //去栈顶元素只是取出来size不减1
        //所以还要将最后一个元素在offer进queue2里
        queue2.offer(B);
        swap();
        return B;
    }



    //判空
    public boolean empty(){
        return queue1.isEmpty() && queue2.isEmpty();
    }
}
