package top.yuanql.wezhongbak;

import java.util.*;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: top.yuanql.wezhongbak
 * @BelongsClassName: first
 * @Author: yuanql
 * @CreateTime: 2023-09-13  20:17
 * @Description:
 * @Version: 1.0
 */


public class first {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();
        int s = in.nextInt();
        int t = in.nextInt();
        int a;
        int b;
        HashMap<Integer, HashSet<Integer>> input = new HashMap<>();

        for (int i = 0; i < m; i++) { // 开始接收桥相关的信息
            a = in.nextInt();
            b = in.nextInt();
            if (!input.containsKey(a)) { // 桥有两端，a是其中的一段
                HashSet<Integer> tempSet = new HashSet<>(); // 原始的数据中不存在，则需要申请新的set数组
                tempSet.add(b); // 将数据进行添加赋值
                input.put(a, tempSet); // 将数据放到hashMap中
            } else {
                input.get(a).add(b); // 此时存在数据，直接对hashSet进行操作
            }

            if (!input.containsKey(b)) { // b 是另一端，添加也是一样的逻辑
                HashSet<Integer> tempSet = new HashSet<>();
                tempSet.add(a);
                input.put(b, tempSet);
            } else {
                input.get(b).add(a);
            }
        }

        HashSet<Integer> temp = new HashSet<>();
        temp.add(s);
        HashSet<Integer> temp1 = new HashSet<>();

        HashSet<Integer> startS = new HashSet<>();
        startS.add(s);
        boolean flag = input.containsKey(s); // 一定要注意是s，此时是对开始的节点进行操作

        while(flag) { // 核心代码
            flag = false;
            for (Integer integer: temp) {
                if (!input.containsKey(integer)) continue;
                for (Integer integer1 : input.get(integer)) {
                    if (!startS.contains(integer1)) {
                        startS.add(integer1);
                        temp1.add(integer1);
                        flag = true;
                    }
                }
            }
            temp = temp1;
            temp1 = new HashSet<>();
        }

        if (startS.contains(t)) { // 如果包含，说明有路直达，所以使用下方的公式进行计算
            int size = startS.size();
            System.out.println(((long) (size - 1)) * size / 2);
            return;
        }

        HashSet<Integer> tempT = new HashSet<>();
        tempT.add(t);
        HashSet<Integer> tempT1 = new HashSet<>();

        HashSet<Integer> endT = new HashSet<>();
        endT.add(t);
        boolean flagT = input.containsKey(t);

        while (flagT) {
            flagT = false;
            for (Integer integer : tempT) {
                if (!input.containsKey(integer)) continue;
                for (Integer integer1: input.get(integer)) {
                    if (!endT.contains(integer1)) {
                        endT.add(integer1);
                        tempT1.add(integer1);
                        flagT = true;
                    }
                }
            }
            tempT = tempT1;
            tempT1 = new HashSet<>();
        }
        System.out.println(((long) endT.size()) * startS.size());

    }
}
