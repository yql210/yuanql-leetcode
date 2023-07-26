//给你一个二维整数数组 intervals ，其中 intervals[i] = [lefti, righti] 表示第 i 个区间开始于 lefti 、结束
//于 righti（包含两侧取值，闭区间）。区间的 长度 定义为区间中包含的整数数目，更正式地表达是 righti - lefti + 1 。 
//
// 再给你一个整数数组 queries 。第 j 个查询的答案是满足 lefti <= queries[j] <= righti 的 长度最小区间 i 的长度
// 。如果不存在这样的区间，那么答案是 -1 。 
//
// 以数组形式返回对应查询的所有答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,4],[2,4],[3,6],[4,4]], queries = [2,3,4,5]
//输出：[3,3,1,4]
//解释：查询处理如下：
//- Query = 2 ：区间 [2,4] 是包含 2 的最小区间，答案为 4 - 2 + 1 = 3 。
//- Query = 3 ：区间 [2,4] 是包含 3 的最小区间，答案为 4 - 2 + 1 = 3 。
//- Query = 4 ：区间 [4,4] 是包含 4 的最小区间，答案为 4 - 4 + 1 = 1 。
//- Query = 5 ：区间 [3,6] 是包含 5 的最小区间，答案为 6 - 3 + 1 = 4 。
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[2,3],[2,5],[1,8],[20,25]], queries = [2,19,5,22]
//输出：[2,-1,4,6]
//解释：查询处理如下：
//- Query = 2 ：区间 [2,3] 是包含 2 的最小区间，答案为 3 - 2 + 1 = 2 。
//- Query = 19：不存在包含 19 的区间，答案为 -1 。
//- Query = 5 ：区间 [2,5] 是包含 5 的最小区间，答案为 5 - 2 + 1 = 4 。
//- Query = 22：区间 [20,25] 是包含 22 的最小区间，答案为 25 - 20 + 1 = 6 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 10⁵ 
// 1 <= queries.length <= 10⁵ 
// intervals[i].length == 2 
// 1 <= lefti <= righti <= 10⁷ 
// 1 <= queries[j] <= 10⁷ 
// 
//
// Related Topics 数组 二分查找 排序 扫描线 堆（优先队列） 👍 66 👎 0


import java.util.Arrays;
import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int[] result = new int[queries.length]; // 定义结果集

        // 因为涉及到对queries进行排序，所以需要确认当前int数组 索引与数值的对应关系
        int[][] queriesNew = new int[queries.length][2];
        // 将有个 queries 的相关数据放入到二维数组中，第一位放数值，第二位放索引
        for (int i = 0; i < queries.length; i++) {
            queriesNew[i][0] = queries[i];
            queriesNew[i][1] = i;
        }

        Arrays.sort(intervals, (o1, o2) -> (o1[0] - o2[0])); // 排序
        Arrays.sort(queriesNew, (o1, o2) -> (o1[0] - o2[0]));
        Arrays.fill(result, -1); // 将result所有的数值都设置为-1

        // 定义优先队列，排序函数表示将长度小是向上排序
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> (o1[1] - o1[0] - o2[1] + o2[0]));

        int index = 0; // 此处用于记录遍历 intervals 走到了那个坐标下

        for (int i = 0; i < queriesNew.length; i++) { // 对queriesNew数组进行遍历
            // 将左节点全部小于 queriesNew当前值的区间放入到优先队列中
            while (index < intervals.length && intervals[index][0] <= queriesNew[i][0]) {
                queue.add(new int[]{intervals[index][0], intervals[index][1]});
                index++;
            }
            // 将右节点小于 queriesNew当前值的区间舍弃出去，因为前面已经对其进行了排序，所以弹出的区间对应以后的数值也是没有任何作用的
            while (!queue.isEmpty() && queue.peek()[1] < queriesNew[i][0]) {
                queue.poll();
            }
            if (!queue.isEmpty()) { // 如果当前的优先队列不是空的，就说明其是有符合的数据，并且还在首位，所以直接取首位计算数值
                result[queriesNew[i][1]] = queue.peek()[1] - queue.peek()[0] + 1;
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
