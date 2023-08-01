package top.yuanql.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: top.yuanql.java
 * @BelongsClassName: TestInteger
 * @Author: yuanql
 * @CreateTime: 2023-08-01  16:37
 * @Description:
 * @Version: 1.0
 */


public class TestInteger {

    public static void main(String[] args) {
        Integer a=1005;
        System.out.println("a的地址:"+System.identityHashCode(a));
        add(a);
        System.out.println(a);

        List<Integer> list = new ArrayList<>();
        list.add(12);
        add(list);
        System.out.println("list : " + list.get(0));

    }

    private static void add(Integer a) {
        System.out.println("a的地址:"+System.identityHashCode(a));

        a = 10923;
        System.out.println("a的地址:"+System.identityHashCode(a));
    }

    private static void add(List<Integer> list) {

        list.set(0, 12222);
    }


}
