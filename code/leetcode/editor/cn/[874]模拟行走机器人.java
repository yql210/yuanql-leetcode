//机器人在一个无限大小的 XY 网格平面上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令 commands ： 
//
// 
// -2 ：向左转 90 度 
// -1 ：向右转 90 度 
// 1 <= x <= 9 ：向前移动 x 个单位长度 
// 
//
// 在网格上有一些格子被视为障碍物 obstacles 。第 i 个障碍物位于网格点 obstacles[i] = (xi, yi) 。 
//
// 机器人无法走到障碍物上，它将会停留在障碍物的前一个网格方块上，但仍然可以继续尝试进行该路线的其余部分。 
//
// 返回从原点到机器人所有经过的路径点（坐标为整数）的最大欧式距离的平方。（即，如果距离为 5 ，则返回 25 ） 
//
// 
// 
// 
// 
// 
// 
// 
// 
// 
// 
// 
//
// 
// 注意： 
// 
//
// 
// 北表示 +Y 方向。 
// 东表示 +X 方向。 
// 南表示 -Y 方向。 
// 西表示 -X 方向。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：commands = [4,-1,3], obstacles = []
//输出：25
//解释：
//机器人开始位于 (0, 0)：
//1. 向北移动 4 个单位，到达 (0, 4)
//2. 右转
//3. 向东移动 3 个单位，到达 (3, 4)
//距离原点最远的是 (3, 4) ，距离为 3² + 4² = 25 
//
// 示例 2： 
//
// 
//输入：commands = [4,-1,4,-2,4], obstacles = [[2,4]]
//输出：65
//解释：机器人开始位于 (0, 0)：
//1. 向北移动 4 个单位，到达 (0, 4)
//2. 右转
//3. 向东移动 1 个单位，然后被位于 (2, 4) 的障碍物阻挡，机器人停在 (1, 4)
//4. 左转
//5. 向北走 4 个单位，到达 (1, 8)
//距离原点最远的是 (1, 8) ，距离为 1² + 8² = 65 
//
// 
//
// 提示： 
//
// 
// 1 <= commands.length <= 10⁴ 
// commands[i] is one of the values in the list [-2,-1,1,2,3,4,5,6,7,8,9]. 
// 0 <= obstacles.length <= 10⁴ 
// -3 * 10⁴ <= xi, yi <= 3 * 10⁴ 
// 答案保证小于 2³¹ 
// 
//
// Related Topics 数组 模拟 👍 187 👎 0


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
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
//leetcode submit region end(Prohibit modification and deletion)
