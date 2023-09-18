package top.yuanql.yaxinSafe;

/**
 * @BelongsProject: leetcode
 * @BelongsPackage: top.yuanql.yaxinSafe
 * @BelongsClassName: three
 * @Author: yuanql
 * @CreateTime: 2023-09-17  15:14
 * @Description:
 * @Version: 1.0
 */


public class three {

    public char lookup (String s, String t) {
        // write code here

        int[] inputS = new int['z' - 'a' + 1];

        for (int i = 0; i < s.length(); i++) {
            inputS[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            if (inputS[t.charAt(i) - 'a'] > 0) {
                inputS[t.charAt(i) - 'a']--;
            } else {
                return t.charAt(i);
            }
        }

        return '0';

    }
}
