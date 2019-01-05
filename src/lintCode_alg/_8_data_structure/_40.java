package lintCode_alg._8_data_structure;

import java.util.Stack;

/**
 * As the title described, you should only use two stacks to implement a queue's actions.
 * <p>
 * The queue should support push(element), pop() and top() where pop is pop the first(a.k.a front) element in the queue.
 * <p>
 * Both pop and top methods should return the value of first element.
 */
public class _40 {
    public class MyQueue {
        // s2 for top and pop method.
        // s1 for push method.
        Stack<Integer> s2;
        Stack<Integer> s1;

        public MyQueue() {
            s2 = new Stack<>();
            s1 = new Stack<>();
        }

        /*
         * @param element: An integer
         * @return: nothing
         */
        public void push(int element) {
            s1.add(element);
        }

        /*
         * @return: An integer
         */
        public int pop() {
            // write your code here
            if (s2.isEmpty()) {
                moveStack(s1, s2);
            }
            return s2.pop();
        }

        /*
         * @return: An integer
         */
        public int top() {
            // write your code here
            if (s2.isEmpty()) {
                moveStack(s1, s2);
            }
            return s2.peek();
        }

        // move all s1 to s2
        private void moveStack(Stack<Integer> s1, Stack<Integer> s2) {
            while (!s1.isEmpty()) {
                s2.add(s1.pop());
            }
        }
    }
}
