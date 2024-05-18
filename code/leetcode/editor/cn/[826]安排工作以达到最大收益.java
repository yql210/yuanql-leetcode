//你有 n 个工作和 m 个工人。给定三个数组： difficulty, profit 和 worker ，其中: 
//
// 
// difficulty[i] 表示第 i 个工作的难度，profit[i] 表示第 i 个工作的收益。 
// worker[i] 是第 i 个工人的能力，即该工人只能完成难度小于等于 worker[i] 的工作。 
// 
//
// 每个工人 最多 只能安排 一个 工作，但是一个工作可以 完成多次 。 
//
// 
// 举个例子，如果 3 个工人都尝试完成一份报酬为 $1 的同样工作，那么总收益为 $3 。如果一个工人不能完成任何工作，他的收益为 $0 。 
// 
//
// 返回 在把工人分配到工作岗位后，我们所能获得的最大利润 。 
//
// 
//
// 示例 1： 
//
// 
//输入: difficulty = [2,4,6,8,10], profit = [10,20,30,40,50], worker = [4,5,6,7]
//输出: 100 
//解释: 工人被分配的工作难度是 [4,4,6,6] ，分别获得 [20,20,30,30] 的收益。 
//
// 示例 2: 
//
// 
//输入: difficulty = [85,47,57], profit = [24,66,99], worker = [40,25,25]
//输出: 0 
//
// 
//
// 提示: 
//
// 
// n == difficulty.length 
// n == profit.length 
// m == worker.length 
// 1 <= n, m <= 10⁴ 
// 1 <= difficulty[i], profit[i], worker[i] <= 10⁵ 
// 
//
// Related Topics 贪心 数组 双指针 二分查找 排序 👍 128 👎 0


import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int result = 0;
        Arrays.sort(worker); // 升序

        Integer[][] word = new Integer[difficulty.length][2];

        for (int i = 0; i < difficulty.length; i++) {
            word[i][0] = difficulty[i];
            word[i][1] = profit[i];
        }

//        Collections.sort(word, (o1 , o2) -> o2[1] - o1[1]); // 只能用于List数组排序

//        Arrays.sort(word, new Comparator<Integer[]>() {
//            @Override
//            public int compare(Integer[] o1, Integer[] o2) {
//                return o1[0] - o2[0];
//            }
//        });

        Arrays.sort(word, (o1, o2) -> o1[1] - o2[1]);
//        System.out.println(word[0][1]);
        int index = word.length - 1;
        for (int i = worker.length - 1; i >= 0; i--) {
            while (index >= 0 && worker[i] < word[index][0]) index--;
            if (index < 0) break;
            result += word[index][1];
        }



        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
