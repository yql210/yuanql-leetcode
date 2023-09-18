package top.yuanql.test;

import netscape.security.UserTarget;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: top.yuanql.test
 * @BelongsClassName: Test84
 * @Author: yuanql
 * @CreateTime: 2023-09-12  21:47
 * @Description:
 * @Version: 1.0
 */


public class Test84 {
    public static void main(String[] args) {
        int[] heights = new int[]{2,1,2};
        int i = largestRectangleArea(heights);
        System.out.println(i);
    }

    public static int largestRectangleArea(int[] heights) {
        Deque<Integer> deque = new ArrayDeque<>();

        int result = 0;


        // 数组扩容，在头和尾各加入一个元素
        int [] newHeights = new int[heights.length + 2];
        newHeights[0] = 0;
        newHeights[newHeights.length - 1] = 0;
        for (int index = 0; index < heights.length; index++){
            newHeights[index + 1] = heights[index];
        }

        for (int i = 0; i < newHeights.length; i++) {
            while (!deque.isEmpty() && newHeights[deque.peek()] > newHeights[i]) {
                int poll = deque.poll();

                result = Math.max(result, (i - deque.peek() - 1) * newHeights[poll]);
//                System.out.println(poll[0] * (i - poll[1]));
            }
            deque.push(i);
        }

        return result;
    }
}
