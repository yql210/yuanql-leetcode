//给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。 
//
// 
// 如果剩余字符少于 k 个，则将剩余字符全部反转。 
// 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abcdefg", k = 2
//输出："bacdfeg"
// 
//
// 示例 2： 
//
// 
//输入：s = "abcd", k = 2
//输出："bacd"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由小写英文组成 
// 1 <= k <= 10⁴ 
// 
//
// Related Topics 双指针 字符串 👍 476 👎 0


import java.awt.*;
import java.security.Key;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseStr(String s, int k) {
        int length = s.length(), // 字符串s的长度
                left, right, // 交换字符串使用的双指针
                index = 0; // 记录第几个循环

        char temp; // 交换时的临时变量
        StringBuilder result = new StringBuilder(s);

        for (; (2 * k * (index + 1)) < length; index++) {
            left = 2 * k * index;
            right = 2 * k * index + k - 1;
            reverse(left, right, result);
        }

        if ((2 * k * index + k) < length) {
            left = 2 * k * index;
            right = 2 * k * index + k - 1;
            reverse(left, right, result);
        } else {
            left = 2 * k * index;
            right = length - 1;
            reverse(left, right, result);
        }
        return result.toString();
    }

    private void reverse(int left, int right, StringBuilder result) {
        char temp; // 交换时的临时变量
        while (left < right) {
            temp = result.charAt(left);
            result.setCharAt(left, result.charAt(right));
            result.setCharAt(right, temp);
            left++;
            right--;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
