//你会得到一个字符串 s (索引从 0 开始)，你必须对它执行 k 个替换操作。替换操作以三个长度均为 k 的并行数组给出：indices, sources,
// targets。 
//
// 要完成第 i 个替换操作: 
//
// 
// 检查 子字符串 sources[i] 是否出现在 原字符串 s 的索引 indices[i] 处。 
// 如果没有出现， 什么也不做 。 
// 如果出现，则用 targets[i] 替换 该子字符串。 
// 
//
// 例如，如果 s = "abcd" ， indices[i] = 0 , sources[i] = "ab"， targets[i] = "eee" ，那么
//替换的结果将是 "eeecd" 。 
//
// 所有替换操作必须 同时 发生，这意味着替换操作不应该影响彼此的索引。测试用例保证元素间不会重叠 。 
//
// 
// 例如，一个 s = "abc" ， indices = [0,1] ， sources = ["ab"，"bc"] 的测试用例将不会生成，因为 "ab" 
//和 "bc" 替换重叠。 
// 
//
// 在对 s 执行所有替换操作后返回 结果字符串 。 
//
// 子字符串 是字符串中连续的字符序列。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：s = "abcd", indexes = [0,2], sources = ["a","cd"], targets = ["eee","ffff"]
//
//输出："eeebffff"
//解释：
//"a" 从 s 中的索引 0 开始，所以它被替换为 "eee"。
//"cd" 从 s 中的索引 2 开始，所以它被替换为 "ffff"。
// 
//
// 示例 2： 
//
// 
//输入：s = "abcd", indexes = [0,2], sources = ["ab","ec"], targets = ["eee",
//"ffff"]
//输出："eeecd"
//解释：
//"ab" 从 s 中的索引 0 开始，所以它被替换为 "eee"。
//"ec" 没有从原始的 S 中的索引 2 开始，所以它没有被替换。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// k == indices.length == sources.length == targets.length 
// 1 <= k <= 100 
// 0 <= indexes[i] < s.length 
// 1 <= sources[i].length, targets[i].length <= 50 
// s 仅由小写英文字母组成 
// sources[i] 和 targets[i] 仅由小写英文字母组成 
// 
//
// Related Topics 数组 字符串 排序 👍 94 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        StringBuilder result = new StringBuilder(s);
        int changeIndex = 0;
        boolean flag = false;

        int[][] indicesIndex = new int[indices.length][2]; // 准备一个中间的变量，用于保存原始的位置信息和数值信息
        for (int i = 0; i < indices.length; i++) {
            indicesIndex[i][0] = indices[i];
            indicesIndex[i][1] = i;
        }
        Arrays.sort(indicesIndex, (o1, o2) -> o1[0] - o2[0]); // 对其进行排序

        for (int i = 0; i < indicesIndex.length; i++) {

            while (i < indicesIndex.length - 1 && indicesIndex[i][0] + sources[indicesIndex[i][1]].length() > indicesIndex[i + 1][0]) { // 判断是否右冲突的情况
                i++;
                flag = true;
            }
            if (false) { // 此时i也是冲突的，需要跳过去
                i++;
                flag = false;
                continue;
            }

            //将原始的字符串进行切分，判断其是否等于 sources 中的数据
            if (result.substring(changeIndex + indicesIndex[i][0], changeIndex + indicesIndex[i][0] + sources[indicesIndex[i][1]].length()).equals(sources[indicesIndex[i][1]])) {
                result.delete(changeIndex + indicesIndex[i][0], changeIndex + indicesIndex[i][0] + sources[indicesIndex[i][1]].length()); // 删除原有的数据
                result.insert(changeIndex + indicesIndex[i][0], targets[indicesIndex[i][1]]); // 添加上需要添加的数据
                changeIndex += targets[indicesIndex[i][1]].length() - sources[indicesIndex[i][1]].length(); // 更新与原字符串相比，其增加或者减少了多少位
            }
        }
        
        return result.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
