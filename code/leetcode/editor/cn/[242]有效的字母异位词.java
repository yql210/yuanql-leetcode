//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 
//输入: s = "rat", t = "car"
//输出: false 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, t.length <= 5 * 10⁴ 
// s 和 t 仅包含小写字母 
// 
//
// 
//
// 进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
//
// Related Topics 哈希表 字符串 排序 👍 788 👎 0


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            hashMap.put(s.charAt(i), hashMap.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            if (hashMap.containsKey(t.charAt(i))) {
                hashMap.put(t.charAt(i), hashMap.get(t.charAt(i)) - 1);
                if (hashMap.get(t.charAt(i)) == 0){
                    hashMap.remove(t.charAt(i));
                }
            } else {
                return false;
            }
        }

        if (hashMap.size() != 0) {
            return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
