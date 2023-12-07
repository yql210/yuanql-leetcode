package top.yuanql.qiaanxin;

import com.sun.org.apache.xerces.internal.xs.ItemPSVI;

import java.util.Arrays;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: top.yuanql.qiaanxin
 * @BelongsClassName: one
 * @Author: yuanql
 * @CreateTime: 2023-10-07  18:31
 * @Description:
 * @Version: 1.0
 */


public class one {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param planks int整型一维数组
     * @return bool布尔型
     */
    public boolean CheckSquare (int[] planks) {
        // write code here
        Arrays.sort(planks);
        long all = 0L;

        for (int i = planks.length - 1; i >= 0; i--) {
            all += planks[i];
        }

        if (all % 4 != 0) return false;

        all = all / 4;
        boolean[] used = new boolean[planks.length];
        long temp = 0L;


        for (int j = 0; j < 4; j++) {
            temp = 0L;
            for (int i = planks.length - 1; i >= 0; i--) {
                if (!used[i]) {
                    if (temp + planks[i] < all) {
                        temp += planks[i];
                        used[i] = true;
                    } else if (temp + planks[i] == all){
                        temp += planks[i];
                        used[i] = true;
                        break;
                    }
                }
            }
            if (temp != all) return false;
        }



        return true;


    }

}
