//给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。 
//
// 如果可以，返回 true ；否则返回 false 。 
//
// magazine 中的每个字符只能在 ransomNote 中使用一次。 
//
// 
//
// 示例 1： 
//
// 
//输入：ransomNote = "a", magazine = "b"
//输出：false
// 
//
// 示例 2： 
//
// 
//输入：ransomNote = "aa", magazine = "ab"
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：ransomNote = "aa", magazine = "aab"
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= ransomNote.length, magazine.length <= 10⁵ 
// ransomNote 和 magazine 由小写英文字母组成 
// 
//
// Related Topics 哈希表 字符串 计数 👍 736 👎 0


import java.util.Map;
import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {

        HashMap<Character, Integer> hashMap = new HashMap<>();
        Character temp = '1';
        for (int i = 0; i < magazine.length(); i++) {
            temp = magazine.charAt(i);
            hashMap.put(temp, hashMap.getOrDefault(temp, 0) + 1);
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            temp = ransomNote.charAt(i);
            if (hashMap.containsKey(temp)) {
                hashMap.put(temp, hashMap.get(temp) - 1);
                if (hashMap.get(temp) == 0) {
                    hashMap.remove(temp);
                }
            } else {
                return false;
            }
        }

        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
