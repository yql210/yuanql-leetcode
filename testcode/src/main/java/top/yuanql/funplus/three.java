package top.yuanql.funplus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: top.yuanql.funplus
 * @BelongsClassName: three
 * @Author: yuanql
 * @CreateTime: 2023-10-13  19:12
 * @Description:
 * @Version: 1.0
 */


public class three {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param nums int整型ArrayList
     * @param k int整型
     * @return bool布尔型
     */
    public boolean candivide (ArrayList<Integer> nums, int k) {
        // write code here

        if (k > nums.size()) return false;
        Collections.sort(nums, (o1, o2) -> o2 - o1);

        long sum = 0L;

        for (int i = 0; i < nums.size(); i++) {
            sum += nums.get(i);
        }

        if (sum % k != 0) return false;

        sum = sum / k;
        boolean[] used = new boolean[nums.size()];
        long temp = 0L;

        for (int i = 0; i < k; i++) {
            temp = 0L;
            for (int j = 0; j < nums.size(); j++) {
                if (used[j]) continue;
                if (temp + nums.get(j) < sum) {
                    temp = temp + nums.get(j);
                    used[j] = true;
                } else if (temp + nums.get(j) == sum) {
                    temp = temp + nums.get(j);
                    used[j] = true;
                    break;
                }
            }
            if (temp != sum) return false;
        }


//        ArrayList<Integer>[][] conList;
//        conList = new ArrayList<>[3][2];



        return true;

    }
}
