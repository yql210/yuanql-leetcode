//找出所有相加之和为 n 的 k 个数的组合，且满足下列条件： 
//
// 
// 只使用数字1到9 
// 每个数字 最多使用一次 
// 
//
// 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。 
//
// 
//
// 示例 1: 
//
// 
//输入: k = 3, n = 7
//输出: [[1,2,4]]
//解释:
//1 + 2 + 4 = 7
//没有其他符合的组合了。 
//
// 示例 2: 
//
// 
//输入: k = 3, n = 9
//输出: [[1,2,6], [1,3,5], [2,3,4]]
//解释:
//1 + 2 + 6 = 9
//1 + 3 + 5 = 9
//2 + 3 + 4 = 9
//没有其他符合的组合了。 
//
// 示例 3: 
//
// 
//输入: k = 4, n = 1
//输出: []
//解释: 不存在有效的组合。
//在[1,9]范围内使用4个不同的数字，我们可以得到的最小和是1+2+3+4 = 10，因为10 > 1，没有有效的组合。
// 
//
// 
//
// 提示: 
//
// 
// 2 <= k <= 9 
// 1 <= n <= 60 
// 
//
// Related Topics 数组 回溯 👍 715 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
    backtracking(1, k, n, 0, new ArrayList<>(), result);

        return result;
    }

    /**
     * 回溯函数
     * @param start 加入数组的数值，同时也是开始遍历的数值
     * @param k 当前正在加入第几个参数，k是从头向下减的
     * @param n 相加之和之后的判断数值
     * @param sum 当前数值相加之后的值，其等于list中的数值相加
     * @param list 遍历的数值加入到list中
     * @param result 存放结果
     */
    private void backtracking(int start, int k, int n, int sum, List<Integer> list, List<List<Integer>> result) {
        if (sum > n) return; // 剪枝
        if (k == 0) {
            if (sum == n) {
                result.add(new ArrayList<>(list));
            }
            return;
        }


        for (int i = start; i <= 9 - k + 1; i++) { // 剪枝
            list.add(i);
            backtracking(i + 1, k - 1, n, sum + i, list, result);
            list.remove(list.size() - 1);
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
