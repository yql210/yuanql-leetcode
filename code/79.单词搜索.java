import javax.security.auth.x500.X500Principal;

/*
 * @lc app=leetcode.cn id=79 lang=java
 *
 * [79] 单词搜索
 */

// @lc code=start
class Solution {
    public boolean exist(char[][] board, String word) {
        char[] wr = word.toCharArray();
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == wr[0]) {
                    
                    for (int j2 = 1; j2 < wr.length; j2++) {
                        if (outLimit(i + 1, j2 + 1, m, n)) {
                            if 
                        }
                    }



                }
            }
        }
        return false;
    }

    // 判断上下限是否超出限制
    public boolean outLimit(int x, int y, int xMax, int yMax)
    {
        if (x < 0 || x > xMax - 2)
            return false;
        if (y < 0 || y > yMax - 2) 
            return false;
        return true;
    }
}
// @lc code=end

