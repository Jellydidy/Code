import java.util.Stack;

/**
 * @author Jelly
 * @version 1.0.0
 * @ClassName L006.java
 * @Description TODO
 * @createTime 2020年04月22日 23:04:00
 */
public class L006 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    class Solution {
        public int[] reversePrint(ListNode head) {
            Stack<Integer> stack = new Stack<Integer>();
            while (head!=null) {
                stack.push(head.val);
                head = head.next;
            }

            int size = stack.size();
            int[] array = new int[size];
            for (int i = 0; i < size; i++) {
                array[i] = stack.pop();
            }

            return array;
        }
    }
}
