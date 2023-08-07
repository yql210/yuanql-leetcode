//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。 
//
// 回文串 是正着读和反着读都一样的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：[["a","a","b"],["aa","b"]]
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：[["a"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 16 
// s 仅由小写英文字母组成 
// 
//
// Related Topics 字符串 动态规划 回溯 👍 1589 👎 0

import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtracking(s, 0, new ArrayList<>(), result);
        return result;
    }

    /**
     * 回溯算法
     * @param s 给定的字符串
     * @param start 字符串开始检索的地方
     * @param temp 检索过的路径
     * @param result 最终结果
     */
    private void backtracking(String s, int start, List<String> temp, List<List<String>> result) {

        if (start == s.length()) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            String substring = s.substring(start, i + 1);
            if (!isPalindromic(substring)) continue;
            temp.add(substring);
            backtracking(s, i + 1, temp, result);
            temp.remove(temp.size() - 1);
        }
    }

    /**
     * 判断数据的字符串是否为回文字串
     * @param s 需要验证的字符粗
     * @return 是回文字符粗返回： true；反之返回false
     */
    private boolean isPalindromic(String s) {
        int start = 0, end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
