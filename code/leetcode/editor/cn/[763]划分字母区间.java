//给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。 
//
// 注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。 
//
// 返回一个表示每个字符串片段的长度的列表。 
//
// 
//示例 1：
//
// 
//输入：s = "ababcbacadefegdehijhklij"
//输出：[9,7,8]
//解释：
//划分结果为 "ababcbaca"、"defegde"、"hijhklij" 。
//每个字母最多出现在一个片段中。
//像 "ababcbacadefegde", "hijhklij" 这样的划分是错误的，因为划分的片段数较少。 
//
// 示例 2： 
//
// 
//输入：s = "eccbbbbdec"
//输出：[10]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 500 
// s 仅由小写英文字母组成 
// 
//
// Related Topics 贪心 哈希表 双指针 字符串 👍 997 👎 0


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> partitionLabels(String s) {

        List<Character> characterList = new ArrayList<>(26); // 存放字母的放置顺序
        HashMap<Character, Integer[]> hashMap = new HashMap<>(26); // 存放字母可以覆盖的范围

        for (int i = 0; i < s.length(); i++) { // 对上方两个变量进行初始化
            if (!hashMap.containsKey(s.charAt(i))) { // 一个新的字母进来，需要进行重新赋值
                characterList.add(s.charAt(i));
                hashMap.put(s.charAt(i), new Integer[]{i, i});
            } else { // 只需要修改字母覆盖范围的右侧范围
                hashMap.get(s.charAt(i))[1] = i;
            }
        }

        List<Integer> result = new ArrayList<>(); // 存储最终结果
        int indexStart = 0; // 符合条件范围的左开始节点
        int indexEnd = hashMap.get(characterList.get(0))[1]; // 符合条件范围的结束节点

        for (int i = 1; i < characterList.size(); i++) {
            Integer[] integers = hashMap.get(characterList.get(i)); // 按照添加的顺序开始取数据，其实其也是范围左边界的排列顺序
            if (indexEnd > integers[0]) { // 说明此时此字母的范围和上一个字母有重叠
                indexEnd = Math.max(integers[1], indexEnd); // 更新重叠的范围
            } else { // 说明此字母之前的字符串是一个合格的字符串，开始计算结果，并更新数据
                result.add(indexEnd - indexStart + 1); // 更新数据
                indexStart = integers[0]; // 重置范围，开始从此点接续查找
                indexEnd = integers[1];
            }
        }

        result.add(indexEnd - indexStart + 1); // 到最后，依然在两个节点直接保存着一份数据，需要加入进来
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
