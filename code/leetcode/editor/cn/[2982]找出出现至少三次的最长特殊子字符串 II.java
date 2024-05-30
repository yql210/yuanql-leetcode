//给你一个仅由小写英文字母组成的字符串 s 。 
//
// 如果一个字符串仅由单一字符组成，那么它被称为 特殊 字符串。例如，字符串 "abc" 不是特殊字符串，而字符串 "ddd"、"zz" 和 "f" 是特殊字
//符串。 
//
// 返回在 s 中出现 至少三次 的 最长特殊子字符串 的长度，如果不存在出现至少三次的特殊子字符串，则返回 -1 。 
//
// 子字符串 是字符串中的一个连续 非空 字符序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aaaa"
//输出：2
//解释：出现三次的最长特殊子字符串是 "aa" ：子字符串 "aaaa"、"aaaa" 和 "aaaa"。
//可以证明最大长度是 2 。
// 
//
// 示例 2： 
//
// 
//输入：s = "abcdef"
//输出：-1
//解释：不存在出现至少三次的特殊子字符串。因此返回 -1 。
// 
//
// 示例 3： 
//
// 
//输入：s = "abcaba"
//输出：1
//解释：出现三次的最长特殊子字符串是 "a" ：子字符串 "abcaba"、"abcaba" 和 "abcaba"。
//可以证明最大长度是 1 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= s.length <= 5 * 10⁵ 
// s 仅由小写英文字母组成。 
// 
//
// Related Topics 哈希表 字符串 二分查找 计数 滑动窗口 👍 10 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumLength(String s) {
        int ans = -1;
        int[][][] ch_list = new int['z' - 'a' + 1][3][2];
//        List<Integer>[] ch_list = new ArrayList['z' - 'a'+ 1];
        Character ch = s.charAt(0);
        int ch_num = 1;
        ch_list[ch - 'a'][0][0] = 1;
        ch_list[ch - 'a'][0][1]++;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ch) {
                ch_num++;
                for (int j = 0; j < 3; j++) {
                    if (ch_list[ch - 'a'][j][0] == 0) {
                        ch_list[ch - 'a'][j][0] = ch_num;
                        ch_list[ch - 'a'][j][1]++;
                        break;
                    }
                    if (ch_list[ch - 'a'][j][0] <= ch_num) {
                        ch_list[ch - 'a'][j][1]++;
                        if (ch_list[ch - 'a'][j][1] >= 3) {
                            ans = Math.max(ans, ch_list[ch - 'a'][j][0]);
                        }
                    }
                }
                if (ch_list[ch - 'a'][2][0] != 0 && ch_list[ch - 'a'][2][0] < ch_num) {
                    ch_list[ch - 'a'][0][0] = ch_list[ch - 'a'][1][0];
                    ch_list[ch - 'a'][0][1] = ch_list[ch - 'a'][1][1];
                    ch_list[ch - 'a'][1][0] = ch_list[ch - 'a'][2][0];
                    ch_list[ch - 'a'][1][1] = ch_list[ch - 'a'][2][1];
                    ch_list[ch - 'a'][2][0] = ch_num;
                    ch_list[ch - 'a'][2][1] = 1;
                }
            } else {
                ch = s.charAt(i);
                ch_num = 1;
                if (ch_list[ch - 'a'][0][0] == 1) {
                    ch_list[ch - 'a'][0][1]++;
                    if (ch_list[ch - 'a'][0][1] >= 3) {
                        ans = Math.max(ans, 1);
                    }
                } else {
                    ch_list[ch - 'a'][0][0] = 1;
                    ch_list[ch - 'a'][0][1]++;
                }
            }
        }

        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
