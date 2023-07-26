//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 
//
// 
//
// 注意： 
//
// 
// 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。 
// 如果 s 中存在这样的子串，我们保证它是唯一的答案。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
//解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
//解释：整个字符串 s 是最小覆盖子串。
// 
//
// 示例 3: 
//
// 
//输入: s = "a", t = "aa"
//输出: ""
//解释: t 中两个字符 'a' 均应包含在 s 的子串中，
//因此没有符合条件的子字符串，返回空字符串。 
//
// 
//
// 提示： 
//
// 
// m == s.length 
// n == t.length 
// 1 <= m, n <= 10⁵ 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 
//o(m+n) 时间内解决此问题的算法吗？
//
// Related Topics 哈希表 字符串 滑动窗口 👍 2565 👎 0


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        if (s.equals(t)){
            return s;
        }

        HashMap<Character, Integer> tHashMap = new HashMap<Character, Integer>(); // 记录字符串 t 的字符情况

        for (int i = 0; i < t.length(); i++) {  // 将字符串 t 拆分成一个个字符，放入到HashMap中
            tHashMap.put(t.charAt(i), tHashMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        StringBuilder result = null,  // 最终的返回数值
                temp = new StringBuilder(); // 记录字符数组的中间变量
        int left = 0, // 滑动窗口的左节点，用于窗口收缩
                right = 0, // 滑动窗口的右节点，用于窗口扩大
                tFlag = tHashMap.size(); // 记录HashMap中数值大于 0 的情况

        for (; right < s.length(); right++) { // 此层只用于扩大，所有在其内容去写
            if (tHashMap.containsKey(s.charAt(right))) {
                tHashMap.put(s.charAt(right), tHashMap.get(s.charAt(right)) - 1);
                if (tHashMap.get(s.charAt(right)) == 0) { // 每当有一个数值减到0的时候，就将标志位减一
                    tFlag--;
                }
                if (tFlag == 0) { // 此时需要对滑动窗口进行收缩了
                    temp.append(s.charAt(right)); // 先将最右侧所看到的数据注入进来

                    if (result == null || result.length() > temp.length()) { // 对结果进行更新
                        result = new StringBuilder(temp);
                    }

                    // 正式开始进行窗口收缩
                    while (tFlag == 0 || tFlag == 1) {
                        if (tHashMap.containsKey(s.charAt(left))) {
                            tHashMap.put(s.charAt(left), tHashMap.get(s.charAt(left))  + 1);
                            if (tHashMap.get(s.charAt(left)) == 1) {
                                tFlag++; // 此时窗口中刚刚好不能装下相关的数据，但是目前他temp中的数据刚刚好，所有此时可以更新result
                                if (tFlag == 1 && result.length() > temp.length()) { // 对结果进行更新
                                    result = new StringBuilder(temp);
                                }
                            } else if (tHashMap.get(s.charAt(left)) == 2) { // 此时说明一个字符串尝试弹出去两次，这是不被允许的，直接break
                                left++;
                                tFlag++;
                                if (temp.length() > 1) {
                                    temp.deleteCharAt(0);
                                } else {
                                    temp.deleteCharAt(0);
                                    break;
                                }
                                break;
                            }
                        }
                        left++;
                        if (temp.length() > 1) {
                            temp.deleteCharAt(0);
                        } else {
                            temp.deleteCharAt(0);
                            break;
                        }
                    }

                    // 因为相关数据删多了，需要重新补回来
                    left--;
                    temp.insert(0, s.charAt(left));
                    tHashMap.put(s.charAt(left), tHashMap.get(s.charAt(left)) - 1);
                    tFlag--;

                    temp.deleteCharAt(temp.length() - 1);
                }
            }
            temp.append(s.charAt(right));
        }

        return result == null ? "" : result.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
