package lintCode_alg._8_data_structure;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Implement a stack by two queues. The queue is first in first out (FIFO). That means you can not directly pop the last element in a queue.
 * <p>
 * Have you met this question in a real interview?
 * Example
 * push(1)
 * pop()
 * push(2)
 * isEmpty() // return false
 * top() // return 2
 * pop()
 * isEmpty() // return true
 */
public class _494 {
    private Queue<Integer> qAdd = new LinkedList<>();
    private Queue<Integer> qPop = new LinkedList<>();

    public void push(int x) {
        // write your code here
        qAdd.add(x);
    }

    /*
     * @return: nothing
     */
    public void pop() {
        // write your code here
        // This is where has problem
        if (isEmpty()) {
            return;
        }
        transfer();
        qPop.remove();
    }

    private void transfer() {
        while (qAdd.size() > 1) {
            qPop.add(qAdd.remove());
        }
        Queue<Integer> temp = qAdd;
        qAdd = qPop;
        qPop = temp;
    }

    /*
     * @return: An integer
     */
    public int top() {
        // write your code here
        transfer();
        int res = qPop.peek();
        // This to make sure all elements in qAdd
        qAdd.add(qPop.remove());
        return res;
    }

    /*
     * @return: True if the stack is empty
     */
    public boolean isEmpty() {
        // write your code here
        return qAdd.size() == 0;
    }
}
