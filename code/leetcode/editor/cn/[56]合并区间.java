//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 10⁴ 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 10⁴ 
// 
//
// Related Topics 数组 排序 👍 1982 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
        List<Integer[]> resultList = new ArrayList<>(); // 临时保存结果数据

        // 对数组进行排序
        Arrays.sort(intervals, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
        // 初始化范围的开始和结尾
        int indexStart = intervals[0][0],
            indexEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (indexEnd < intervals[i][0]) { // 说明此时和此范围不重合,开始添加数据
                resultList.add(new Integer[]{indexStart, indexEnd}); // 添加结果
                indexStart = intervals[i][0]; // 重新进行初始化相关的数据信息
                indexEnd = intervals[i][1];
            } else {
                indexEnd = Math.max(indexEnd, intervals[i][1]); // 找到范围的最右侧
            }
        }

        resultList.add(new Integer[]{indexStart, indexEnd}); // 别忘了保存在节点范围中的一组信息

        int[][] result = new int[resultList.size()][2]; // 对结果进行整理

        for (int i = 0; i < result.length; i++) {
            result[i][0] = resultList.get(i)[0];
            result[i][1] = resultList.get(i)[1];
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
