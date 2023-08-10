//按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。 
//
// n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。 
//
// 
// 
// 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
// 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 4
//输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[["Q"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 
//
// Related Topics 数组 回溯 👍 1852 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private String[] strings;

    private List<List<String>> result = new ArrayList<>();

    // path数组的含义：
    // path的第i位，代表着在棋盘的第i列放置皇后；
    // 第i位对应的数值path[i]，代表在第path[i]行放置皇后
    // 这样就把一个二维的棋盘转换为了一个一维的数组，并且可以唯一的确认一个解法
    // 根据皇后在数组上的位置i不用，数值path[i]不同，即可使其满足不同行，不同列的性质。斜线需要进行特殊判断
    private int[] path;

    public List<List<String>> solveNQueens(int n) {
        strings = new String[n];

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            stringBuilder = new StringBuilder();
            for (int j = 0; j < i; j++) {
                stringBuilder.append('.');
            }
            stringBuilder.append('Q');
            for (int j = i + 1; j < n; j++) {
                stringBuilder.append('.');
            }
            strings[i] = stringBuilder.toString();
        }

        path = new int[n];
        backtracking(1, n);
        return result;
    }

    /**
     * 回溯函数，本题的核心逻辑
     * @param row 当前正在遍历第几行：从1开始进行遍历
     * @param n 棋盘一共有多少行，其主要用于做结束的判断
     */
    private void backtracking(int row, int n) {
        if (row == n + 1) { // 找到了一个可行路径，将可行的路径转换为所需要的答案返回
            List<String> temp = new ArrayList<>(n);
            for (int i = 0; i < n; i++) { // 此处是为了增加temp数组的长度，为下面的加入做准备
                temp.add("");
            }
            for (int i = 0; i < path.length; i++) { // 因为path数组的含义为：i代表列，path[i]代表这列
                temp.set(path[i] - 1, strings[i]); // 但是最终结果要按照行去放置，所以使用此方式添加
            }
            result.add(temp);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (path[i] == 0 && isAvailable(row, i)) { // 此时意味着第row行，第i列不存在数据；判断以下是否斜线上有数据
                path[i] = row;
                backtracking(row + 1, n);
                path[i] = 0; // 回溯
            }
        }

    }

    /**
     * 判断斜线上是否存在冲突（行、列上已经有递归函数中的逻辑进行了限制，所以只需要判断斜线上即可）
     * @param row 当前要插入的元素所在的行
     * @param col 当前要插入的元素所在的列
     * @return 如果有冲突，则返回false；反之返回true。
     */
    private boolean isAvailable(int row, int col) {
        for (int i = 0; i < path.length; i++) {
            // i代表着列，path[i]代表着行
            if (path[i] != 0 && Math.abs(row - path[i]) == Math.abs(col - i)) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
