package top.yuanql;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: top.yuanql
 * @BelongsClassName: DequeMy
 * @Author: yuanql
 * @CreateTime: 2023-07-21  09:02
 * @Description: 测试双端队列
 * @Version: 1.0
 */


public class DequeMy {
    public static void main(String[] args) {
//        Deque<Integer> deque = new LinkedList<>();
//
//        deque.add(11);
//        deque.add(22);
//        deque.addFirst(333);
//
//        deque.addLast(4444);
//
//        System.out.println(deque);


        PriorityQueue<Double> queue = new PriorityQueue<>((o1, o2) -> o2.compareTo(o1));
        queue.add(1.0);
        queue.add(1.0);
        queue.add(1.0);
        queue.add(1.0);
        queue.add(1.0);
        queue.add(1.0);
        queue.add(1.0);
        queue.add(1.0);

        double mid = 4.0;
        double sumMid = 0.0;
        while (sumMid < mid) {
            double v = queue.poll() / 2;
            sumMid += v;
            queue.add(v);
        }
        System.out.println("queue = " + queue);


    }
}
