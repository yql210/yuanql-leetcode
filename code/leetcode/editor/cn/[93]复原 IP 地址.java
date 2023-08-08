//有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。 
//
// 
// 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 
//和 "192.168@1.1" 是 无效 IP 地址。 
// 
//
// 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新
//排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "25525511135"
//输出：["255.255.11.135","255.255.111.35"]
// 
//
// 示例 2： 
//
// 
//输入：s = "0000"
//输出：["0.0.0.0"]
// 
//
// 示例 3： 
//
// 
//输入：s = "101023"
//输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 20 
// s 仅由数字组成 
// 
//
// Related Topics 字符串 回溯 👍 1277 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private List<String> result = new ArrayList<>();

    private List<String> path = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        backtracking(s, 0, 4);
        return result;
    }

    /**
     * 回溯函数
     * @param s 原始的字符粗
     * @param indexStart 字符串开始遍历的位置
     * @param size 当前是路径的第几层，本数据从4开始向下减，而不是进行了递增的操作
     */
    private void backtracking(String s, int indexStart, int size) {
        if (size == 0) { // size从4开始递减
            if (indexStart == s.length())
                result.add(stringBuilderConnect()); // 想结果集中添加符合的内容
            return;
        }

        for (int i = indexStart; i < indexStart + 3 && i < s.length() - size + 1; i++) { // 剪枝
            String substring = s.substring(indexStart, i + 1);
            if (isNotAvailable(substring)) break;
            path.add(substring);
            backtracking(s, i + 1, size - 1);
            path.remove(path.size() - 1);
        }
    }

    /**
     * 判断输入的字符串是否可以作为IP地址的某一位
     * @param string 输入的字符串
     * @return 如果符合IP地址规范，返回false，否则返回true
     */
    private boolean isNotAvailable(String string) {
        if (string.charAt(0) == '0' && string.length() > 1) return true;
        int integer = Integer.parseInt(string);
        return integer > 255;
    }

    /**
     * 用于将path路径拼接成正常的IP地址样式
     * @return 返回正常的IP地址字符串
     */
    private String stringBuilderConnect() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < path.size() - 1; i++) {
            result.append(path.get(i)).append(".");
        }
        result.append(path.get(path.size() - 1));
        return result.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
