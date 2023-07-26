import java.util.ArrayList;
import java.util.List;

import org.omg.PortableInterceptor.ForwardRequest;

/*
 * @lc app=leetcode.cn id=73 lang=java
 *
 * [73] 矩阵置零
 */

// @lc code=start
class Solution {
    public void setZeroes(int[][] matrix) {

        // 方法一：
        // 暴力求解
        List<int[]> ls = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0)
                ls.add(new int[]{i, j});
            }
        }

        for (int[] is : ls) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][is[1]] = 0;
            }
            for (int i = 0; i < matrix[is[0]].length; i++) {
                matrix[is[0]][i] = 0;
            }
        }


    }
}
// @lc code=end

