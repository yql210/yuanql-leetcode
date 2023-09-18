package top.yuanql.meituan;

import java.util.*;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: top.yuanql.meituan
 * @BelongsClassName: first
 * @Author: yuanql
 * @CreateTime: 2023-09-02  19:02
 * @Description:
 * @Version: 1.0
 */


public class first {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int num;

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            num = in.nextInt();
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }

        int sum = 0;
        List<Integer> list = new ArrayList<>();

        for (Map.Entry<Integer, Integer> map : hashMap.entrySet()) {
            Integer value = map.getValue();
            if (value >= 2) {
                sum++;
                value -= 2;
            }
            if (value > 0) {
                list.add(value);
            }
        }

        Collections.sort(list, (o1, o2) -> o2 - o1);

        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) == 0) continue;
            for (int j = 1; j < list.size(); j++) {
                if (list.get(j) == 0) continue;
                sum++;
                list.set(j, list.get(j) - 1);
                if (list.get(i) == 1) break;
                list.set(i, list.get(i) - 1);
            }
        }

        System.out.println(sum);



        // // 注意 hasNext 和 hasNextLine 的区别
        // while (in.hasNextInt()) { // 注意 while 处理多个 case
        //     int a = in.nextInt();
        //     int b = in.nextInt();
        //     System.out.println(a + b);
        // }
    }

}
