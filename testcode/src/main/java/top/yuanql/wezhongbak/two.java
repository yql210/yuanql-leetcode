package top.yuanql.wezhongbak;

import com.sun.xml.internal.messaging.saaj.packaging.mime.util.QDecoderStream;

import java.util.*;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: top.yuanql.wezhongbak
 * @BelongsClassName: two
 * @Author: yuanql
 * @CreateTime: 2023-09-13  20:20
 * @Description:
 * @Version: 1.0
 */


public class two {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            deque.offer(in.nextInt());
        }

        System.out.print(deque.pop());

        while (!deque.isEmpty()) {
            deque.offer(deque.pop());
            System.out.print(" " + deque.pop());
        }

    }
}
