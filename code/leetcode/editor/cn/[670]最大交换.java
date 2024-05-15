//给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。 
//
// 示例 1 : 
//
// 
//输入: 2736
//输出: 7236
//解释: 交换数字2和数字7。
// 
//
// 示例 2 : 
//
// 
//输入: 9973
//输出: 9973
//解释: 不需要交换。
// 
//
// 注意: 
//
// 
// 给定数字的范围是 [0, 10⁸] 
// 
//
// Related Topics 贪心 数学 👍 424 👎 0


import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumSwap(int num) {

//        StringBuilder numStr = new StringBuilder(String.valueOf(num));
//        char start = numStr.charAt(0);
//        char maxChar = '0';
//        int maxIndex = -1;
//
//        for (int i = 1; i < numStr.length(); i++) {
//            if (numStr.charAt(i) > start && numStr.charAt(i) > maxChar) {
//                maxIndex = i;
//                maxChar = numStr.charAt(i);
//            }
//        }
//
//        if (maxIndex != -1) {
//            numStr.replace(0, 1, String.valueOf(maxChar));
//            numStr.replace(maxIndex, maxIndex + 1, String.valueOf(start));
//        }
//
//        return Integer.parseInt(numStr.toString());

        StringBuilder numStr = new StringBuilder(String.valueOf(num)); // 将数据转储为StringBuilder，方便对数值进行换位

        PriorityQueue<Integer[]> queue = new PriorityQueue<>((o1, o2) -> { // 初始化优先队列的相关属性
            int i = o2[0].compareTo(o1[0]); // 第n位的数据从高向底排列
            if (i != 0) return i;
            return o1[1].compareTo(o2[1]); // 第n位的数据相等的时候，按照索引从低向高排列
        });


        for (int i = 0; i < numStr.length(); i++) {
            queue.add(new Integer[]{(int) numStr.charAt(i) - 48, i}); // 安位将数据存储到优先队列中
        }

        int startIndex = 0;
        int maxChar = -1;
        int maxIndex = -1;

        while (!queue.isEmpty()) { // 开始对其进行弹出操作
            Integer[] peek = queue.poll();
            if (peek[1] == startIndex) { // 此时的特殊情况为： 98716 ，其真实的结果是98761，将1和6进行交换
                startIndex++;
            } else {
                maxIndex = peek[1];
                maxChar = peek[0];
                while (!queue.isEmpty()) { // 此时的特殊情况为： 199982 ，其真实的结果是999182，将1和最后一个9进行交换，没有此项，结果将会变为919982
                    Integer[] poll = queue.poll();
                    if (maxChar != poll[0]) break;
                    maxIndex = poll[1];
                }
                break;
            }
        }

        if (maxIndex != -1) {
            int startChar = (int) numStr.charAt(startIndex) - 48;
            numStr.replace(startIndex, startIndex + 1, String.valueOf(maxChar));
            numStr.replace(maxIndex, maxIndex + 1, String.valueOf(startChar));
        }

        return Integer.parseInt(numStr.toString());
    }
}
//leetcode submit region end(Prohibit modification and deletion)
