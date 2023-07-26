//给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回 true 。# 代表退格字符。 
//
// 注意：如果对空文本输入退格字符，文本继续为空。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ab#c", t = "ad#c"
//输出：true
//解释：s 和 t 都会变成 "ac"。
// 
//
// 示例 2： 
//
// 
//输入：s = "ab##", t = "c#d#"
//输出：true
//解释：s 和 t 都会变成 ""。
// 
//
// 示例 3： 
//
// 
//输入：s = "a#c", t = "b"
//输出：false
//解释：s 会变成 "c"，但 t 仍然是 "b"。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 200 
// s 和 t 只含有小写字母以及字符 '#' 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以用 O(n) 的时间复杂度和 O(1) 的空间复杂度解决该问题吗？ 
// 
//
// Related Topics 栈 双指针 字符串 模拟 👍 647 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean backspaceCompare(String s, String t) {
        int s_fast = s.length() - 1,  t_fast = t.length() - 1;

        while (true) {
            // 找出字符串 s 的退位之后的值
            s_fast = selectNum(s_fast, s);

            // 找出字符串 t 的退位之后的值
            t_fast = selectNum(t_fast, t);


            // 当两方有一方的数值小于的的时候，意味着此字符串已经没有字符了，如果另外一个还有，就必然是false
            if (s_fast < 0 || t_fast < 0) {
                if (s_fast < 0 && t_fast < 0) {
                    return true;
                }
                return false;
            }

            // 当两个字符串的末尾不相等，则直接意味着 false
            if (s.charAt(s_fast) != t.charAt(t_fast)) {
                return false;
            }

            //当字符串其中一个到达了0 的时候要特殊判断，要不然再下一步进行 减运算的时候就会报错了
            if (s_fast == 0 || t_fast == 0) {
                // 都到了0，万事大吉，直接为 true
                if (s_fast == 0 && t_fast == 0) {
                    return true;
                } else { // 不全为0 的时候就要判断了，只能求另外一个字符有足够多的退位符，当其不足够的时候，代表其长度都不同
                    if (s_fast == 0) {
                        t_fast--;
                        // 找出字符串 t 的退位之后的值
                        t_fast = selectNum(t_fast, t);

                        if (t_fast < 0) { // 此时长度相同，有足够多的退位符，剩下的都是null
                            return true;
                        }
                        return false; // 意味着另外一个字符串中还剩下字符，长度不同
                    } else if (t_fast == 0) {
                        s_fast--;
                        // 找出字符串 s 的退位之后的值
                        s_fast = selectNum(s_fast, s);

                        if (s_fast < 0) {
                            return true;
                        }
                        return false;
                    }
                }
            }
            s_fast--; // 此处字符判断完毕，向前移动一格
            t_fast--;
        }
    }

    public int selectNum(int fast, String s) {
        int slow = fast;

        while (!(slow == fast && s.charAt(slow) != '#')) {
            if (s.charAt(slow) == '#') {
                fast = fast - 2;
                if (fast < 0) {
                    break;
                }
            }
            slow--;
        }
        return fast;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
