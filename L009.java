import java.util.Stack;

/**
 * @author Jelly
 * @version 1.0.0
 * @ClassName L009.java
 * @Description 两个栈实现队列
 * @createTime 2020年04月26日 23:59:00
 */
public class L009 {
    class CQueue {

        Stack<Integer> A;
        Stack<Integer> B;
        int size;

        public CQueue() {
            A = new Stack<>();
            B = new Stack<>();
            size = 0;
        }

        public void appendTail(int value) {
            A.push(value);
            size++;
        }

        public int deleteHead() {
            if (size<=0) {
                return -1;
            }
            if (B.isEmpty()){
                while (!A.isEmpty()) {
                    B.push(A.pop());
                }
            }
            size--;
            return B.pop();
        }
    }
}
