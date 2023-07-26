/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 */

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {

        HashMap<Character, Integer> hashMap = new HashMap<>();

        char[] charArray = s.toCharArray();
        for (Character c: charArray) {
            System.out.println(c);
            if (hashMap.containsKey(c)){
                hashMap.replace(c, hashMap.get(c) + 1);
            } else {
                hashMap.put(c, 1);
            }
        }

        char[] charArray1 = t.toCharArray();
        for (Character c: charArray1) {
            if (hashMap.containsKey(c)){
                hashMap.replace(c, hashMap.get(c) - 1);
            } else {
                return false;
            }
        }

        for (Map.Entry<Character, Integer> map : hashMap.entrySet()) {
            if (map.getValue() != 0) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

