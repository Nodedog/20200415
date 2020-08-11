import java.util.Stack;

/*
*
*
*                               栈和队列的面试题
*
*
*
* */
//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
//有效字符串需满足：
//1.左括号必须用相同类型的右括号闭合。
//2.左括号必须以正确的顺序闭合。
//注意空字符串可被认为是有效字符串。
public class TestDemo {

        public  boolean isValid(String s) {
            if (s.isEmpty()){
                return true;
            }
            //1.创建一个栈
            Stack<Character> stack = new Stack<>();

            //2.遍历字符串 取出字符看是左括号还是右括号
            //s.length是字符串的长度 s.charAt这个方法返回的是一个字符 char
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                //如果是左括号，直接入栈
                if (c == '(' || c == '[' || c == '{') {
                    stack.push(c);
                    continue;
                }
                //如果是右括号，去栈顶元素和当前元素看是否匹配
                if (stack.empty()){
                    return  false;
                }
                Character top = stack.pop();
                //看括号是否匹配
                if (top == '(' && c == ')'){
                    continue;
                }
                if (top == '[' && c == ']'){
                    continue;
                }  if (top == '{' && c == '}'){
                    continue;
                }
                return false;
            }
            //3.最后遍历完字符串之后看栈是否为空
            if (stack.empty()){
                return true;
            }
            return false;
        }


    public static void main(String[] args) {
        TestDemo testDemo = new TestDemo();
        String s = "()[]{}";
        System.out.println(testDemo.isValid(s));
    }
}
