package top.yuanql.yongyou;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: top.yuanql.yongyou
 * @BelongsClassName: three
 * @Author: yuanql
 * @CreateTime: 2023-09-18  19:25
 * @Description:
 * @Version: 1.0
 */


public class three {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param n int整型 人员总数
     * @param meetings int整型二维数组 人员接触信息
     * @param firstPerson int整型 人员 0 在时刻 0 第一个接触到的人员编号
     * @return int整型ArrayList
     */
    public ArrayList<Integer> findAllPerson (int n, int[][] meetings, int firstPerson) {
        // write code here

        Arrays.sort(meetings, (o1, o2) -> o1[2] - o2[2]);

        HashSet<Integer> set = new HashSet<>();
        set.add(firstPerson);
        set.add(0);
//        ArrayList<Integer> result = new ArrayList<>();
//        result.add(firstPerson);
//        result.add(0);
        HashSet<Integer> setTemp = new HashSet<>();
        boolean flag = false;
        int time = 0;

        for (int i = 0; i < meetings.length;) {
            time = meetings[i][2];
            setTemp.clear();
            flag = false;

            while (i < meetings.length && time == meetings[i][2]) {
                setTemp.add(meetings[i][0]);
                setTemp.add(meetings[i][1]);
                if (set.contains(meetings[i][0]) || set.contains(meetings[i][1])) flag = true;
                i++;
            }

            if (flag) {
                for (Integer integer:  setTemp) {
                    set.add(integer);
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<>();

        for (Integer integer: set) {
            result.add(integer);
        }

        Collections.sort(result);

        return result;

    }
}
