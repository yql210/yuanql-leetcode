//给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。 
//
// 回文字符串 是正着读和倒过来读一样的字符串。 
//
// 子字符串 是字符串中的由连续字符组成的一个序列。 
//
// 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abc"
//输出：3
//解释：三个回文子串: "a", "b", "c"
// 
//
// 示例 2： 
//
// 
//输入：s = "aaa"
//输出：6
//解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 由小写英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 1219 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countSubstrings(String s) {
        int result = 1; // 最终结果
        int index = 0;

        List<List<Integer>> dp = new ArrayList<>(s.length()); // dp数组，定义：每一个列表对应着此位所能构成回文字符串的最前端！
        List<Integer> list = new ArrayList<>();
        list.add(0);
        dp.add(list);
        for (int i = 1; i < s.length(); i++) { // 遍历字符串
            List<Integer> dp1 = dp.get(i - 1);
            list = new ArrayList<>();
            result++;
            list.add(i);
            index = 0;

            // 当当前字符与最前面的字符对应的时候，其需要循环的进行判断
            while (i - index > 0 && s.charAt(i) == s.charAt(i - index - 1)) {
                result++;
                list.add(i - index - 1);
                index++;
            }


            for (int j = index; j < dp1.size(); j++) {
                if (dp1.get(j) > 0 && s.charAt(i) == s.charAt(dp1.get(j) - 1)) {
                    result++;
                    list.add(dp1.get(j) - 1);
                }
            }

            dp.add(list);
//            System.out.println("list = " + list);
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
