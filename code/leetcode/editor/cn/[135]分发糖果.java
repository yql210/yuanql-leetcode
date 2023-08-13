//n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。 
//
// 你需要按照以下要求，给这些孩子分发糖果： 
//
// 
// 每个孩子至少分配到 1 个糖果。 
// 相邻两个孩子评分更高的孩子会获得更多的糖果。 
// 
//
// 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。 
//
// 
//
// 示例 1： 
//
// 
//输入：ratings = [1,0,2]
//输出：5
//解释：你可以分别给第一个、第二个、第三个孩子分发 2、1、2 颗糖果。
// 
//
// 示例 2： 
//
// 
//输入：ratings = [1,2,2]
//输出：4
//解释：你可以分别给第一个、第二个、第三个孩子分发 1、2、1 颗糖果。
//     第三个孩子只得到 1 颗糖果，这满足题面中的两个条件。 
//
// 
//
// 提示： 
//
// 
// n == ratings.length 
// 1 <= n <= 2 * 10⁴ 
// 0 <= ratings[i] <= 2 * 10⁴ 
// 
//
// Related Topics 贪心 数组 👍 1269 👎 0


import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int candy(int[] ratings) {
        if (ratings.length == 1) return 1;
        if (ratings.length == 2) {
            if (ratings[0] == ratings[1]) return 2;
            return 3;
        }

        PriorityQueue<Integer[]> queue = new PriorityQueue<>((o1, o2) -> o1[0].compareTo(o2[0]));
        int[] children = new int[ratings.length];
        int sum = 0;

        for (int i = 1; i < ratings.length - 1; i++) {
            queue.offer(new Integer[]{ratings[i], i});
        }
        if (ratings[0] <= ratings[1]) children[0] = 1;
        if (ratings[ratings.length - 1] <= ratings[ratings.length - 2]) children[ratings.length - 1] = 1;

        while (!queue.isEmpty()) {
            int index = queue.poll()[1];

                if (ratings[index] == ratings[index + 1] && ratings[index] == ratings[index - 1]) {
                    children[index] = 1;
                } else if (ratings[index] == ratings[index + 1]){
                    children[index] = children[index - 1] + 1;
                } else if (ratings[index] == ratings[index - 1]){
                    children[index] = children[index + 1] + 1;
                } else {
                    children[index] = Math.max(children[index + 1], children[index - 1]) + 1;
                }

                sum += children[index];

        }

        if (ratings[0] > ratings[1]) sum += children[1] + 1;
        else sum += 1;

        if (ratings[ratings.length - 1] > ratings[ratings.length - 2]) sum += children[ratings.length - 2] + 1;
        else sum += 1;

        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
