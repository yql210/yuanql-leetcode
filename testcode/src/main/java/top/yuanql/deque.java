package top.yuanql;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: top.yuanql
 * @BelongsClassName: deque
 * @Author: yuanql
 * @CreateTime: 2023-07-10  09:35
 * @Description:
 * @Version: 1.0
 */


public class deque {

    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5, -1, -2, -3, 2};
        Deque<Integer> deque = new LinkedList<Integer>();

        for (int i = 0; i < ints.length; i++) {

            while (!deque.isEmpty() && ints[i] > ints[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        System.out.println(deque);

        while (!deque.isEmpty()) {
            System.out.println(deque.peekFirst() + "--------     " + ints[deque.pollFirst()]);
        }
    }
}
