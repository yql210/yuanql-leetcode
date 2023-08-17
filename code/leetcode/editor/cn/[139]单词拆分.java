//给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。 
//
// 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。 
//
// 
//
// 示例 1： 
//
// 
//输入: s = "leetcode", wordDict = ["leet", "code"]
//输出: true
//解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
// 
//
// 示例 2： 
//
// 
//输入: s = "applepenapple", wordDict = ["apple", "pen"]
//输出: true
//解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
//     注意，你可以重复使用字典中的单词。
// 
//
// 示例 3： 
//
// 
//输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出: false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 300 
// 1 <= wordDict.length <= 1000 
// 1 <= wordDict[i].length <= 20 
// s 和 wordDict[i] 仅由小写英文字母组成 
// wordDict 中的所有字符串 互不相同 
// 
//
// Related Topics 字典树 记忆化搜索 数组 哈希表 字符串 动态规划 👍 2242 👎 0


//import java.util.ArrayList;
//import java.util.HashMap;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

//    private HashMap<Character, List<String>> wordDictMap = new HashMap<>();  // 回溯算法：超时

    public boolean wordBreak(String s, List<String> wordDict) {
//        for (int i = 0; i < wordDict.size(); i++) {
//            char c = wordDict.get(i).charAt(0);
//
//            if (wordDictMap.containsKey(c)) {
//                wordDictMap.get(c).add(wordDict.get(i));
//            } else {
//                ArrayList<String> strList = new ArrayList<>();
//                strList.add(wordDict.get(i));
//                wordDictMap.put(c, strList);
//            }
//        }
//
//        return backtracking(s, 0);

        boolean[] dp = new boolean[s.length() + 1];

        dp[0] = true;

        for (int j = 0; j < s.length() + 1; j++) {
            for (int i = 0; i < wordDict.size(); i++) {
                int length = wordDict.get(i).length();

                if (j - length >= 0 ) {
                    dp[j] = wordDict.get(i).equals(s.substring(j - length, j)) && dp[j - length] || dp[j];
//                    System.out.println(j - length);
                }
            }

//            for (int k = 0; k < s.length() + 1; k++) {
//                System.out.print(dp[k] + "    ");
//            }
//            System.out.println();

        }

//        for (int j = 0; j < s.length() + 1; j++) {
//            System.out.print(dp[j] + "    ");
//        }
//        System.out.println();
        return dp[s.length()];
    }

//    private boolean backtracking(String s, int index) { // 回溯算法：超时
//        if (index == s.length()) {
//            return true;
//        }
//
//        List<String> stringList = wordDictMap.get(s.charAt(index));
//        if (stringList == null) return false;
//
//        for (String string : stringList) {
////            System.out.println(string);
//            int length = string.length();
//            if (index + length > s.length()) continue;
//            if (s.substring(index, index + length).equals(string)) {
//                if (backtracking(s, index + length)) return true;
//            }
//        }
//        return false;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
