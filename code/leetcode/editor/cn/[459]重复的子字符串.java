//给定一个非空的字符串
// s ，检查是否可以通过由它的一个子串重复多次构成。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abab"
//输出: true
//解释: 可由子串 "ab" 重复两次构成。
// 
//
// 示例 2: 
//
// 
//输入: s = "aba"
//输出: false
// 
//
// 示例 3: 
//
// 
//输入: s = "abcabcabcabc"
//输出: true
//解释: 可由子串 "abc" 重复四次构成。 (或子串 "abcabc" 重复两次构成。)
// 
//
// 
//
// 提示： 
//
// 
// 
//
// 
// 1 <= s.length <= 10⁴ 
// s 由小写英文字母组成 
// 
//
// Related Topics 字符串 字符串匹配 👍 981 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int[] countNext = contNext(s);
        int length = s.length();


        return countNext[length - 1] != 0 && length % (length - countNext[length - 1]) == 0;
    }

    private static int[] contNext(String input) {
        int[] result = new int[input.length()];

        int i = 1, j = 0;
        for (; i < input.length(); i++) {
            j = result[i - 1];
            while (j != 0 && input.charAt(j) != input.charAt(i)) {
                j = result[j - 1];
            }
            if (input.charAt(j) == input.charAt(i)) {
                result[i] = ++j;
            }
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
