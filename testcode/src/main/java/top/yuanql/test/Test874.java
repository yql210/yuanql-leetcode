package top.yuanql.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: top.yuanql
 * @BelongsClassName: Test874
 * @Author: yuanql
 * @CreateTime: 2023-07-19  16:26
 * @Description: 模拟行走机器人
 * @Version: 1.0
 */


public class Test874 {
    public static void main(String[] args) {
//        List<Integer> tem = new ArrayList<>();
//        tem.add(75);
//        tem.add(45);
//        tem.add(65);
//        tem.add(85);
//        tem.add(35);
//        tem.add(95);
//        tem.add(55);
//
//        System.out.println(tem);
//
//        tem.sort((o1, o2) -> (o1 - o2));
//
//        System.out.println(tem);
//
//        int i = selectIndex(38, -3, tem);
//        System.out.println("i = " + i);

        int[] com = new int[]{-2,-1,-2,3,7};
        int[][] obstacles = new int[10][];
        obstacles[0] = new int[]{1,-3};
        obstacles[1] = new int[]{2,-3};
        obstacles[2] = new int[]{4,0};
        obstacles[3] = new int[]{-2,5};
        obstacles[4] = new int[]{-5,2};
        obstacles[5] = new int[]{0,0};
        obstacles[6] = new int[]{4,-4};
        obstacles[7] = new int[]{-2,-5};
        obstacles[8] = new int[]{-1,-2};
        obstacles[9] = new int[]{0,2};
        int i = robotSim(com, obstacles);
        System.out.println("i = " + i);


    }

    public static int robotSim(int[] commands, int[][] obstacles) {
        int result = 0;
        int direction = 400; // 定义机器人的前进方向。取余数：0：北   1：东  2：南  3：西
        // 此处的数值为什么设置为400? 因为 -1%4 的答案为 -1。为了完成此问题，如果你做到一直递减400次，我认了
        int[] reboot = new int[2]; // 记录机器人所在的位置 (x,y)

        HashMap<Integer, List<Integer>> xHashMap = new HashMap<>();
        HashMap<Integer, List<Integer>> yHashMap = new HashMap<>();

        for (int[] obstacle : obstacles) {
            if (xHashMap.containsKey(obstacle[0])) {
                List<Integer> list = xHashMap.get(obstacle[0]);
                list.add(obstacle[1]);
                xHashMap.replace(obstacle[0], list);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(obstacle[1]);
                xHashMap.put(obstacle[0], list);
            }
            if (yHashMap.containsKey(obstacle[1])) {
                List<Integer> list = yHashMap.get(obstacle[1]);
                list.add(obstacle[0]);
                yHashMap.replace(obstacle[1], list);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(obstacle[0]);
                yHashMap.put(obstacle[1], list);
            }
        }

        for (Map.Entry<Integer, List<Integer>> tem : xHashMap.entrySet()) {
            tem.getValue().sort(((o1, o2) -> (o1 - o2)));
        }
        for (Map.Entry<Integer, List<Integer>> tem : yHashMap.entrySet()) {
            tem.getValue().sort(((o1, o2) -> (o1 - o2)));
        }

        for (int command : commands) {
            if (command < 0) { // 此时机器人进行转向操作
                direction = command == -1 ? direction + 1 : direction - 1;
            } else { // 此时机器人尝试前进
                int temp = direction % 4;
                switch (direction % 4) {
                    case 0 : // y++
                        if (xHashMap.containsKey(reboot[0])) {
                            reboot[1] = selectIndex(reboot[1], command, xHashMap.get(reboot[0]));
                        } else {
                            reboot[1] += command;
                        }
                        break;
                    case 1 : // x++
                        if (yHashMap.containsKey(reboot[1])) {
                            reboot[0] = selectIndex(reboot[0], command, yHashMap.get(reboot[1]));
                        } else {
                            reboot[0] += command;
                        }
                        break;
                    case 2 : // y--
                        if (xHashMap.containsKey(reboot[0])) {
                            reboot[1] = selectIndex(reboot[1], -1 * command, xHashMap.get(reboot[0]));
                        } else {
                            reboot[1] -= command;
                        }
                        break;
                    case 3 : // x--
                        if (yHashMap.containsKey(reboot[1])) {
                            reboot[0] = selectIndex(reboot[0], -1 * command, yHashMap.get(reboot[1]));
                        } else {
                            reboot[0] -= command;
                        }
                        break;
                }

                if ((reboot[0] * reboot[0] + reboot[1] * reboot[1]) > result) {
                    result = reboot[0] * reboot[0] + reboot[1] * reboot[1];
                }
            }
        }
        return result;
    }


    /**
     * 找到满足条件的数值
     * @param index 开始的起点
     * @param l 向走的步数
     * @param list 障碍所在的坐标
     * @return
     */
    private static int selectIndex(int index, int l, List<Integer> list) {
        if (l > 0) {
            if (index >= list.get(list.size() - 1) || (index + l) < list.get(0)) {
                return index + l;
            }

            int i = 0;
            for (; index > list.get(i); i++) {
            }

            if (index + l > list.get(i)) {
                return list.get(i) - 1;
            }
            return index + l;
        } else {
            if (index <= list.get(0) || (index + l) > list.get(list.size() - 1)) {
                return index + l;
            }

            int i = list.size() - 1;
            for (; index < list.get(i); i--) {
            }

            if (index + l < list.get(i)) {
                return list.get(i) + 1;
            }
            return index + l;
        }
    }
}
